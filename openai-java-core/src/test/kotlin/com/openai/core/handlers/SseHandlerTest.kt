package com.openai.core.handlers

import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import com.openai.core.http.HttpResponse
import com.openai.core.http.SseMessage
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIException
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.util.stream.Collectors.toList
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class SseHandlerTest {

    enum class TestCase(
        internal val body: String,
        internal val expectedMessages: List<SseMessage>? = null,
        internal val expectedException: Exception? = null
    ) {
        DATA_MISSING_EVENT(
            buildString {
                append("data: {\"foo\":true}\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("{\"foo\":true}").build())
        ),
        MULTIPLE_DATA_MISSING_EVENT(
            buildString {
                append("data: {\"foo\":true}\n")
                append("\n")
                append("data: {\"bar\":false}\n")
                append("\n")
            },
            listOf(
                sseMessageBuilder().data("{\"foo\":true}").build(),
                sseMessageBuilder().data("{\"bar\":false}").build()
            )
        ),
        DATA_JSON_ESCAPED_DOUBLE_NEW_LINE(
            buildString {
                append("data: {\n")
                append("data: \"foo\":\n")
                append("data: true}\n")
                append("\n\n")
            },
            listOf(sseMessageBuilder().data("{\n\"foo\":\ntrue}").build())
        ),
        MULTIPLE_DATA_LINES(
            buildString {
                append("data: {\n")
                append("data: \"foo\":\n")
                append("data: true}\n")
                append("\n\n")
            },
            listOf(sseMessageBuilder().data("{\n\"foo\":\ntrue}").build())
        ),
        SPECIAL_NEW_LINE_CHARACTER(
            buildString {
                append("data: {\"content\":\" culpa\"}\n")
                append("\n")
                append("data: {\"content\":\" \u2028\"}\n")
                append("\n")
                append("data: {\"content\":\"foo\"}\n")
                append("\n")
            },
            listOf(
                sseMessageBuilder().data("{\"content\":\" culpa\"}").build(),
                sseMessageBuilder().data("{\"content\":\" \u2028\"}").build(),
                sseMessageBuilder().data("{\"content\":\"foo\"}").build()
            )
        ),
        MULTI_BYTE_CHARACTER(
            buildString {
                append("data: {\"content\":\"\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0438\"}\n")
                append("\n")
            },
            listOf(sseMessageBuilder().data("{\"content\":\"известни\"}").build())
        ),
        STRING_ERROR_PROPERTY(
            buildString {
                append("data: {\"error\":\"ERROR!\"}\n")
                append("\n")
            },
            expectedException = OpenAIException("ERROR!")
        ),
        ERROR_PROPERTY_WITH_MESSAGE(
            buildString {
                append("data: {\"error\":{\"message\":\"ERROR!\"}}\n")
                append("\n")
            },
            expectedException = OpenAIException("ERROR!")
        ),
        ERROR_PROPERTY_MALFORMED(
            buildString {
                append("data: {\"error\":42}\n")
                append("\n")
            },
            expectedException = OpenAIException("An error occurred during streaming")
        )
    }

    @ParameterizedTest
    @EnumSource
    fun handle(testCase: TestCase) {
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 0

                override fun headers(): ListMultimap<String, String> = ImmutableListMultimap.of()

                override fun body(): InputStream =
                    ByteArrayInputStream(testCase.body.toByteArray(StandardCharsets.UTF_8))

                override fun close() {}
            }
        var messages: List<SseMessage>? = null
        var exception: Exception? = null

        try {
            messages =
                sseHandler(jsonMapper()).handle(response).use { it.stream().collect(toList()) }
        } catch (e: Exception) {
            exception = e
        }

        if (testCase.expectedMessages != null) {
            assertThat(messages).containsExactlyElementsOf(testCase.expectedMessages)
        }
        if (testCase.expectedException != null) {
            assertThat(exception).isInstanceOf(testCase.expectedException.javaClass)
            assertThat(exception).hasMessage(testCase.expectedException.message)
        }
    }
}

private fun sseMessageBuilder() = SseMessage.builder().jsonMapper(jsonMapper())

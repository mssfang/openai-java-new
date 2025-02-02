// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@JsonDeserialize(using = ChatCompletionMessageParam.Deserializer::class)
@JsonSerialize(using = ChatCompletionMessageParam.Serializer::class)
class ChatCompletionMessageParam
private constructor(
    private val chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam? = null,
    private val chatCompletionUserMessageParam: ChatCompletionUserMessageParam? = null,
    private val chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam? = null,
    private val chatCompletionToolMessageParam: ChatCompletionToolMessageParam? = null,
    private val chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    fun chatCompletionSystemMessageParam(): Optional<ChatCompletionSystemMessageParam> =
        Optional.ofNullable(chatCompletionSystemMessageParam)

    fun chatCompletionUserMessageParam(): Optional<ChatCompletionUserMessageParam> =
        Optional.ofNullable(chatCompletionUserMessageParam)

    fun chatCompletionAssistantMessageParam(): Optional<ChatCompletionAssistantMessageParam> =
        Optional.ofNullable(chatCompletionAssistantMessageParam)

    fun chatCompletionToolMessageParam(): Optional<ChatCompletionToolMessageParam> =
        Optional.ofNullable(chatCompletionToolMessageParam)

    fun chatCompletionFunctionMessageParam(): Optional<ChatCompletionFunctionMessageParam> =
        Optional.ofNullable(chatCompletionFunctionMessageParam)

    fun isChatCompletionSystemMessageParam(): Boolean = chatCompletionSystemMessageParam != null

    fun isChatCompletionUserMessageParam(): Boolean = chatCompletionUserMessageParam != null

    fun isChatCompletionAssistantMessageParam(): Boolean =
        chatCompletionAssistantMessageParam != null

    fun isChatCompletionToolMessageParam(): Boolean = chatCompletionToolMessageParam != null

    fun isChatCompletionFunctionMessageParam(): Boolean = chatCompletionFunctionMessageParam != null

    fun asChatCompletionSystemMessageParam(): ChatCompletionSystemMessageParam =
        chatCompletionSystemMessageParam.getOrThrow("chatCompletionSystemMessageParam")

    fun asChatCompletionUserMessageParam(): ChatCompletionUserMessageParam =
        chatCompletionUserMessageParam.getOrThrow("chatCompletionUserMessageParam")

    fun asChatCompletionAssistantMessageParam(): ChatCompletionAssistantMessageParam =
        chatCompletionAssistantMessageParam.getOrThrow("chatCompletionAssistantMessageParam")

    fun asChatCompletionToolMessageParam(): ChatCompletionToolMessageParam =
        chatCompletionToolMessageParam.getOrThrow("chatCompletionToolMessageParam")

    fun asChatCompletionFunctionMessageParam(): ChatCompletionFunctionMessageParam =
        chatCompletionFunctionMessageParam.getOrThrow("chatCompletionFunctionMessageParam")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            chatCompletionSystemMessageParam != null ->
                visitor.visitChatCompletionSystemMessageParam(chatCompletionSystemMessageParam)
            chatCompletionUserMessageParam != null ->
                visitor.visitChatCompletionUserMessageParam(chatCompletionUserMessageParam)
            chatCompletionAssistantMessageParam != null ->
                visitor.visitChatCompletionAssistantMessageParam(
                    chatCompletionAssistantMessageParam
                )
            chatCompletionToolMessageParam != null ->
                visitor.visitChatCompletionToolMessageParam(chatCompletionToolMessageParam)
            chatCompletionFunctionMessageParam != null ->
                visitor.visitChatCompletionFunctionMessageParam(chatCompletionFunctionMessageParam)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ChatCompletionMessageParam = apply {
        if (!validated) {
            if (
                chatCompletionSystemMessageParam == null &&
                    chatCompletionUserMessageParam == null &&
                    chatCompletionAssistantMessageParam == null &&
                    chatCompletionToolMessageParam == null &&
                    chatCompletionFunctionMessageParam == null
            ) {
                throw OpenAIInvalidDataException("Unknown ChatCompletionMessageParam: $_json")
            }
            chatCompletionSystemMessageParam?.validate()
            chatCompletionUserMessageParam?.validate()
            chatCompletionAssistantMessageParam?.validate()
            chatCompletionToolMessageParam?.validate()
            chatCompletionFunctionMessageParam?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionMessageParam && this.chatCompletionSystemMessageParam == other.chatCompletionSystemMessageParam && this.chatCompletionUserMessageParam == other.chatCompletionUserMessageParam && this.chatCompletionAssistantMessageParam == other.chatCompletionAssistantMessageParam && this.chatCompletionToolMessageParam == other.chatCompletionToolMessageParam && this.chatCompletionFunctionMessageParam == other.chatCompletionFunctionMessageParam /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(chatCompletionSystemMessageParam, chatCompletionUserMessageParam, chatCompletionAssistantMessageParam, chatCompletionToolMessageParam, chatCompletionFunctionMessageParam) /* spotless:on */
    }

    override fun toString(): String {
        return when {
            chatCompletionSystemMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionSystemMessageParam=$chatCompletionSystemMessageParam}"
            chatCompletionUserMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionUserMessageParam=$chatCompletionUserMessageParam}"
            chatCompletionAssistantMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionAssistantMessageParam=$chatCompletionAssistantMessageParam}"
            chatCompletionToolMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionToolMessageParam=$chatCompletionToolMessageParam}"
            chatCompletionFunctionMessageParam != null ->
                "ChatCompletionMessageParam{chatCompletionFunctionMessageParam=$chatCompletionFunctionMessageParam}"
            _json != null -> "ChatCompletionMessageParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
        }
    }

    companion object {

        @JvmStatic
        fun ofChatCompletionSystemMessageParam(
            chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionSystemMessageParam = chatCompletionSystemMessageParam
            )

        @JvmStatic
        fun ofChatCompletionUserMessageParam(
            chatCompletionUserMessageParam: ChatCompletionUserMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionUserMessageParam = chatCompletionUserMessageParam
            )

        @JvmStatic
        fun ofChatCompletionAssistantMessageParam(
            chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionAssistantMessageParam = chatCompletionAssistantMessageParam
            )

        @JvmStatic
        fun ofChatCompletionToolMessageParam(
            chatCompletionToolMessageParam: ChatCompletionToolMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionToolMessageParam = chatCompletionToolMessageParam
            )

        @JvmStatic
        fun ofChatCompletionFunctionMessageParam(
            chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam
        ) =
            ChatCompletionMessageParam(
                chatCompletionFunctionMessageParam = chatCompletionFunctionMessageParam
            )
    }

    interface Visitor<out T> {

        fun visitChatCompletionSystemMessageParam(
            chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam
        ): T

        fun visitChatCompletionUserMessageParam(
            chatCompletionUserMessageParam: ChatCompletionUserMessageParam
        ): T

        fun visitChatCompletionAssistantMessageParam(
            chatCompletionAssistantMessageParam: ChatCompletionAssistantMessageParam
        ): T

        fun visitChatCompletionToolMessageParam(
            chatCompletionToolMessageParam: ChatCompletionToolMessageParam
        ): T

        fun visitChatCompletionFunctionMessageParam(
            chatCompletionFunctionMessageParam: ChatCompletionFunctionMessageParam
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ChatCompletionMessageParam: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ChatCompletionMessageParam {
            val json = JsonValue.fromJsonNode(node)
            val role = json.asObject().getOrNull()?.get("role")?.asString()?.getOrNull()

            when (role) {
                "system" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionSystemMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionSystemMessageParam = it,
                                _json = json
                            )
                        }
                }
                "user" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionUserMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionUserMessageParam = it,
                                _json = json
                            )
                        }
                }
                "assistant" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionAssistantMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionAssistantMessageParam = it,
                                _json = json
                            )
                        }
                }
                "tool" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionToolMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionToolMessageParam = it,
                                _json = json
                            )
                        }
                }
                "function" -> {
                    tryDeserialize(node, jacksonTypeRef<ChatCompletionFunctionMessageParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return ChatCompletionMessageParam(
                                chatCompletionFunctionMessageParam = it,
                                _json = json
                            )
                        }
                }
            }

            return ChatCompletionMessageParam(_json = json)
        }
    }

    class Serializer :
        BaseSerializer<ChatCompletionMessageParam>(ChatCompletionMessageParam::class) {

        override fun serialize(
            value: ChatCompletionMessageParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.chatCompletionSystemMessageParam != null ->
                    generator.writeObject(value.chatCompletionSystemMessageParam)
                value.chatCompletionUserMessageParam != null ->
                    generator.writeObject(value.chatCompletionUserMessageParam)
                value.chatCompletionAssistantMessageParam != null ->
                    generator.writeObject(value.chatCompletionAssistantMessageParam)
                value.chatCompletionToolMessageParam != null ->
                    generator.writeObject(value.chatCompletionToolMessageParam)
                value.chatCompletionFunctionMessageParam != null ->
                    generator.writeObject(value.chatCompletionFunctionMessageParam)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ChatCompletionMessageParam")
            }
        }
    }
}

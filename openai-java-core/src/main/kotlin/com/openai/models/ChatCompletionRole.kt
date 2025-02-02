// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException

class ChatCompletionRole
@JsonCreator
private constructor(
    private val value: JsonField<String>,
) : Enum {

    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionRole && this.value == other.value /* spotless:on */
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {

        @JvmField val SYSTEM = ChatCompletionRole(JsonField.of("system"))

        @JvmField val USER = ChatCompletionRole(JsonField.of("user"))

        @JvmField val ASSISTANT = ChatCompletionRole(JsonField.of("assistant"))

        @JvmField val TOOL = ChatCompletionRole(JsonField.of("tool"))

        @JvmField val FUNCTION = ChatCompletionRole(JsonField.of("function"))

        @JvmStatic fun of(value: String) = ChatCompletionRole(JsonField.of(value))
    }

    enum class Known {
        SYSTEM,
        USER,
        ASSISTANT,
        TOOL,
        FUNCTION,
    }

    enum class Value {
        SYSTEM,
        USER,
        ASSISTANT,
        TOOL,
        FUNCTION,
        _UNKNOWN,
    }

    fun value(): Value =
        when (this) {
            SYSTEM -> Value.SYSTEM
            USER -> Value.USER
            ASSISTANT -> Value.ASSISTANT
            TOOL -> Value.TOOL
            FUNCTION -> Value.FUNCTION
            else -> Value._UNKNOWN
        }

    fun known(): Known =
        when (this) {
            SYSTEM -> Known.SYSTEM
            USER -> Known.USER
            ASSISTANT -> Known.ASSISTANT
            TOOL -> Known.TOOL
            FUNCTION -> Known.FUNCTION
            else -> throw OpenAIInvalidDataException("Unknown ChatCompletionRole: $value")
        }

    fun asString(): String = _value().asStringOrThrow()
}

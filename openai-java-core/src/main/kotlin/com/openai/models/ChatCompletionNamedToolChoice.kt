// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

/** Specifies a tool the model should use. Use to force the model to call a specific function. */
@JsonDeserialize(builder = ChatCompletionNamedToolChoice.Builder::class)
@NoAutoDetect
class ChatCompletionNamedToolChoice
private constructor(
    private val type: JsonField<Type>,
    private val function: JsonField<Function>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The type of the tool. Currently, only `function` is supported. */
    fun type(): Type = type.getRequired("type")

    fun function(): Function = function.getRequired("function")

    /** The type of the tool. Currently, only `function` is supported. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("function") @ExcludeMissing fun _function() = function

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionNamedToolChoice = apply {
        if (!validated) {
            type()
            function().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var function: JsonField<Function> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionNamedToolChoice: ChatCompletionNamedToolChoice) = apply {
            this.type = chatCompletionNamedToolChoice.type
            this.function = chatCompletionNamedToolChoice.function
            additionalProperties(chatCompletionNamedToolChoice.additionalProperties)
        }

        /** The type of the tool. Currently, only `function` is supported. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the tool. Currently, only `function` is supported. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun function(function: Function) = function(JsonField.of(function))

        @JsonProperty("function")
        @ExcludeMissing
        fun function(function: JsonField<Function>) = apply { this.function = function }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): ChatCompletionNamedToolChoice =
            ChatCompletionNamedToolChoice(
                type,
                function,
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = Function.Builder::class)
    @NoAutoDetect
    class Function
    private constructor(
        private val name: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** The name of the function to call. */
        fun name(): String = name.getRequired("name")

        /** The name of the function to call. */
        @JsonProperty("name") @ExcludeMissing fun _name() = name

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Function = apply {
            if (!validated) {
                name()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var name: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(function: Function) = apply {
                this.name = function.name
                additionalProperties(function.additionalProperties)
            }

            /** The name of the function to call. */
            fun name(name: String) = name(JsonField.of(name))

            /** The name of the function to call. */
            @JsonProperty("name")
            @ExcludeMissing
            fun name(name: JsonField<String>) = apply { this.name = name }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                this.additionalProperties.putAll(additionalProperties)
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun build(): Function = Function(name, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Function && this.name == other.name && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(name, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() = "Function{name=$name, additionalProperties=$additionalProperties}"
    }

    class Type
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Type && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val FUNCTION = Type(JsonField.of("function"))

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            FUNCTION,
        }

        enum class Value {
            FUNCTION,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                FUNCTION -> Value.FUNCTION
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                FUNCTION -> Known.FUNCTION
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionNamedToolChoice && this.type == other.type && this.function == other.function && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(type, function, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionNamedToolChoice{type=$type, function=$function, additionalProperties=$additionalProperties}"
}

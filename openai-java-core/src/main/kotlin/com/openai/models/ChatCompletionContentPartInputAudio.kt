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

/** Learn about [audio inputs](https://platform.openai.com/docs/guides/audio). */
@JsonDeserialize(builder = ChatCompletionContentPartInputAudio.Builder::class)
@NoAutoDetect
class ChatCompletionContentPartInputAudio
private constructor(
    private val type: JsonField<Type>,
    private val inputAudio: JsonField<InputAudio>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The type of the content part. Always `input_audio`. */
    fun type(): Type = type.getRequired("type")

    fun inputAudio(): InputAudio = inputAudio.getRequired("input_audio")

    /** The type of the content part. Always `input_audio`. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    @JsonProperty("input_audio") @ExcludeMissing fun _inputAudio() = inputAudio

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionContentPartInputAudio = apply {
        if (!validated) {
            type()
            inputAudio().validate()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var type: JsonField<Type> = JsonMissing.of()
        private var inputAudio: JsonField<InputAudio> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            chatCompletionContentPartInputAudio: ChatCompletionContentPartInputAudio
        ) = apply {
            this.type = chatCompletionContentPartInputAudio.type
            this.inputAudio = chatCompletionContentPartInputAudio.inputAudio
            additionalProperties(chatCompletionContentPartInputAudio.additionalProperties)
        }

        /** The type of the content part. Always `input_audio`. */
        fun type(type: Type) = type(JsonField.of(type))

        /** The type of the content part. Always `input_audio`. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<Type>) = apply { this.type = type }

        fun inputAudio(inputAudio: InputAudio) = inputAudio(JsonField.of(inputAudio))

        @JsonProperty("input_audio")
        @ExcludeMissing
        fun inputAudio(inputAudio: JsonField<InputAudio>) = apply { this.inputAudio = inputAudio }

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

        fun build(): ChatCompletionContentPartInputAudio =
            ChatCompletionContentPartInputAudio(
                type,
                inputAudio,
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = InputAudio.Builder::class)
    @NoAutoDetect
    class InputAudio
    private constructor(
        private val data: JsonField<String>,
        private val format: JsonField<Format>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** Base64 encoded audio data. */
        fun data(): String = data.getRequired("data")

        /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
        fun format(): Format = format.getRequired("format")

        /** Base64 encoded audio data. */
        @JsonProperty("data") @ExcludeMissing fun _data() = data

        /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
        @JsonProperty("format") @ExcludeMissing fun _format() = format

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): InputAudio = apply {
            if (!validated) {
                data()
                format()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<String> = JsonMissing.of()
            private var format: JsonField<Format> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputAudio: InputAudio) = apply {
                this.data = inputAudio.data
                this.format = inputAudio.format
                additionalProperties(inputAudio.additionalProperties)
            }

            /** Base64 encoded audio data. */
            fun data(data: String) = data(JsonField.of(data))

            /** Base64 encoded audio data. */
            @JsonProperty("data")
            @ExcludeMissing
            fun data(data: JsonField<String>) = apply { this.data = data }

            /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
            fun format(format: Format) = format(JsonField.of(format))

            /** The format of the encoded audio data. Currently supports "wav" and "mp3". */
            @JsonProperty("format")
            @ExcludeMissing
            fun format(format: JsonField<Format>) = apply { this.format = format }

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

            fun build(): InputAudio =
                InputAudio(
                    data,
                    format,
                    additionalProperties.toImmutable(),
                )
        }

        class Format
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Format && this.value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val WAV = Format(JsonField.of("wav"))

                @JvmField val MP3 = Format(JsonField.of("mp3"))

                @JvmStatic fun of(value: String) = Format(JsonField.of(value))
            }

            enum class Known {
                WAV,
                MP3,
            }

            enum class Value {
                WAV,
                MP3,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    WAV -> Value.WAV
                    MP3 -> Value.MP3
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    WAV -> Known.WAV
                    MP3 -> Known.MP3
                    else -> throw OpenAIInvalidDataException("Unknown Format: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InputAudio && this.data == other.data && this.format == other.format && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(data, format, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "InputAudio{data=$data, format=$format, additionalProperties=$additionalProperties}"
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

            @JvmField val INPUT_AUDIO = Type(JsonField.of("input_audio"))

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        enum class Known {
            INPUT_AUDIO,
        }

        enum class Value {
            INPUT_AUDIO,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                INPUT_AUDIO -> Value.INPUT_AUDIO
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                INPUT_AUDIO -> Known.INPUT_AUDIO
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionContentPartInputAudio && this.type == other.type && this.inputAudio == other.inputAudio && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(type, inputAudio, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionContentPartInputAudio{type=$type, inputAudio=$inputAudio, additionalProperties=$additionalProperties}"
}

// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(builder = ChatCompletionSystemMessageParam.Builder::class)
@NoAutoDetect
class ChatCompletionSystemMessageParam
private constructor(
    private val content: JsonField<Content>,
    private val role: JsonField<Role>,
    private val name: JsonField<String>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The contents of the system message. */
    fun content(): Content = content.getRequired("content")

    /** The role of the messages author, in this case `system`. */
    fun role(): Role = role.getRequired("role")

    /**
     * An optional name for the participant. Provides the model information to differentiate between
     * participants of the same role.
     */
    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    /** The contents of the system message. */
    @JsonProperty("content") @ExcludeMissing fun _content() = content

    /** The role of the messages author, in this case `system`. */
    @JsonProperty("role") @ExcludeMissing fun _role() = role

    /**
     * An optional name for the participant. Provides the model information to differentiate between
     * participants of the same role.
     */
    @JsonProperty("name") @ExcludeMissing fun _name() = name

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionSystemMessageParam = apply {
        if (!validated) {
            content()
            role()
            name()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var content: JsonField<Content> = JsonMissing.of()
        private var role: JsonField<Role> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionSystemMessageParam: ChatCompletionSystemMessageParam) =
            apply {
                this.content = chatCompletionSystemMessageParam.content
                this.role = chatCompletionSystemMessageParam.role
                this.name = chatCompletionSystemMessageParam.name
                additionalProperties(chatCompletionSystemMessageParam.additionalProperties)
            }

        /** The contents of the system message. */
        fun content(content: Content) = content(JsonField.of(content))

        /** The contents of the system message. */
        @JsonProperty("content")
        @ExcludeMissing
        fun content(content: JsonField<Content>) = apply { this.content = content }

        /** The role of the messages author, in this case `system`. */
        fun role(role: Role) = role(JsonField.of(role))

        /** The role of the messages author, in this case `system`. */
        @JsonProperty("role")
        @ExcludeMissing
        fun role(role: JsonField<Role>) = apply { this.role = role }

        /**
         * An optional name for the participant. Provides the model information to differentiate
         * between participants of the same role.
         */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * An optional name for the participant. Provides the model information to differentiate
         * between participants of the same role.
         */
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

        fun build(): ChatCompletionSystemMessageParam =
            ChatCompletionSystemMessageParam(
                content,
                role,
                name,
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(using = Content.Deserializer::class)
    @JsonSerialize(using = Content.Serializer::class)
    class Content
    private constructor(
        private val textContent: String? = null,
        private val arrayOfContentParts: List<ChatCompletionContentPartText>? = null,
        private val _json: JsonValue? = null,
    ) {

        private var validated: Boolean = false

        /** The contents of the system message. */
        fun textContent(): Optional<String> = Optional.ofNullable(textContent)
        /**
         * An array of content parts with a defined type. For system messages, only type `text` is
         * supported.
         */
        fun arrayOfContentParts(): Optional<List<ChatCompletionContentPartText>> =
            Optional.ofNullable(arrayOfContentParts)

        fun isTextContent(): Boolean = textContent != null

        fun isArrayOfContentParts(): Boolean = arrayOfContentParts != null

        fun asTextContent(): String = textContent.getOrThrow("textContent")

        fun asArrayOfContentParts(): List<ChatCompletionContentPartText> =
            arrayOfContentParts.getOrThrow("arrayOfContentParts")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                textContent != null -> visitor.visitTextContent(textContent)
                arrayOfContentParts != null -> visitor.visitArrayOfContentParts(arrayOfContentParts)
                else -> visitor.unknown(_json)
            }
        }

        fun validate(): Content = apply {
            if (!validated) {
                if (textContent == null && arrayOfContentParts == null) {
                    throw OpenAIInvalidDataException("Unknown Content: $_json")
                }
                arrayOfContentParts?.forEach { it.validate() }
                validated = true
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Content && this.textContent == other.textContent && this.arrayOfContentParts == other.arrayOfContentParts /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(textContent, arrayOfContentParts) /* spotless:on */
        }

        override fun toString(): String {
            return when {
                textContent != null -> "Content{textContent=$textContent}"
                arrayOfContentParts != null -> "Content{arrayOfContentParts=$arrayOfContentParts}"
                _json != null -> "Content{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Content")
            }
        }

        companion object {

            @JvmStatic fun ofTextContent(textContent: String) = Content(textContent = textContent)

            @JvmStatic
            fun ofArrayOfContentParts(arrayOfContentParts: List<ChatCompletionContentPartText>) =
                Content(arrayOfContentParts = arrayOfContentParts)
        }

        interface Visitor<out T> {

            fun visitTextContent(textContent: String): T

            fun visitArrayOfContentParts(
                arrayOfContentParts: List<ChatCompletionContentPartText>
            ): T

            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Content: $json")
            }
        }

        class Deserializer : BaseDeserializer<Content>(Content::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Content {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                    return Content(textContent = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<List<ChatCompletionContentPartText>>()) {
                        it.forEach { it.validate() }
                    }
                    ?.let {
                        return Content(arrayOfContentParts = it, _json = json)
                    }

                return Content(_json = json)
            }
        }

        class Serializer : BaseSerializer<Content>(Content::class) {

            override fun serialize(
                value: Content,
                generator: JsonGenerator,
                provider: SerializerProvider
            ) {
                when {
                    value.textContent != null -> generator.writeObject(value.textContent)
                    value.arrayOfContentParts != null ->
                        generator.writeObject(value.arrayOfContentParts)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Content")
                }
            }
        }
    }

    class Role
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Role && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val SYSTEM = Role(JsonField.of("system"))

            @JvmStatic fun of(value: String) = Role(JsonField.of(value))
        }

        enum class Known {
            SYSTEM,
        }

        enum class Value {
            SYSTEM,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SYSTEM -> Value.SYSTEM
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SYSTEM -> Known.SYSTEM
                else -> throw OpenAIInvalidDataException("Unknown Role: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionSystemMessageParam && this.content == other.content && this.role == other.role && this.name == other.name && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(content, role, name, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionSystemMessageParam{content=$content, role=$role, name=$name, additionalProperties=$additionalProperties}"
}

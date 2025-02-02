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

@JsonDeserialize(using = ModerationMultiModalInput.Deserializer::class)
@JsonSerialize(using = ModerationMultiModalInput.Serializer::class)
class ModerationMultiModalInput
private constructor(
    private val moderationImageUrlInput: ModerationImageUrlInput? = null,
    private val moderationTextInput: ModerationTextInput? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /** An object describing an image to classify. */
    fun moderationImageUrlInput(): Optional<ModerationImageUrlInput> =
        Optional.ofNullable(moderationImageUrlInput)
    /** An object describing text to classify. */
    fun moderationTextInput(): Optional<ModerationTextInput> =
        Optional.ofNullable(moderationTextInput)

    fun isModerationImageUrlInput(): Boolean = moderationImageUrlInput != null

    fun isModerationTextInput(): Boolean = moderationTextInput != null

    fun asModerationImageUrlInput(): ModerationImageUrlInput =
        moderationImageUrlInput.getOrThrow("moderationImageUrlInput")

    fun asModerationTextInput(): ModerationTextInput =
        moderationTextInput.getOrThrow("moderationTextInput")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            moderationImageUrlInput != null ->
                visitor.visitModerationImageUrlInput(moderationImageUrlInput)
            moderationTextInput != null -> visitor.visitModerationTextInput(moderationTextInput)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): ModerationMultiModalInput = apply {
        if (!validated) {
            if (moderationImageUrlInput == null && moderationTextInput == null) {
                throw OpenAIInvalidDataException("Unknown ModerationMultiModalInput: $_json")
            }
            moderationImageUrlInput?.validate()
            moderationTextInput?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModerationMultiModalInput && this.moderationImageUrlInput == other.moderationImageUrlInput && this.moderationTextInput == other.moderationTextInput /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(moderationImageUrlInput, moderationTextInput) /* spotless:on */
    }

    override fun toString(): String {
        return when {
            moderationImageUrlInput != null ->
                "ModerationMultiModalInput{moderationImageUrlInput=$moderationImageUrlInput}"
            moderationTextInput != null ->
                "ModerationMultiModalInput{moderationTextInput=$moderationTextInput}"
            _json != null -> "ModerationMultiModalInput{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ModerationMultiModalInput")
        }
    }

    companion object {

        @JvmStatic
        fun ofModerationImageUrlInput(moderationImageUrlInput: ModerationImageUrlInput) =
            ModerationMultiModalInput(moderationImageUrlInput = moderationImageUrlInput)

        @JvmStatic
        fun ofModerationTextInput(moderationTextInput: ModerationTextInput) =
            ModerationMultiModalInput(moderationTextInput = moderationTextInput)
    }

    interface Visitor<out T> {

        fun visitModerationImageUrlInput(moderationImageUrlInput: ModerationImageUrlInput): T

        fun visitModerationTextInput(moderationTextInput: ModerationTextInput): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ModerationMultiModalInput: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<ModerationMultiModalInput>(ModerationMultiModalInput::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ModerationMultiModalInput {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "image_url" -> {
                    tryDeserialize(node, jacksonTypeRef<ModerationImageUrlInput>()) {
                            it.validate()
                        }
                        ?.let {
                            return ModerationMultiModalInput(
                                moderationImageUrlInput = it,
                                _json = json
                            )
                        }
                }
                "text" -> {
                    tryDeserialize(node, jacksonTypeRef<ModerationTextInput>()) { it.validate() }
                        ?.let {
                            return ModerationMultiModalInput(moderationTextInput = it, _json = json)
                        }
                }
            }

            return ModerationMultiModalInput(_json = json)
        }
    }

    class Serializer : BaseSerializer<ModerationMultiModalInput>(ModerationMultiModalInput::class) {

        override fun serialize(
            value: ModerationMultiModalInput,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.moderationImageUrlInput != null ->
                    generator.writeObject(value.moderationImageUrlInput)
                value.moderationTextInput != null ->
                    generator.writeObject(value.moderationTextInput)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ModerationMultiModalInput")
            }
        }
    }
}

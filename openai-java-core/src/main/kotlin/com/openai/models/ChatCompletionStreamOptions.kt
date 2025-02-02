// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

/** Options for streaming response. Only set this when you set `stream: true`. */
@JsonDeserialize(builder = ChatCompletionStreamOptions.Builder::class)
@NoAutoDetect
class ChatCompletionStreamOptions
private constructor(
    private val includeUsage: JsonField<Boolean>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /**
     * If set, an additional chunk will be streamed before the `data: [DONE]` message. The `usage`
     * field on this chunk shows the token usage statistics for the entire request, and the
     * `choices` field will always be an empty array. All other chunks will also include a `usage`
     * field, but with a null value.
     */
    fun includeUsage(): Optional<Boolean> =
        Optional.ofNullable(includeUsage.getNullable("include_usage"))

    /**
     * If set, an additional chunk will be streamed before the `data: [DONE]` message. The `usage`
     * field on this chunk shows the token usage statistics for the entire request, and the
     * `choices` field will always be an empty array. All other chunks will also include a `usage`
     * field, but with a null value.
     */
    @JsonProperty("include_usage") @ExcludeMissing fun _includeUsage() = includeUsage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionStreamOptions = apply {
        if (!validated) {
            includeUsage()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var includeUsage: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionStreamOptions: ChatCompletionStreamOptions) = apply {
            this.includeUsage = chatCompletionStreamOptions.includeUsage
            additionalProperties(chatCompletionStreamOptions.additionalProperties)
        }

        /**
         * If set, an additional chunk will be streamed before the `data: [DONE]` message. The
         * `usage` field on this chunk shows the token usage statistics for the entire request, and
         * the `choices` field will always be an empty array. All other chunks will also include a
         * `usage` field, but with a null value.
         */
        fun includeUsage(includeUsage: Boolean) = includeUsage(JsonField.of(includeUsage))

        /**
         * If set, an additional chunk will be streamed before the `data: [DONE]` message. The
         * `usage` field on this chunk shows the token usage statistics for the entire request, and
         * the `choices` field will always be an empty array. All other chunks will also include a
         * `usage` field, but with a null value.
         */
        @JsonProperty("include_usage")
        @ExcludeMissing
        fun includeUsage(includeUsage: JsonField<Boolean>) = apply {
            this.includeUsage = includeUsage
        }

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

        fun build(): ChatCompletionStreamOptions =
            ChatCompletionStreamOptions(includeUsage, additionalProperties.toImmutable())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionStreamOptions && this.includeUsage == other.includeUsage && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(includeUsage, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionStreamOptions{includeUsage=$includeUsage, additionalProperties=$additionalProperties}"
}

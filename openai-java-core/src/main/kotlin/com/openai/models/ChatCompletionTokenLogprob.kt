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

@JsonDeserialize(builder = ChatCompletionTokenLogprob.Builder::class)
@NoAutoDetect
class ChatCompletionTokenLogprob
private constructor(
    private val token: JsonField<String>,
    private val logprob: JsonField<Double>,
    private val bytes: JsonField<List<Long>>,
    private val topLogprobs: JsonField<List<TopLogprob>>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The token. */
    fun token(): String = token.getRequired("token")

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     */
    fun logprob(): Double = logprob.getRequired("logprob")

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     */
    fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     */
    fun topLogprobs(): List<TopLogprob> = topLogprobs.getRequired("top_logprobs")

    /** The token. */
    @JsonProperty("token") @ExcludeMissing fun _token() = token

    /**
     * The log probability of this token, if it is within the top 20 most likely tokens. Otherwise,
     * the value `-9999.0` is used to signify that the token is very unlikely.
     */
    @JsonProperty("logprob") @ExcludeMissing fun _logprob() = logprob

    /**
     * A list of integers representing the UTF-8 bytes representation of the token. Useful in
     * instances where characters are represented by multiple tokens and their byte representations
     * must be combined to generate the correct text representation. Can be `null` if there is no
     * bytes representation for the token.
     */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

    /**
     * List of the most likely tokens and their log probability, at this token position. In rare
     * cases, there may be fewer than the number of requested `top_logprobs` returned.
     */
    @JsonProperty("top_logprobs") @ExcludeMissing fun _topLogprobs() = topLogprobs

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): ChatCompletionTokenLogprob = apply {
        if (!validated) {
            token()
            logprob()
            bytes()
            topLogprobs().forEach { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var token: JsonField<String> = JsonMissing.of()
        private var logprob: JsonField<Double> = JsonMissing.of()
        private var bytes: JsonField<List<Long>> = JsonMissing.of()
        private var topLogprobs: JsonField<List<TopLogprob>> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatCompletionTokenLogprob: ChatCompletionTokenLogprob) = apply {
            this.token = chatCompletionTokenLogprob.token
            this.logprob = chatCompletionTokenLogprob.logprob
            this.bytes = chatCompletionTokenLogprob.bytes
            this.topLogprobs = chatCompletionTokenLogprob.topLogprobs
            additionalProperties(chatCompletionTokenLogprob.additionalProperties)
        }

        /** The token. */
        fun token(token: String) = token(JsonField.of(token))

        /** The token. */
        @JsonProperty("token")
        @ExcludeMissing
        fun token(token: JsonField<String>) = apply { this.token = token }

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        @JsonProperty("logprob")
        @ExcludeMissing
        fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(bytes: List<Long>) = bytes(JsonField.of(bytes))

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        @JsonProperty("bytes")
        @ExcludeMissing
        fun bytes(bytes: JsonField<List<Long>>) = apply { this.bytes = bytes }

        /**
         * List of the most likely tokens and their log probability, at this token position. In rare
         * cases, there may be fewer than the number of requested `top_logprobs` returned.
         */
        fun topLogprobs(topLogprobs: List<TopLogprob>) = topLogprobs(JsonField.of(topLogprobs))

        /**
         * List of the most likely tokens and their log probability, at this token position. In rare
         * cases, there may be fewer than the number of requested `top_logprobs` returned.
         */
        @JsonProperty("top_logprobs")
        @ExcludeMissing
        fun topLogprobs(topLogprobs: JsonField<List<TopLogprob>>) = apply {
            this.topLogprobs = topLogprobs
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

        fun build(): ChatCompletionTokenLogprob =
            ChatCompletionTokenLogprob(
                token,
                logprob,
                bytes.map { it.toImmutable() },
                topLogprobs.map { it.toImmutable() },
                additionalProperties.toImmutable(),
            )
    }

    @JsonDeserialize(builder = TopLogprob.Builder::class)
    @NoAutoDetect
    class TopLogprob
    private constructor(
        private val token: JsonField<String>,
        private val logprob: JsonField<Double>,
        private val bytes: JsonField<List<Long>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        /** The token. */
        fun token(): String = token.getRequired("token")

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        fun logprob(): Double = logprob.getRequired("logprob")

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        fun bytes(): Optional<List<Long>> = Optional.ofNullable(bytes.getNullable("bytes"))

        /** The token. */
        @JsonProperty("token") @ExcludeMissing fun _token() = token

        /**
         * The log probability of this token, if it is within the top 20 most likely tokens.
         * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
         */
        @JsonProperty("logprob") @ExcludeMissing fun _logprob() = logprob

        /**
         * A list of integers representing the UTF-8 bytes representation of the token. Useful in
         * instances where characters are represented by multiple tokens and their byte
         * representations must be combined to generate the correct text representation. Can be
         * `null` if there is no bytes representation for the token.
         */
        @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): TopLogprob = apply {
            if (!validated) {
                token()
                logprob()
                bytes()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var token: JsonField<String> = JsonMissing.of()
            private var logprob: JsonField<Double> = JsonMissing.of()
            private var bytes: JsonField<List<Long>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(topLogprob: TopLogprob) = apply {
                this.token = topLogprob.token
                this.logprob = topLogprob.logprob
                this.bytes = topLogprob.bytes
                additionalProperties(topLogprob.additionalProperties)
            }

            /** The token. */
            fun token(token: String) = token(JsonField.of(token))

            /** The token. */
            @JsonProperty("token")
            @ExcludeMissing
            fun token(token: JsonField<String>) = apply { this.token = token }

            /**
             * The log probability of this token, if it is within the top 20 most likely tokens.
             * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
             */
            fun logprob(logprob: Double) = logprob(JsonField.of(logprob))

            /**
             * The log probability of this token, if it is within the top 20 most likely tokens.
             * Otherwise, the value `-9999.0` is used to signify that the token is very unlikely.
             */
            @JsonProperty("logprob")
            @ExcludeMissing
            fun logprob(logprob: JsonField<Double>) = apply { this.logprob = logprob }

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            fun bytes(bytes: List<Long>) = bytes(JsonField.of(bytes))

            /**
             * A list of integers representing the UTF-8 bytes representation of the token. Useful
             * in instances where characters are represented by multiple tokens and their byte
             * representations must be combined to generate the correct text representation. Can be
             * `null` if there is no bytes representation for the token.
             */
            @JsonProperty("bytes")
            @ExcludeMissing
            fun bytes(bytes: JsonField<List<Long>>) = apply { this.bytes = bytes }

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

            fun build(): TopLogprob =
                TopLogprob(
                    token,
                    logprob,
                    bytes.map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TopLogprob && this.token == other.token && this.logprob == other.logprob && this.bytes == other.bytes && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(token, logprob, bytes, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "TopLogprob{token=$token, logprob=$logprob, bytes=$bytes, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChatCompletionTokenLogprob && this.token == other.token && this.logprob == other.logprob && this.bytes == other.bytes && this.topLogprobs == other.topLogprobs && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(token, logprob, bytes, topLogprobs, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "ChatCompletionTokenLogprob{token=$token, logprob=$logprob, bytes=$bytes, topLogprobs=$topLogprobs, additionalProperties=$additionalProperties}"
}

// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.models.*
import java.util.Objects

class UploadCreateParams
constructor(
    private val bytes: Long,
    private val filename: String,
    private val mimeType: String,
    private val purpose: FilePurpose,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun bytes(): Long = bytes

    fun filename(): String = filename

    fun mimeType(): String = mimeType

    fun purpose(): FilePurpose = purpose

    @JvmSynthetic
    internal fun getBody(): UploadCreateBody {
        return UploadCreateBody(
            bytes,
            filename,
            mimeType,
            purpose,
            additionalBodyProperties,
        )
    }

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    @JsonDeserialize(builder = UploadCreateBody.Builder::class)
    @NoAutoDetect
    class UploadCreateBody
    internal constructor(
        private val bytes: Long?,
        private val filename: String?,
        private val mimeType: String?,
        private val purpose: FilePurpose?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        /** The number of bytes in the file you are uploading. */
        @JsonProperty("bytes") fun bytes(): Long? = bytes

        /** The name of the file to upload. */
        @JsonProperty("filename") fun filename(): String? = filename

        /**
         * The MIME type of the file.
         *
         * This must fall within the supported MIME types for your file purpose. See the supported
         * MIME types for assistants and vision.
         */
        @JsonProperty("mime_type") fun mimeType(): String? = mimeType

        /**
         * The intended purpose of the uploaded file.
         *
         * See the
         * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
         */
        @JsonProperty("purpose") fun purpose(): FilePurpose? = purpose

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var bytes: Long? = null
            private var filename: String? = null
            private var mimeType: String? = null
            private var purpose: FilePurpose? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(uploadCreateBody: UploadCreateBody) = apply {
                this.bytes = uploadCreateBody.bytes
                this.filename = uploadCreateBody.filename
                this.mimeType = uploadCreateBody.mimeType
                this.purpose = uploadCreateBody.purpose
                additionalProperties(uploadCreateBody.additionalProperties)
            }

            /** The number of bytes in the file you are uploading. */
            @JsonProperty("bytes") fun bytes(bytes: Long) = apply { this.bytes = bytes }

            /** The name of the file to upload. */
            @JsonProperty("filename")
            fun filename(filename: String) = apply { this.filename = filename }

            /**
             * The MIME type of the file.
             *
             * This must fall within the supported MIME types for your file purpose. See the
             * supported MIME types for assistants and vision.
             */
            @JsonProperty("mime_type")
            fun mimeType(mimeType: String) = apply { this.mimeType = mimeType }

            /**
             * The intended purpose of the uploaded file.
             *
             * See the
             * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
             */
            @JsonProperty("purpose")
            fun purpose(purpose: FilePurpose) = apply { this.purpose = purpose }

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

            fun build(): UploadCreateBody =
                UploadCreateBody(
                    checkNotNull(bytes) { "`bytes` is required but was not set" },
                    checkNotNull(filename) { "`filename` is required but was not set" },
                    checkNotNull(mimeType) { "`mimeType` is required but was not set" },
                    checkNotNull(purpose) { "`purpose` is required but was not set" },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UploadCreateBody && this.bytes == other.bytes && this.filename == other.filename && this.mimeType == other.mimeType && this.purpose == other.purpose && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        private var hashCode: Int = 0

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = /* spotless:off */ Objects.hash(bytes, filename, mimeType, purpose, additionalProperties) /* spotless:on */
            }
            return hashCode
        }

        override fun toString() =
            "UploadCreateBody{bytes=$bytes, filename=$filename, mimeType=$mimeType, purpose=$purpose, additionalProperties=$additionalProperties}"
    }

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UploadCreateParams && this.bytes == other.bytes && this.filename == other.filename && this.mimeType == other.mimeType && this.purpose == other.purpose && this.additionalHeaders == other.additionalHeaders && this.additionalQueryParams == other.additionalQueryParams && this.additionalBodyProperties == other.additionalBodyProperties /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(bytes, filename, mimeType, purpose, additionalHeaders, additionalQueryParams, additionalBodyProperties) /* spotless:on */
    }

    override fun toString() =
        "UploadCreateParams{bytes=$bytes, filename=$filename, mimeType=$mimeType, purpose=$purpose, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var bytes: Long? = null
        private var filename: String? = null
        private var mimeType: String? = null
        private var purpose: FilePurpose? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(uploadCreateParams: UploadCreateParams) = apply {
            this.bytes = uploadCreateParams.bytes
            this.filename = uploadCreateParams.filename
            this.mimeType = uploadCreateParams.mimeType
            this.purpose = uploadCreateParams.purpose
            additionalHeaders(uploadCreateParams.additionalHeaders)
            additionalQueryParams(uploadCreateParams.additionalQueryParams)
            additionalBodyProperties(uploadCreateParams.additionalBodyProperties)
        }

        /** The number of bytes in the file you are uploading. */
        fun bytes(bytes: Long) = apply { this.bytes = bytes }

        /** The name of the file to upload. */
        fun filename(filename: String) = apply { this.filename = filename }

        /**
         * The MIME type of the file.
         *
         * This must fall within the supported MIME types for your file purpose. See the supported
         * MIME types for assistants and vision.
         */
        fun mimeType(mimeType: String) = apply { this.mimeType = mimeType }

        /**
         * The intended purpose of the uploaded file.
         *
         * See the
         * [documentation on File purposes](https://platform.openai.com/docs/api-reference/files/create#files-create-purpose).
         */
        fun purpose(purpose: FilePurpose) = apply { this.purpose = purpose }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            putAllAdditionalBodyProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply {
            additionalBodyProperties.remove(key)
        }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalBodyProperty)
        }

        fun build(): UploadCreateParams =
            UploadCreateParams(
                checkNotNull(bytes) { "`bytes` is required but was not set" },
                checkNotNull(filename) { "`filename` is required but was not set" },
                checkNotNull(mimeType) { "`mimeType` is required but was not set" },
                checkNotNull(purpose) { "`purpose` is required but was not set" },
                additionalHeaders.build(),
                additionalQueryParams.build(),
                additionalBodyProperties.toImmutable(),
            )
    }
}

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
import java.util.Optional

/** The Upload object can accept byte chunks in the form of Parts. */
@JsonDeserialize(builder = Upload.Builder::class)
@NoAutoDetect
class Upload
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val filename: JsonField<String>,
    private val bytes: JsonField<Long>,
    private val purpose: JsonField<String>,
    private val status: JsonField<Status>,
    private val expiresAt: JsonField<Long>,
    private val object_: JsonField<Object>,
    private val file: JsonField<FileObject>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    /** The Upload unique identifier, which can be referenced in API endpoints. */
    fun id(): String = id.getRequired("id")

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /** The name of the file to be uploaded. */
    fun filename(): String = filename.getRequired("filename")

    /** The intended number of bytes to be uploaded. */
    fun bytes(): Long = bytes.getRequired("bytes")

    /**
     * The intended purpose of the file.
     * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
     * for acceptable values.
     */
    fun purpose(): String = purpose.getRequired("purpose")

    /** The status of the Upload. */
    fun status(): Status = status.getRequired("status")

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    fun expiresAt(): Long = expiresAt.getRequired("expires_at")

    /** The object type, which is always "upload". */
    fun object_(): Object = object_.getRequired("object")

    /** The ready File object after the Upload is completed. */
    fun file(): Optional<FileObject> = Optional.ofNullable(file.getNullable("file"))

    /** The Upload unique identifier, which can be referenced in API endpoints. */
    @JsonProperty("id") @ExcludeMissing fun _id() = id

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt() = createdAt

    /** The name of the file to be uploaded. */
    @JsonProperty("filename") @ExcludeMissing fun _filename() = filename

    /** The intended number of bytes to be uploaded. */
    @JsonProperty("bytes") @ExcludeMissing fun _bytes() = bytes

    /**
     * The intended purpose of the file.
     * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
     * for acceptable values.
     */
    @JsonProperty("purpose") @ExcludeMissing fun _purpose() = purpose

    /** The status of the Upload. */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    /** The Unix timestamp (in seconds) for when the Upload was created. */
    @JsonProperty("expires_at") @ExcludeMissing fun _expiresAt() = expiresAt

    /** The object type, which is always "upload". */
    @JsonProperty("object") @ExcludeMissing fun _object_() = object_

    /** The ready File object after the Upload is completed. */
    @JsonProperty("file") @ExcludeMissing fun _file() = file

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate(): Upload = apply {
        if (!validated) {
            id()
            createdAt()
            filename()
            bytes()
            purpose()
            status()
            expiresAt()
            object_()
            file().map { it.validate() }
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var id: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<Long> = JsonMissing.of()
        private var filename: JsonField<String> = JsonMissing.of()
        private var bytes: JsonField<Long> = JsonMissing.of()
        private var purpose: JsonField<String> = JsonMissing.of()
        private var status: JsonField<Status> = JsonMissing.of()
        private var expiresAt: JsonField<Long> = JsonMissing.of()
        private var object_: JsonField<Object> = JsonMissing.of()
        private var file: JsonField<FileObject> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(upload: Upload) = apply {
            this.id = upload.id
            this.createdAt = upload.createdAt
            this.filename = upload.filename
            this.bytes = upload.bytes
            this.purpose = upload.purpose
            this.status = upload.status
            this.expiresAt = upload.expiresAt
            this.object_ = upload.object_
            this.file = upload.file
            additionalProperties(upload.additionalProperties)
        }

        /** The Upload unique identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /** The Upload unique identifier, which can be referenced in API endpoints. */
        @JsonProperty("id") @ExcludeMissing fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        @JsonProperty("created_at")
        @ExcludeMissing
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** The name of the file to be uploaded. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /** The name of the file to be uploaded. */
        @JsonProperty("filename")
        @ExcludeMissing
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        /** The intended number of bytes to be uploaded. */
        fun bytes(bytes: Long) = bytes(JsonField.of(bytes))

        /** The intended number of bytes to be uploaded. */
        @JsonProperty("bytes")
        @ExcludeMissing
        fun bytes(bytes: JsonField<Long>) = apply { this.bytes = bytes }

        /**
         * The intended purpose of the file.
         * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
         * for acceptable values.
         */
        fun purpose(purpose: String) = purpose(JsonField.of(purpose))

        /**
         * The intended purpose of the file.
         * [Please refer here](https://platform.openai.com/docs/api-reference/files/object#files/object-purpose)
         * for acceptable values.
         */
        @JsonProperty("purpose")
        @ExcludeMissing
        fun purpose(purpose: JsonField<String>) = apply { this.purpose = purpose }

        /** The status of the Upload. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The status of the Upload. */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        fun expiresAt(expiresAt: Long) = expiresAt(JsonField.of(expiresAt))

        /** The Unix timestamp (in seconds) for when the Upload was created. */
        @JsonProperty("expires_at")
        @ExcludeMissing
        fun expiresAt(expiresAt: JsonField<Long>) = apply { this.expiresAt = expiresAt }

        /** The object type, which is always "upload". */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** The object type, which is always "upload". */
        @JsonProperty("object")
        @ExcludeMissing
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** The ready File object after the Upload is completed. */
        fun file(file: FileObject) = file(JsonField.of(file))

        /** The ready File object after the Upload is completed. */
        @JsonProperty("file")
        @ExcludeMissing
        fun file(file: JsonField<FileObject>) = apply { this.file = file }

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

        fun build(): Upload =
            Upload(
                id,
                createdAt,
                filename,
                bytes,
                purpose,
                status,
                expiresAt,
                object_,
                file,
                additionalProperties.toImmutable(),
            )
    }

    class Object
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Object && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val UPLOAD = Object(JsonField.of("upload"))

            @JvmStatic fun of(value: String) = Object(JsonField.of(value))
        }

        enum class Known {
            UPLOAD,
        }

        enum class Value {
            UPLOAD,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                UPLOAD -> Value.UPLOAD
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                UPLOAD -> Known.UPLOAD
                else -> throw OpenAIInvalidDataException("Unknown Object: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class Status
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && this.value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val PENDING = Status(JsonField.of("pending"))

            @JvmField val COMPLETED = Status(JsonField.of("completed"))

            @JvmField val CANCELLED = Status(JsonField.of("cancelled"))

            @JvmField val EXPIRED = Status(JsonField.of("expired"))

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        enum class Known {
            PENDING,
            COMPLETED,
            CANCELLED,
            EXPIRED,
        }

        enum class Value {
            PENDING,
            COMPLETED,
            CANCELLED,
            EXPIRED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                PENDING -> Value.PENDING
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
                EXPIRED -> Value.EXPIRED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                PENDING -> Known.PENDING
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                EXPIRED -> Known.EXPIRED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Upload && this.id == other.id && this.createdAt == other.createdAt && this.filename == other.filename && this.bytes == other.bytes && this.purpose == other.purpose && this.status == other.status && this.expiresAt == other.expiresAt && this.object_ == other.object_ && this.file == other.file && this.additionalProperties == other.additionalProperties /* spotless:on */
    }

    private var hashCode: Int = 0

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode = /* spotless:off */ Objects.hash(id, createdAt, filename, bytes, purpose, status, expiresAt, object_, file, additionalProperties) /* spotless:on */
        }
        return hashCode
    }

    override fun toString() =
        "Upload{id=$id, createdAt=$createdAt, filename=$filename, bytes=$bytes, purpose=$purpose, status=$status, expiresAt=$expiresAt, object_=$object_, file=$file, additionalProperties=$additionalProperties}"
}

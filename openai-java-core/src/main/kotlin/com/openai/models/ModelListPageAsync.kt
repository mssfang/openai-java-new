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
import com.openai.services.async.ModelServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

class ModelListPageAsync
private constructor(
    private val modelsService: ModelServiceAsync,
    private val params: ModelListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun data(): List<Model> = response().data()

    fun object_(): String = response().object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ModelListPageAsync && this.modelsService == other.modelsService && this.params == other.params && this.response == other.response /* spotless:on */
    }

    override fun hashCode(): Int {
        return /* spotless:off */ Objects.hash(modelsService, params, response) /* spotless:on */
    }

    override fun toString() =
        "ModelListPageAsync{modelsService=$modelsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        return !data().isEmpty()
    }

    fun getNextPageParams(): Optional<ModelListParams> {
        return Optional.empty()
    }

    fun getNextPage(): CompletableFuture<Optional<ModelListPageAsync>> {
        return getNextPageParams()
            .map { modelsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(modelsService: ModelServiceAsync, params: ModelListParams, response: Response) =
            ModelListPageAsync(
                modelsService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val data: JsonField<List<Model>>,
        private val object_: JsonField<String>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun data(): List<Model> = data.getNullable("data") ?: listOf()

        fun object_(): String = object_.getRequired("object")

        @JsonProperty("data")
        fun _data(): Optional<JsonField<List<Model>>> = Optional.ofNullable(data)

        @JsonProperty("object")
        fun _object_(): Optional<JsonField<String>> = Optional.ofNullable(object_)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                data().map { it.validate() }
                object_()
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && this.data == other.data && this.object_ == other.object_ && this.additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int {
            return /* spotless:off */ Objects.hash(data, object_, additionalProperties) /* spotless:on */
        }

        override fun toString() =
            "ModelListPageAsync.Response{data=$data, object_=$object_, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var data: JsonField<List<Model>> = JsonMissing.of()
            private var object_: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.data = page.data
                this.object_ = page.object_
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun data(data: List<Model>) = data(JsonField.of(data))

            @JsonProperty("data")
            fun data(data: JsonField<List<Model>>) = apply { this.data = data }

            fun object_(object_: String) = object_(JsonField.of(object_))

            @JsonProperty("object")
            fun object_(object_: JsonField<String>) = apply { this.object_ = object_ }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() =
                Response(
                    data,
                    object_,
                    additionalProperties.toImmutable(),
                )
        }
    }

    class AutoPager
    constructor(
        private val firstPage: ModelListPageAsync,
    ) {

        fun forEach(action: Predicate<Model>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ModelListPageAsync>>.forEach(
                action: (Model) -> Boolean,
                executor: Executor
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.data().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Model>> {
            val values = mutableListOf<Model>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}

package com.openai.api.services.async

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.Completion
import com.openai.api.models.CompletionCreateParams
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler
import java.util.concurrent.CompletableFuture

class CompletionServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : CompletionServiceAsync {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Completion> =
        jsonHandler<Completion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a completion for the provided prompt and parameters */
    override fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<Completion> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("completions")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .let { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}

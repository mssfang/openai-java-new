package com.openai.api.services.blocking

import com.openai.api.core.ClientOptions
import com.openai.api.core.RequestOptions
import com.openai.api.core.http.HttpMethod
import com.openai.api.core.http.HttpRequest
import com.openai.api.core.http.HttpResponse.Handler
import com.openai.api.errors.OpenAiError
import com.openai.api.models.Edit
import com.openai.api.models.EditCreateParams
import com.openai.api.services.errorHandler
import com.openai.api.services.json
import com.openai.api.services.jsonHandler
import com.openai.api.services.withErrorHandler

class EditServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : EditService {

    private val errorHandler: Handler<OpenAiError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<Edit> =
        jsonHandler<Edit>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Creates a new edit for the provided input, instruction, and parameters. */
    override fun create(params: EditCreateParams, requestOptions: RequestOptions): Edit {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("edits")
                .putAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .putAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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

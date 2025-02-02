// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmbeddingCreateParamsTest {

    @Test
    fun createEmbeddingCreateParams() {
        EmbeddingCreateParams.builder()
            .input(EmbeddingCreateParams.Input.ofString("This is a test."))
            .model(EmbeddingCreateParams.Model.TEXT_EMBEDDING_ADA_002)
            .dimensions(123L)
            .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
            .user("user-1234")
            .build()
    }

    @Test
    fun getBody() {
        val params =
            EmbeddingCreateParams.builder()
                .input(EmbeddingCreateParams.Input.ofString("This is a test."))
                .model(EmbeddingCreateParams.Model.TEXT_EMBEDDING_ADA_002)
                .dimensions(123L)
                .encodingFormat(EmbeddingCreateParams.EncodingFormat.FLOAT)
                .user("user-1234")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.input()).isEqualTo(EmbeddingCreateParams.Input.ofString("This is a test."))
        assertThat(body.model()).isEqualTo(EmbeddingCreateParams.Model.TEXT_EMBEDDING_ADA_002)
        assertThat(body.dimensions()).isEqualTo(123L)
        assertThat(body.encodingFormat()).isEqualTo(EmbeddingCreateParams.EncodingFormat.FLOAT)
        assertThat(body.user()).isEqualTo("user-1234")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            EmbeddingCreateParams.builder()
                .input(EmbeddingCreateParams.Input.ofString("This is a test."))
                .model(EmbeddingCreateParams.Model.TEXT_EMBEDDING_ADA_002)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.input()).isEqualTo(EmbeddingCreateParams.Input.ofString("This is a test."))
        assertThat(body.model()).isEqualTo(EmbeddingCreateParams.Model.TEXT_EMBEDDING_ADA_002)
    }
}

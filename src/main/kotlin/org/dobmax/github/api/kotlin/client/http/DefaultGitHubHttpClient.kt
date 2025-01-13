package org.dobmax.github.api.kotlin.client.http

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.appendEncodedPathSegments
import io.ktor.http.headers
import io.ktor.http.parametersOf
import io.ktor.util.reflect.TypeInfo

class DefaultGitHubHttpClient(private val httpClient: HttpClient) : GitHubHttpClient {
    override suspend fun <REQ, RES : Any> call(message: GitHubHttpMessage<REQ, RES>): GitHubHttpResponse<RES> {
        val response =
            httpClient.request {
                method = message.method
                headers {
                    message.headers.forEach {
                        append(it.key, it.value)
                    }
                }
                url {
                    appendEncodedPathSegments(message.pathParameters)
                    parametersOf(message.queryParameters)
                }

                message.body?.let {
                    setBody(
                        it,
                        TypeInfo(
                            it::class,
                            it::class.java,
                        ),
                    )
                }
            }

        return GitHubHttpResponse(
            response.status,
            response.body(
                TypeInfo(
                    message.responseType,
                    message.responseType.java,
                ),
            ),
        )
    }

    private object HttpMessageFactory {
        fun <REQ, RES : Any> getInstance(message: GitHubHttpMessage<REQ, RES>): GitHubHttpMessage<REQ, RES> =
            when (message.method) {
                HttpMethod.Get -> GitHubGetMessage(message)
                HttpMethod.Post -> GitHubPostMessage(message)
                HttpMethod.Delete -> GitHubDeleteMessage(message)
                HttpMethod.Patch -> GitHubPatchMessage(message)
                HttpMethod.Put -> GitHubPutMessage(message)
                else -> throw IllegalArgumentException("No message type mapped to HTTP Method (${message.method})")
            }
    }
}

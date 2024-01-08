package org.dobmax.github.api.kotlin.client.http

import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.appendEncodedPathSegments
import io.ktor.http.headers
import io.ktor.http.parametersOf

class DefaultGitHubHttpClient(private val httpClient: HttpClient) : GitHubHttpClient {

    override suspend fun <REQ, RES> call(message: GitHubHttpMessage<REQ>): GitHubHttpMessage<RES> {
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
            setBody(message.body)
        }
    }

    private object HttpMessageFactory {
        fun <REQ, RES> getInstance(message: GitHubHttpMessage<REQ>): GitHubHttpMessage<RES> =
            when (message.method) {
                HttpMethod.Get -> GitHubGetMessage()
                HttpMethod.Post -> GitHubPostMessage()
                HttpMethod.Delete -> GitHubDeleteMessage()
                HttpMethod.Patch -> GitHubPatchMessage()
                HttpMethod.Put -> GitHubPutMessage()
                else -> throw IllegalArgumentException("No message type mapped to HTTP Method (${message.method})")
            }
    }
}

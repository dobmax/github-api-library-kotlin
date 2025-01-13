package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpStatusCode
import org.dobmax.github.api.kotlin.client.GitHubMessage

class GitHubHttpResponse<T>(
    val status: HttpStatusCode,
    val body: T?,
) : GitHubMessage<T> {
    /**
     * Retrieves or sets a payload of this response body. Equals to [body].
     */
    override val payload: T?
        get() = body
}

package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpMethod

/**
 * Represents an HTTP-based message of [HttpMethod.Put] method sending via [GitHubHttpClient]
 * while communicating with GitHub REST API.
 *
 * @property headers mutable map containing HTTP headers for a http message to be sent
 * @param pathParameters mutable sequence containing HTTP path parameters for a http message to be sent
 * @property body a payload of http message containing data of type [T]
 */
class GitHubPutMessage<T>(
    headers: MutableMap<String, String> = mutableMapOf(),
    pathParameters: MutableList<String> = mutableListOf(),
) : GitHubHttpMessage<T>(
        method = HttpMethod.Put,
        headers = headers,
        pathParameters = pathParameters,
        body = body,
    )

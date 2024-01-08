package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpMethod

/**
 * Represents an HTTP-based message of [HttpMethod.Patch] method sending via [GitHubHttpClient]
 * while communicating with GitHub REST API.
 *
 * @property headers mutable map containing HTTP headers for a http message to be sent
 * @param pathParameters mutable sequence containing HTTP path parameters for a http message to be sent
 * @property body a payload of http message containing data of type [T]
 */
class GitHubPatchMessage<T>(
    headers: MutableMap<String, String> = mutableMapOf(),
    pathParameters: MutableList<String> = mutableListOf(),
    body: T,
) : GitHubHttpMessage<T>(
        method = HttpMethod.Patch,
        headers = headers,
        pathParameters = pathParameters,
        body = body,
    )

package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpMethod
import kotlin.reflect.KClass

/**
 * Represents an HTTP-based message of [HttpMethod.Delete] method sending via [GitHubHttpClient]
 * while communicating with GitHub REST API.
 *
 * @property headers mutable map containing HTTP headers for a http message to be sent
 * @param pathParameters mutable sequence containing HTTP path parameters for a http message to be sent
 * @property body a payload of http message containing data of type [T]
 */
class GitHubDeleteMessage<T, R : Any>(
    headers: MutableMap<String, String> = mutableMapOf(),
    pathParameters: MutableList<String> = mutableListOf(),
    queryParameters: MutableMap<String, List<String>> = mutableMapOf(),
    body: T?,
    responseType: KClass<R>,
) : GitHubHttpMessage<T, R>(
        method = HttpMethod.Delete,
        headers = headers,
        pathParameters = pathParameters,
        queryParameters = queryParameters,
        body = body,
        responseType = responseType,
    ) {
    /**
     * Copy constructor
     */
    constructor(original: GitHubHttpMessage<T, R>) : this(
        headers = original.headers.toMutableMap(),
        pathParameters = original.pathParameters.toMutableList(),
        queryParameters = original.queryParameters.toMutableMap(),
        body = original.body,
        responseType = original.responseType,
    )
}

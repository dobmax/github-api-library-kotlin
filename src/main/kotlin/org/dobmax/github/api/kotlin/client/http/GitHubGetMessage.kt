package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpMethod
import kotlin.reflect.KClass

/**
 * Represents an HTTP-based message of [HttpMethod.Get] method sending via [GitHubHttpClient]
 * while communicating with GitHub REST API.
 *
 * @param headers mutable map containing HTTP headers for a http message to be sent
 * @param pathParameters mutable sequence containing HTTP path parameters for a http message to be sent
 * @param queryParameters mutable map containing HTTP query parameters for a http message to be sent
 */
class GitHubGetMessage<T, R : Any>(
    headers: MutableMap<String, String> = mutableMapOf(),
    pathParameters: MutableList<String> = mutableListOf(),
    queryParameters: MutableMap<String, List<String>> = mutableMapOf(),
    responseType: KClass<R>,
) : GitHubHttpMessage<T, R>(HttpMethod.Get, headers, pathParameters, queryParameters, null, responseType) {
    /**
     * Copy constructor
     */
    constructor(original: GitHubHttpMessage<T, R>) : this(
        headers = original.headers.toMutableMap(),
        pathParameters = original.pathParameters.toMutableList(),
        queryParameters = original.queryParameters.toMutableMap(),
        responseType = original.responseType,
    )
}

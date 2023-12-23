package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpMethod
import org.dobmax.github.api.kotlin.client.GitHubMessage

/**
 * Represents an HTTP-based message sending via [GitHubHttpClient] while communicating with GitHub REST API.
 *
 * @param T The type of data carried by a http message body
 * @param method represents [HttpMethod] associated with a http message to be sent
 * @param headers mutable map containing HTTP headers for a http message to be sent
 * @param pathParameters mutable sequence containing HTTP path parameters for a http message to be sent
 * @param queryParameters mutable map containing HTTP query parameters for a http message to be sent
 * @param body a payload of http message containing data of type [T]
 */
open class GitHubHttpMessage<T>(
    val method: HttpMethod,
    val headers: MutableMap<String, String> = mutableMapOf(),
    val pathParameters: MutableList<String> = mutableListOf(),
    val queryParameters: MutableMap<String, String> = mutableMapOf(),
    val body: T?,
) : GitHubMessage<T> {
    /**
     * Retrieves or sets a payload of this message. Equals to [body].
     */
    override val payload: T?
        get() = body

    /**
     * Puts a new header whether overrides existing one with given [key] and [value] to this http message.
     *
     * @param key a header key
     * @param value a header value
     */
    fun addHeader(
        key: String,
        value: String,
    ) {
        headers[key] = value
    }

    /**
     * Puts new headers whether overrides existing with [pairs] to this http message.
     *
     * @param pairs representing http headers
     */
    fun addHeaders(vararg pairs: Pair<String, String>) {
        headers.putAll(pairs)
    }

    /**
     * Puts a new query parameter whether overrides existing one with given [key] and [value] to this http message.
     *
     * @param key a query parameter key
     * @param value a query parameter value
     */
    fun addParameter(
        key: String,
        value: String,
    ) {
        headers[key] = value
    }

    /**
     * Puts new query parameters whether overrides existing with [pairs] to this http message.
     *
     * @param pairs representing http query parameter
     */
    fun addParameters(vararg pairs: Pair<String, String>) {
        headers.putAll(pairs)
    }

    /**
     * Add a new path parameter to a rear of existing parameter sequence to this http message.
     *
     * @param value a path parameter
     */
    fun addPathParameter(value: String) {
        pathParameters.add(value)
    }

    /**
     * Add new path parameters to a rear of existing parameter sequence to this http message.
     *
     * @param values representing path parameters
     */
    fun addParameters(vararg values: String) {
        pathParameters.addAll(values)
    }
}

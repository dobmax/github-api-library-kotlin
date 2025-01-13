package org.dobmax.github.api.kotlin.client

/**
 * Represents a message sending via [GitHubClient] while communicating with GitHub  API.
 *
 * @param T a type of data carried by a message payload.
 */
interface GitHubMessage<T> {
    /**
     * Retrieves or sets a payload of this message.
     */
    val payload: T?
}

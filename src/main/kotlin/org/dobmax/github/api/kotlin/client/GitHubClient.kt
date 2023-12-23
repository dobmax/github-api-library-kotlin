package org.dobmax.github.api.kotlin.client

/**
 * Represents a generic GitHub API Client that can make requests and receive responses
 * to a remote host that represent GitHub API.
 */
interface GitHubClient {
    /**
     * Makes a GitHub API call using a given provided [message].
     *
     * @param message containing data to be sent to GitHub API
     * @return message containing data received from GitHub API
     */
    fun <REQ, RES> call(message: GitHubMessage<REQ>): GitHubMessage<RES>
}

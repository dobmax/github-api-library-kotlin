package org.dobmax.github.api.kotlin.client.http

import io.ktor.http.HttpMethod
import org.dobmax.github.api.kotlin.client.GitHubClient
import org.dobmax.github.api.kotlin.client.GitHubMessage

/**
 * Represents a GitHub API HTTP Client that can make requests and receive responses
 * to a remote host representing [GitHub REST API](https://docs.github.com/en/rest).
 */
interface GitHubHttpClient : GitHubClient {
    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubHttpMessage].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    override fun <REQ, RES> call(message: GitHubMessage<REQ>): GitHubMessage<RES> {
        return call(message as GitHubHttpMessage<REQ>)
    }

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubHttpMessage].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    fun <REQ, RES> call(message: GitHubHttpMessage<REQ>): GitHubHttpMessage<RES>

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubGetMessage]
     * associated with [HttpMethod.Get].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    fun <REQ, RES> get(message: GitHubGetMessage<REQ>): GitHubGetMessage<RES>

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubPostMessage]
     * associated with [HttpMethod.Post].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    fun <REQ, RES> post(message: GitHubPostMessage<REQ>): GitHubPostMessage<RES>

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubPatchMessage]
     * associated with [HttpMethod.Patch].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    fun <REQ, RES> patch(message: GitHubPatchMessage<REQ>): GitHubPatchMessage<RES>

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubPutMessage]
     * associated with [HttpMethod.Patch].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    fun <REQ, RES> put(message: GitHubPutMessage<REQ>): GitHubPutMessage<RES>

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubDeleteMessage]
     * associated with [HttpMethod.Patch].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    fun <REQ, RES> delete(message: GitHubDeleteMessage<REQ>): GitHubDeleteMessage<RES>
}

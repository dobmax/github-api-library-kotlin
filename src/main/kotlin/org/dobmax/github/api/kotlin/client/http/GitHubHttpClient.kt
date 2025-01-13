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
    override suspend fun <REQ, RES : Any> call(message: GitHubMessage<REQ>): GitHubMessage<RES> {
        return call(message as GitHubHttpMessage<REQ, RES>)
    }

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubHttpMessage].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    suspend fun <REQ, RES : Any> call(message: GitHubHttpMessage<REQ, RES>): GitHubHttpResponse<RES>

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubGetMessage]
     * associated with [HttpMethod.Get].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    suspend fun <REQ, RES : Any> get(message: GitHubGetMessage<REQ, RES>): GitHubHttpResponse<RES> = call(message)

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubPostMessage]
     * associated with [HttpMethod.Post].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    suspend fun <REQ, RES : Any> post(message: GitHubPostMessage<REQ, RES>): GitHubHttpResponse<RES> = call(message)

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubPatchMessage]
     * associated with [HttpMethod.Patch].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    suspend fun <REQ, RES : Any> patch(message: GitHubPatchMessage<REQ, RES>): GitHubHttpResponse<RES> = call(message)

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubPutMessage]
     * associated with [HttpMethod.Patch].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    suspend fun <REQ, RES : Any> put(message: GitHubPutMessage<REQ, RES>): GitHubHttpResponse<RES> = call(message)

    /**
     * Makes a call to a GitHub REST API using a given provided [GitHubDeleteMessage]
     * associated with [HttpMethod.Patch].
     *
     * @param message containing data to be sent to GitHub REST API
     * @return message containing data received from GitHub REST API
     */
    suspend fun <REQ, RES : Any> delete(message: GitHubDeleteMessage<REQ, RES>): GitHubHttpResponse<RES> = call(message)
}

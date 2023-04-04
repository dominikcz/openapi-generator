/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.apis

import org.openapitools.client.models.User

import org.openapitools.client.infrastructure.*
import io.ktor.client.HttpClientConfig
import io.ktor.client.request.forms.formData
import io.ktor.client.engine.HttpClientEngine
import io.ktor.http.ParametersBuilder
import com.fasterxml.jackson.databind.ObjectMapper

    open class UserApi(
    baseUrl: String = ApiClient.BASE_URL,
    httpClientEngine: HttpClientEngine? = null,
    httpClientConfig: ((HttpClientConfig<*>) -> Unit)? = null,
    jsonBlock: ObjectMapper.() -> Unit = ApiClient.JSON_DEFAULT,
    ) : ApiClient(baseUrl, httpClientEngine, httpClientConfig, jsonBlock) {

        /**
        * Create user
        * This can only be done by the logged in user.
         * @param body Created user object 
         * @return void
        */
        open suspend fun createUser(body: User): HttpResponse<Unit> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = body

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.POST,
            "/user",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Creates list of users with given input array
        * 
         * @param body List of user object 
         * @return void
        */
        open suspend fun createUsersWithArrayInput(body: kotlin.collections.List<User>): HttpResponse<Unit> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = body

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.POST,
            "/user/createWithArray",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Creates list of users with given input array
        * 
         * @param body List of user object 
         * @return void
        */
        open suspend fun createUsersWithListInput(body: kotlin.collections.List<User>): HttpResponse<Unit> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = body

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.POST,
            "/user/createWithList",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Delete user
        * This can only be done by the logged in user.
         * @param username The name that needs to be deleted 
         * @return void
        */
        open suspend fun deleteUser(username: kotlin.String): HttpResponse<Unit> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = 
                    io.ktor.client.utils.EmptyContent

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.DELETE,
            "/user/{username}".replace("{" + "username" + "}", "$username"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Get user by user name
        * 
         * @param username The name that needs to be fetched. Use user1 for testing. 
         * @return User
        */
            @Suppress("UNCHECKED_CAST")
        open suspend fun getUserByName(username: kotlin.String): HttpResponse<User> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = 
                    io.ktor.client.utils.EmptyContent

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/user/{username}".replace("{" + "username" + "}", "$username"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Logs user into the system
        * 
         * @param username The user name for login 
         * @param password The password for login in clear text 
         * @return kotlin.String
        */
            @Suppress("UNCHECKED_CAST")
        open suspend fun loginUser(username: kotlin.String, password: kotlin.String): HttpResponse<kotlin.String> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = 
                    io.ktor.client.utils.EmptyContent

            val localVariableQuery = mutableMapOf<String, List<String>>()
            username?.apply { localVariableQuery["username"] = listOf("$username") }
            password?.apply { localVariableQuery["password"] = listOf("$password") }

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/user/login",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Logs out current logged in user session
        * 
         * @return void
        */
        open suspend fun logoutUser(): HttpResponse<Unit> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = 
                    io.ktor.client.utils.EmptyContent

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.GET,
            "/user/logout",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return request(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        /**
        * Updated user
        * This can only be done by the logged in user.
         * @param username name that need to be deleted 
         * @param body Updated user object 
         * @return void
        */
        open suspend fun updateUser(username: kotlin.String, body: User): HttpResponse<Unit> {

            val localVariableAuthNames = listOf<String>()

            val localVariableBody = body

            val localVariableQuery = mutableMapOf<String, List<String>>()

            val localVariableHeaders = mutableMapOf<String, String>()

            val localVariableConfig = RequestConfig<kotlin.Any?>(
            RequestMethod.PUT,
            "/user/{username}".replace("{" + "username" + "}", "$username"),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            )

            return jsonRequest(
            localVariableConfig,
            localVariableBody,
            localVariableAuthNames
            ).wrap()
            }

        }

/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import globalAxios, { AxiosPromise, AxiosInstance, AxiosRequestConfig } from 'axios';
import { Configuration } from '../../../configuration';
// Some imports not used depending on template conditions
// @ts-ignore
import { DUMMY_BASE_URL, assertParamExists, setApiKeyToObject, setBasicAuthToObject, setBearerAuthToObject, setOAuthToObject, setSearchParams, serializeDataIfNeeded, toPathString, createRequestFunction } from '../../../common';
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, RequestArgs, BaseAPI, RequiredError } from '../../../base';
// @ts-ignore
import { User } from '../../../model/some/levels/deep';
/**
 * UserApi - axios parameter creator
 * @export
 */
export const UserApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * This can only be done by the logged in user.
         * @summary Create user
         * @param {User} body Created user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createUser: async (body: User, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            assertParamExists('createUser', 'body', body)
            const localVarPath = `/user`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(body, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary Creates list of users with given input array
         * @param {Array<User>} body List of user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createUsersWithArrayInput: async (body: Array<User>, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            assertParamExists('createUsersWithArrayInput', 'body', body)
            const localVarPath = `/user/createWithArray`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(body, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary Creates list of users with given input array
         * @param {Array<User>} body List of user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createUsersWithListInput: async (body: Array<User>, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            assertParamExists('createUsersWithListInput', 'body', body)
            const localVarPath = `/user/createWithList`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(body, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * This can only be done by the logged in user.
         * @summary Delete user
         * @param {string} username The name that needs to be deleted
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deleteUser: async (username: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'username' is not null or undefined
            assertParamExists('deleteUser', 'username', username)
            const localVarPath = `/user/{username}`
                .replace(`{${"username"}}`, encodeURIComponent(String(username)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'DELETE', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary Get user by user name
         * @param {string} username The name that needs to be fetched. Use user1 for testing.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getUserByName: async (username: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'username' is not null or undefined
            assertParamExists('getUserByName', 'username', username)
            const localVarPath = `/user/{username}`
                .replace(`{${"username"}}`, encodeURIComponent(String(username)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary Logs user into the system
         * @param {string} username The user name for login
         * @param {string} password The password for login in clear text
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        loginUser: async (username: string, password: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'username' is not null or undefined
            assertParamExists('loginUser', 'username', username)
            // verify required parameter 'password' is not null or undefined
            assertParamExists('loginUser', 'password', password)
            const localVarPath = `/user/login`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            if (username !== undefined) {
                localVarQueryParameter['username'] = username;
            }

            if (password !== undefined) {
                localVarQueryParameter['password'] = password;
            }


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary Logs out current logged in user session
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        logoutUser: async (options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            const localVarPath = `/user/logout`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * This can only be done by the logged in user.
         * @summary Updated user
         * @param {string} username name that need to be deleted
         * @param {User} body Updated user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updateUser: async (username: string, body: User, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'username' is not null or undefined
            assertParamExists('updateUser', 'username', username)
            // verify required parameter 'body' is not null or undefined
            assertParamExists('updateUser', 'body', body)
            const localVarPath = `/user/{username}`
                .replace(`{${"username"}}`, encodeURIComponent(String(username)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'PUT', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;


    
            localVarHeaderParameter['Content-Type'] = 'application/json';

            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = serializeDataIfNeeded(body, localVarRequestOptions, configuration)

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * UserApi - functional programming interface
 * @export
 */
export const UserApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = UserApiAxiosParamCreator(configuration)
    return {
        /**
         * This can only be done by the logged in user.
         * @summary Create user
         * @param {User} body Created user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async createUser(body: User, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.createUser(body, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Creates list of users with given input array
         * @param {Array<User>} body List of user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async createUsersWithArrayInput(body: Array<User>, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.createUsersWithArrayInput(body, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Creates list of users with given input array
         * @param {Array<User>} body List of user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async createUsersWithListInput(body: Array<User>, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.createUsersWithListInput(body, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * This can only be done by the logged in user.
         * @summary Delete user
         * @param {string} username The name that needs to be deleted
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async deleteUser(username: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.deleteUser(username, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Get user by user name
         * @param {string} username The name that needs to be fetched. Use user1 for testing.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getUserByName(username: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<User>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.getUserByName(username, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Logs user into the system
         * @param {string} username The user name for login
         * @param {string} password The password for login in clear text
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async loginUser(username: string, password: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<string>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.loginUser(username, password, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Logs out current logged in user session
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async logoutUser(options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.logoutUser(options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * This can only be done by the logged in user.
         * @summary Updated user
         * @param {string} username name that need to be deleted
         * @param {User} body Updated user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async updateUser(username: string, body: User, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.updateUser(username, body, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
    }
};

/**
 * UserApi - factory interface
 * @export
 */
export const UserApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = UserApiFp(configuration)
    return {
        /**
         * This can only be done by the logged in user.
         * @summary Create user
         * @param {User} body Created user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createUser(body: User, options?: any): AxiosPromise<void> {
            return localVarFp.createUser(body, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Creates list of users with given input array
         * @param {Array<User>} body List of user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createUsersWithArrayInput(body: Array<User>, options?: any): AxiosPromise<void> {
            return localVarFp.createUsersWithArrayInput(body, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Creates list of users with given input array
         * @param {Array<User>} body List of user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createUsersWithListInput(body: Array<User>, options?: any): AxiosPromise<void> {
            return localVarFp.createUsersWithListInput(body, options).then((request) => request(axios, basePath));
        },
        /**
         * This can only be done by the logged in user.
         * @summary Delete user
         * @param {string} username The name that needs to be deleted
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deleteUser(username: string, options?: any): AxiosPromise<void> {
            return localVarFp.deleteUser(username, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Get user by user name
         * @param {string} username The name that needs to be fetched. Use user1 for testing.
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getUserByName(username: string, options?: any): AxiosPromise<User> {
            return localVarFp.getUserByName(username, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Logs user into the system
         * @param {string} username The user name for login
         * @param {string} password The password for login in clear text
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        loginUser(username: string, password: string, options?: any): AxiosPromise<string> {
            return localVarFp.loginUser(username, password, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Logs out current logged in user session
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        logoutUser(options?: any): AxiosPromise<void> {
            return localVarFp.logoutUser(options).then((request) => request(axios, basePath));
        },
        /**
         * This can only be done by the logged in user.
         * @summary Updated user
         * @param {string} username name that need to be deleted
         * @param {User} body Updated user object
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updateUser(username: string, body: User, options?: any): AxiosPromise<void> {
            return localVarFp.updateUser(username, body, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * UserApi - object-oriented interface
 * @export
 * @class UserApi
 * @extends {BaseAPI}
 */
export class UserApi extends BaseAPI {
    /**
     * This can only be done by the logged in user.
     * @summary Create user
     * @param {User} body Created user object
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public createUser(body: User, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).createUser(body, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Creates list of users with given input array
     * @param {Array<User>} body List of user object
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public createUsersWithArrayInput(body: Array<User>, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).createUsersWithArrayInput(body, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Creates list of users with given input array
     * @param {Array<User>} body List of user object
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public createUsersWithListInput(body: Array<User>, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).createUsersWithListInput(body, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * This can only be done by the logged in user.
     * @summary Delete user
     * @param {string} username The name that needs to be deleted
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public deleteUser(username: string, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).deleteUser(username, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Get user by user name
     * @param {string} username The name that needs to be fetched. Use user1 for testing.
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public getUserByName(username: string, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).getUserByName(username, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Logs user into the system
     * @param {string} username The user name for login
     * @param {string} password The password for login in clear text
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public loginUser(username: string, password: string, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).loginUser(username, password, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Logs out current logged in user session
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public logoutUser(options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).logoutUser(options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * This can only be done by the logged in user.
     * @summary Updated user
     * @param {string} username name that need to be deleted
     * @param {User} body Updated user object
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof UserApi
     */
    public updateUser(username: string, body: User, options?: AxiosRequestConfig) {
        return UserApiFp(this.configuration).updateUser(username, body, options).then((request) => request(this.axios, this.basePath));
    }
}

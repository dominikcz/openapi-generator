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


import type { Configuration } from '../../../configuration';
import type { AxiosPromise, AxiosInstance, AxiosRequestConfig } from 'axios';
import globalAxios from 'axios';
// Some imports not used depending on template conditions
// @ts-ignore
import { DUMMY_BASE_URL, assertParamExists, setApiKeyToObject, setBasicAuthToObject, setBearerAuthToObject, setOAuthToObject, setSearchParams, serializeDataIfNeeded, toPathString, createRequestFunction } from '../../../common';
// @ts-ignore
import { BASE_PATH, COLLECTION_FORMATS, RequestArgs, BaseAPI, RequiredError } from '../../../base';
// @ts-ignore
import { ApiResponse } from '../../../model/some/levels/deep';
// @ts-ignore
import { Pet } from '../../../model/some/levels/deep';
/**
 * PetApi - axios parameter creator
 * @export
 */
export const PetApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary Add a new pet to the store
         * @param {Pet} body Pet object that needs to be added to the store
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addPet: async (body: Pet, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            assertParamExists('addPet', 'body', body)
            const localVarPath = `/pet`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)


    
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
         * @summary Deletes a pet
         * @param {number} petId Pet id to delete
         * @param {string} [apiKey] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deletePet: async (petId: number, apiKey?: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'petId' is not null or undefined
            assertParamExists('deletePet', 'petId', petId)
            const localVarPath = `/pet/{petId}`
                .replace(`{${"petId"}}`, encodeURIComponent(String(petId)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'DELETE', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)

            if (apiKey != null) {
                localVarHeaderParameter['api_key'] = String(apiKey);
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
         * Multiple status values can be provided with comma separated strings
         * @summary Finds Pets by status
         * @param {Array<FindPetsByStatusStatusEnum>} status Status values that need to be considered for filter
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        findPetsByStatus: async (status: Array<FindPetsByStatusStatusEnum>, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'status' is not null or undefined
            assertParamExists('findPetsByStatus', 'status', status)
            const localVarPath = `/pet/findByStatus`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)

            if (status) {
                localVarQueryParameter['status'] = status.join(COLLECTION_FORMATS.csv);
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
         * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
         * @summary Finds Pets by tags
         * @param {Array<string>} tags Tags to filter by
         * @param {*} [options] Override http request option.
         * @deprecated
         * @throws {RequiredError}
         */
        findPetsByTags: async (tags: Array<string>, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'tags' is not null or undefined
            assertParamExists('findPetsByTags', 'tags', tags)
            const localVarPath = `/pet/findByTags`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)

            if (tags) {
                localVarQueryParameter['tags'] = tags.join(COLLECTION_FORMATS.csv);
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
         * Returns a single pet
         * @summary Find pet by ID
         * @param {number} petId ID of pet to return
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getPetById: async (petId: number, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'petId' is not null or undefined
            assertParamExists('getPetById', 'petId', petId)
            const localVarPath = `/pet/{petId}`
                .replace(`{${"petId"}}`, encodeURIComponent(String(petId)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'GET', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication api_key required
            await setApiKeyToObject(localVarHeaderParameter, "api_key", configuration)


    
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
         * @summary Update an existing pet
         * @param {Pet} body Pet object that needs to be added to the store
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updatePet: async (body: Pet, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'body' is not null or undefined
            assertParamExists('updatePet', 'body', body)
            const localVarPath = `/pet`;
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'PUT', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)


    
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
         * @summary Updates a pet in the store with form data
         * @param {number} petId ID of pet that needs to be updated
         * @param {string} [name] Updated name of the pet
         * @param {string} [status] Updated status of the pet
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updatePetWithForm: async (petId: number, name?: string, status?: string, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'petId' is not null or undefined
            assertParamExists('updatePetWithForm', 'petId', petId)
            const localVarPath = `/pet/{petId}`
                .replace(`{${"petId"}}`, encodeURIComponent(String(petId)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;
            const localVarFormParams = new URLSearchParams();

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)


            if (name !== undefined) { 
                localVarFormParams.set('name', name as any);
            }
    
            if (status !== undefined) { 
                localVarFormParams.set('status', status as any);
            }
    
    
            localVarHeaderParameter['Content-Type'] = 'application/x-www-form-urlencoded';
    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = localVarFormParams.toString();

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary uploads an image
         * @param {number} petId ID of pet to update
         * @param {string} [additionalMetadata] Additional data to pass to server
         * @param {File} [file] file to upload
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        uploadFile: async (petId: number, additionalMetadata?: string, file?: File, options: AxiosRequestConfig = {}): Promise<RequestArgs> => {
            // verify required parameter 'petId' is not null or undefined
            assertParamExists('uploadFile', 'petId', petId)
            const localVarPath = `/pet/{petId}/uploadImage`
                .replace(`{${"petId"}}`, encodeURIComponent(String(petId)));
            // use dummy base URL string because the URL constructor only accepts absolute URLs.
            const localVarUrlObj = new URL(localVarPath, DUMMY_BASE_URL);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }

            const localVarRequestOptions = { method: 'POST', ...baseOptions, ...options};
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;
            const localVarFormParams = new ((configuration && configuration.formDataCtor) || FormData)();

            // authentication petstore_auth required
            // oauth required
            await setOAuthToObject(localVarHeaderParameter, "petstore_auth", ["write:pets", "read:pets"], configuration)


            if (additionalMetadata !== undefined) { 
                localVarFormParams.append('additionalMetadata', additionalMetadata as any);
            }
    
            if (file !== undefined) { 
                localVarFormParams.append('file', file as any);
            }
    
    
            localVarHeaderParameter['Content-Type'] = 'multipart/form-data';
    
            setSearchParams(localVarUrlObj, localVarQueryParameter);
            let headersFromBaseOptions = baseOptions && baseOptions.headers ? baseOptions.headers : {};
            localVarRequestOptions.headers = {...localVarHeaderParameter, ...headersFromBaseOptions, ...options.headers};
            localVarRequestOptions.data = localVarFormParams;

            return {
                url: toPathString(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * PetApi - functional programming interface
 * @export
 */
export const PetApiFp = function(configuration?: Configuration) {
    const localVarAxiosParamCreator = PetApiAxiosParamCreator(configuration)
    return {
        /**
         * 
         * @summary Add a new pet to the store
         * @param {Pet} body Pet object that needs to be added to the store
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async addPet(body: Pet, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.addPet(body, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Deletes a pet
         * @param {number} petId Pet id to delete
         * @param {string} [apiKey] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async deletePet(petId: number, apiKey?: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.deletePet(petId, apiKey, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * Multiple status values can be provided with comma separated strings
         * @summary Finds Pets by status
         * @param {Array<FindPetsByStatusStatusEnum>} status Status values that need to be considered for filter
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async findPetsByStatus(status: Array<FindPetsByStatusStatusEnum>, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Array<Pet>>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.findPetsByStatus(status, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
         * @summary Finds Pets by tags
         * @param {Array<string>} tags Tags to filter by
         * @param {*} [options] Override http request option.
         * @deprecated
         * @throws {RequiredError}
         */
        async findPetsByTags(tags: Array<string>, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Array<Pet>>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.findPetsByTags(tags, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * Returns a single pet
         * @summary Find pet by ID
         * @param {number} petId ID of pet to return
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async getPetById(petId: number, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<Pet>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.getPetById(petId, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Update an existing pet
         * @param {Pet} body Pet object that needs to be added to the store
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async updatePet(body: Pet, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.updatePet(body, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary Updates a pet in the store with form data
         * @param {number} petId ID of pet that needs to be updated
         * @param {string} [name] Updated name of the pet
         * @param {string} [status] Updated status of the pet
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async updatePetWithForm(petId: number, name?: string, status?: string, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<void>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.updatePetWithForm(petId, name, status, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
        /**
         * 
         * @summary uploads an image
         * @param {number} petId ID of pet to update
         * @param {string} [additionalMetadata] Additional data to pass to server
         * @param {File} [file] file to upload
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        async uploadFile(petId: number, additionalMetadata?: string, file?: File, options?: AxiosRequestConfig): Promise<(axios?: AxiosInstance, basePath?: string) => AxiosPromise<ApiResponse>> {
            const localVarAxiosArgs = await localVarAxiosParamCreator.uploadFile(petId, additionalMetadata, file, options);
            return createRequestFunction(localVarAxiosArgs, globalAxios, BASE_PATH, configuration);
        },
    }
};

/**
 * PetApi - factory interface
 * @export
 */
export const PetApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    const localVarFp = PetApiFp(configuration)
    return {
        /**
         * 
         * @summary Add a new pet to the store
         * @param {Pet} body Pet object that needs to be added to the store
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addPet(body: Pet, options?: any): AxiosPromise<void> {
            return localVarFp.addPet(body, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Deletes a pet
         * @param {number} petId Pet id to delete
         * @param {string} [apiKey] 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        deletePet(petId: number, apiKey?: string, options?: any): AxiosPromise<void> {
            return localVarFp.deletePet(petId, apiKey, options).then((request) => request(axios, basePath));
        },
        /**
         * Multiple status values can be provided with comma separated strings
         * @summary Finds Pets by status
         * @param {Array<FindPetsByStatusStatusEnum>} status Status values that need to be considered for filter
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        findPetsByStatus(status: Array<FindPetsByStatusStatusEnum>, options?: any): AxiosPromise<Array<Pet>> {
            return localVarFp.findPetsByStatus(status, options).then((request) => request(axios, basePath));
        },
        /**
         * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
         * @summary Finds Pets by tags
         * @param {Array<string>} tags Tags to filter by
         * @param {*} [options] Override http request option.
         * @deprecated
         * @throws {RequiredError}
         */
        findPetsByTags(tags: Array<string>, options?: any): AxiosPromise<Array<Pet>> {
            return localVarFp.findPetsByTags(tags, options).then((request) => request(axios, basePath));
        },
        /**
         * Returns a single pet
         * @summary Find pet by ID
         * @param {number} petId ID of pet to return
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getPetById(petId: number, options?: any): AxiosPromise<Pet> {
            return localVarFp.getPetById(petId, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Update an existing pet
         * @param {Pet} body Pet object that needs to be added to the store
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updatePet(body: Pet, options?: any): AxiosPromise<void> {
            return localVarFp.updatePet(body, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary Updates a pet in the store with form data
         * @param {number} petId ID of pet that needs to be updated
         * @param {string} [name] Updated name of the pet
         * @param {string} [status] Updated status of the pet
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        updatePetWithForm(petId: number, name?: string, status?: string, options?: any): AxiosPromise<void> {
            return localVarFp.updatePetWithForm(petId, name, status, options).then((request) => request(axios, basePath));
        },
        /**
         * 
         * @summary uploads an image
         * @param {number} petId ID of pet to update
         * @param {string} [additionalMetadata] Additional data to pass to server
         * @param {File} [file] file to upload
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        uploadFile(petId: number, additionalMetadata?: string, file?: File, options?: any): AxiosPromise<ApiResponse> {
            return localVarFp.uploadFile(petId, additionalMetadata, file, options).then((request) => request(axios, basePath));
        },
    };
};

/**
 * PetApi - object-oriented interface
 * @export
 * @class PetApi
 * @extends {BaseAPI}
 */
export class PetApi extends BaseAPI {
    /**
     * 
     * @summary Add a new pet to the store
     * @param {Pet} body Pet object that needs to be added to the store
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public addPet(body: Pet, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).addPet(body, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Deletes a pet
     * @param {number} petId Pet id to delete
     * @param {string} [apiKey] 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public deletePet(petId: number, apiKey?: string, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).deletePet(petId, apiKey, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * Multiple status values can be provided with comma separated strings
     * @summary Finds Pets by status
     * @param {Array<FindPetsByStatusStatusEnum>} status Status values that need to be considered for filter
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public findPetsByStatus(status: Array<FindPetsByStatusStatusEnum>, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).findPetsByStatus(status, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * @summary Finds Pets by tags
     * @param {Array<string>} tags Tags to filter by
     * @param {*} [options] Override http request option.
     * @deprecated
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public findPetsByTags(tags: Array<string>, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).findPetsByTags(tags, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * Returns a single pet
     * @summary Find pet by ID
     * @param {number} petId ID of pet to return
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public getPetById(petId: number, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).getPetById(petId, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Update an existing pet
     * @param {Pet} body Pet object that needs to be added to the store
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public updatePet(body: Pet, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).updatePet(body, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary Updates a pet in the store with form data
     * @param {number} petId ID of pet that needs to be updated
     * @param {string} [name] Updated name of the pet
     * @param {string} [status] Updated status of the pet
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public updatePetWithForm(petId: number, name?: string, status?: string, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).updatePetWithForm(petId, name, status, options).then((request) => request(this.axios, this.basePath));
    }

    /**
     * 
     * @summary uploads an image
     * @param {number} petId ID of pet to update
     * @param {string} [additionalMetadata] Additional data to pass to server
     * @param {File} [file] file to upload
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof PetApi
     */
    public uploadFile(petId: number, additionalMetadata?: string, file?: File, options?: AxiosRequestConfig) {
        return PetApiFp(this.configuration).uploadFile(petId, additionalMetadata, file, options).then((request) => request(this.axios, this.basePath));
    }
}

/**
 * @export
 */
export const FindPetsByStatusStatusEnum = {
    Available: 'available',
    Pending: 'pending',
    Sold: 'sold'
} as const;
export type FindPetsByStatusStatusEnum = typeof FindPetsByStatusStatusEnum[keyof typeof FindPetsByStatusStatusEnum];

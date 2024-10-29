/* tslint:disable */
/* eslint-disable */
/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
/**
 * Model for testing model name same as property name
 * @export
 * @interface Name
 */
export interface Name {
    /**
     * 
     * @type {number}
     * @memberof Name
     */
    name: number;
    /**
     * 
     * @type {number}
     * @memberof Name
     */
    readonly snakeCase?: number;
    /**
     * 
     * @type {string}
     * @memberof Name
     */
    property?: string;
    /**
     * 
     * @type {number}
     * @memberof Name
     */
    readonly _123number?: number;
}

/**
 * Check if a given object implements the Name interface.
 */
export function instanceOfName(value: object): value is Name {
    if (!('name' in value) || value['name'] === undefined) return false;
    return true;
}

export function NameFromJSON(json: any): Name {
    return NameFromJSONTyped(json, false);
}

export function NameFromJSONTyped(json: any, ignoreDiscriminator: boolean): Name {
    if (json == null) {
        return json;
    }
    return {
        
        'name': json['name'],
        'snakeCase': json['snake_case'] == null ? undefined : json['snake_case'],
        'property': json['property'] == null ? undefined : json['property'],
        '_123number': json['123Number'] == null ? undefined : json['123Number'],
    };
}

  export function NameToJSON(json: any): Name {
      return NameToJSONTyped(json, false);
  }

  export function NameToJSONTyped(value?: Omit<Name, 'snake_case'|'123Number'> | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'name': value['name'],
        'property': value['property'],
    };
}


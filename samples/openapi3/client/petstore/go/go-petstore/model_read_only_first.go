/*
OpenAPI Petstore

This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\

API version: 1.0.0
*/

// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

package petstore

import (
	"encoding/json"
)

// checks if the ReadOnlyFirst type satisfies the MappedNullable interface at compile time
var _ MappedNullable = &ReadOnlyFirst{}

// ReadOnlyFirst struct for ReadOnlyFirst
type ReadOnlyFirst struct {
	Bar *string `json:"bar,omitempty"`
	Baz *string `json:"baz,omitempty"`
	AdditionalProperties map[string]interface{}
}

type _ReadOnlyFirst ReadOnlyFirst

// NewReadOnlyFirst instantiates a new ReadOnlyFirst object
// This constructor will assign default values to properties that have it defined,
// and makes sure properties required by API are set, but the set of arguments
// will change when the set of required properties is changed
func NewReadOnlyFirst() *ReadOnlyFirst {
	this := ReadOnlyFirst{}
	return &this
}

// NewReadOnlyFirstWithDefaults instantiates a new ReadOnlyFirst object
// This constructor will only assign default values to properties that have it defined,
// but it doesn't guarantee that properties required by API are set
func NewReadOnlyFirstWithDefaults() *ReadOnlyFirst {
	this := ReadOnlyFirst{}
	return &this
}

// GetBar returns the Bar field value if set, zero value otherwise.
func (o *ReadOnlyFirst) GetBar() string {
	if o == nil || IsNil(o.Bar) {
		var ret string
		return ret
	}
	return *o.Bar
}

// GetBarOk returns a tuple with the Bar field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ReadOnlyFirst) GetBarOk() (*string, bool) {
	if o == nil || IsNil(o.Bar) {
		return nil, false
	}
	return o.Bar, true
}

// HasBar returns a boolean if a field has been set.
func (o *ReadOnlyFirst) HasBar() bool {
	if o != nil && !IsNil(o.Bar) {
		return true
	}

	return false
}

// SetBar gets a reference to the given string and assigns it to the Bar field.
func (o *ReadOnlyFirst) SetBar(v string) {
	o.Bar = &v
}

// GetBaz returns the Baz field value if set, zero value otherwise.
func (o *ReadOnlyFirst) GetBaz() string {
	if o == nil || IsNil(o.Baz) {
		var ret string
		return ret
	}
	return *o.Baz
}

// GetBazOk returns a tuple with the Baz field value if set, nil otherwise
// and a boolean to check if the value has been set.
func (o *ReadOnlyFirst) GetBazOk() (*string, bool) {
	if o == nil || IsNil(o.Baz) {
		return nil, false
	}
	return o.Baz, true
}

// HasBaz returns a boolean if a field has been set.
func (o *ReadOnlyFirst) HasBaz() bool {
	if o != nil && !IsNil(o.Baz) {
		return true
	}

	return false
}

// SetBaz gets a reference to the given string and assigns it to the Baz field.
func (o *ReadOnlyFirst) SetBaz(v string) {
	o.Baz = &v
}

func (o ReadOnlyFirst) MarshalJSON() ([]byte, error) {
	toSerialize,err := o.ToMap()
	if err != nil {
		return []byte{}, err
	}
	return json.Marshal(toSerialize)
}

func (o ReadOnlyFirst) ToMap() (map[string]interface{}, error) {
	toSerialize := map[string]interface{}{}
	if !IsNil(o.Bar) {
		toSerialize["bar"] = o.Bar
	}
	if !IsNil(o.Baz) {
		toSerialize["baz"] = o.Baz
	}

	for key, value := range o.AdditionalProperties {
		toSerialize[key] = value
	}

	return toSerialize, nil
}

func (o *ReadOnlyFirst) UnmarshalJSON(data []byte) (err error) {
	varReadOnlyFirst := _ReadOnlyFirst{}

	err = json.Unmarshal(data, &varReadOnlyFirst)

	if err != nil {
		return err
	}

	*o = ReadOnlyFirst(varReadOnlyFirst)

	additionalProperties := make(map[string]interface{})

	if err = json.Unmarshal(data, &additionalProperties); err == nil {
		delete(additionalProperties, "bar")
		delete(additionalProperties, "baz")
		o.AdditionalProperties = additionalProperties
	}

	return err
}

type NullableReadOnlyFirst struct {
	value *ReadOnlyFirst
	isSet bool
}

func (v NullableReadOnlyFirst) Get() *ReadOnlyFirst {
	return v.value
}

func (v *NullableReadOnlyFirst) Set(val *ReadOnlyFirst) {
	v.value = val
	v.isSet = true
}

func (v NullableReadOnlyFirst) IsSet() bool {
	return v.isSet
}

func (v *NullableReadOnlyFirst) Unset() {
	v.value = nil
	v.isSet = false
}

func NewNullableReadOnlyFirst(val *ReadOnlyFirst) *NullableReadOnlyFirst {
	return &NullableReadOnlyFirst{value: val, isSet: true}
}

func (v NullableReadOnlyFirst) MarshalJSON() ([]byte, error) {
	return json.Marshal(v.value)
}

func (v *NullableReadOnlyFirst) UnmarshalJSON(src []byte) error {
	v.isSet = true
	return json.Unmarshal(src, &v.value)
}



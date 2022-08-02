# coding: utf-8

"""
    OpenAPI Petstore

    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""

import re  # noqa: F401
import sys  # noqa: F401
import typing  # noqa: F401
import functools  # noqa: F401

from frozendict import frozendict  # noqa: F401

import decimal  # noqa: F401
from datetime import date, datetime  # noqa: F401
from frozendict import frozendict  # noqa: F401

from petstore_api.schemas import (  # noqa: F401
    AnyTypeSchema,
    ComposedSchema,
    DictSchema,
    ListSchema,
    StrSchema,
    IntSchema,
    Int32Schema,
    Int64Schema,
    Float32Schema,
    Float64Schema,
    NumberSchema,
    UUIDSchema,
    DateSchema,
    DateTimeSchema,
    DecimalSchema,
    BoolSchema,
    BinarySchema,
    NoneSchema,
    none_type,
    Configuration,
    Unset,
    unset,
    ComposedBase,
    ListBase,
    DictBase,
    NoneBase,
    StrBase,
    IntBase,
    Int32Base,
    Int64Base,
    Float32Base,
    Float64Base,
    NumberBase,
    UUIDBase,
    DateBase,
    DateTimeBase,
    BoolBase,
    BinaryBase,
    Schema,
    NoneClass,
    BoolClass,
    _SchemaValidator,
    _SchemaTypeChecker,
    _SchemaEnumMaker
)


class AdditionalPropertiesClass(
    DictSchema
):
    """NOTE: This class is auto generated by OpenAPI Generator.
    Ref: https://openapi-generator.tech

    Do not edit the class manually.
    """
    
    
    class map_property(
        DictSchema
    ):
        _additional_properties = StrSchema
    
    
        def __new__(
            cls,
            *args: typing.Union[dict, frozendict, ],
            _configuration: typing.Optional[Configuration] = None,
            **kwargs: typing.Type[Schema],
        ) -> 'map_property':
            return super().__new__(
                cls,
                *args,
                _configuration=_configuration,
                **kwargs,
            )
    
    
    class map_of_map_property(
        DictSchema
    ):
        
        
        class _additional_properties(
            DictSchema
        ):
            _additional_properties = StrSchema
        
        
            def __new__(
                cls,
                *args: typing.Union[dict, frozendict, ],
                _configuration: typing.Optional[Configuration] = None,
                **kwargs: typing.Type[Schema],
            ) -> '_additional_properties':
                return super().__new__(
                    cls,
                    *args,
                    _configuration=_configuration,
                    **kwargs,
                )
    
    
        def __new__(
            cls,
            *args: typing.Union[dict, frozendict, ],
            _configuration: typing.Optional[Configuration] = None,
            **kwargs: typing.Type[Schema],
        ) -> 'map_of_map_property':
            return super().__new__(
                cls,
                *args,
                _configuration=_configuration,
                **kwargs,
            )
    anytype_1 = AnyTypeSchema
    map_with_undeclared_properties_anytype_1 = DictSchema
    map_with_undeclared_properties_anytype_2 = DictSchema
    map_with_undeclared_properties_anytype_3 = DictSchema
    
    
    class empty_map(
        DictSchema
    ):
        _additional_properties = None
    
    
        def __new__(
            cls,
            *args: typing.Union[dict, frozendict, ],
            _configuration: typing.Optional[Configuration] = None,
        ) -> 'empty_map':
            return super().__new__(
                cls,
                *args,
                _configuration=_configuration,
            )
    
    
    class map_with_undeclared_properties_string(
        DictSchema
    ):
        _additional_properties = StrSchema
    
    
        def __new__(
            cls,
            *args: typing.Union[dict, frozendict, ],
            _configuration: typing.Optional[Configuration] = None,
            **kwargs: typing.Type[Schema],
        ) -> 'map_with_undeclared_properties_string':
            return super().__new__(
                cls,
                *args,
                _configuration=_configuration,
                **kwargs,
            )


    def __new__(
        cls,
        *args: typing.Union[dict, frozendict, ],
        map_property: typing.Union[map_property, Unset] = unset,
        map_of_map_property: typing.Union[map_of_map_property, Unset] = unset,
        anytype_1: typing.Union[anytype_1, Unset] = unset,
        map_with_undeclared_properties_anytype_1: typing.Union[map_with_undeclared_properties_anytype_1, Unset] = unset,
        map_with_undeclared_properties_anytype_2: typing.Union[map_with_undeclared_properties_anytype_2, Unset] = unset,
        map_with_undeclared_properties_anytype_3: typing.Union[map_with_undeclared_properties_anytype_3, Unset] = unset,
        empty_map: typing.Union[empty_map, Unset] = unset,
        map_with_undeclared_properties_string: typing.Union[map_with_undeclared_properties_string, Unset] = unset,
        _configuration: typing.Optional[Configuration] = None,
        **kwargs: typing.Type[Schema],
    ) -> 'AdditionalPropertiesClass':
        return super().__new__(
            cls,
            *args,
            map_property=map_property,
            map_of_map_property=map_of_map_property,
            anytype_1=anytype_1,
            map_with_undeclared_properties_anytype_1=map_with_undeclared_properties_anytype_1,
            map_with_undeclared_properties_anytype_2=map_with_undeclared_properties_anytype_2,
            map_with_undeclared_properties_anytype_3=map_with_undeclared_properties_anytype_3,
            empty_map=empty_map,
            map_with_undeclared_properties_string=map_with_undeclared_properties_string,
            _configuration=_configuration,
            **kwargs,
        )

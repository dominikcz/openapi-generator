# coding: utf-8

"""
    OpenAPI Petstore

    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\

    The version of the OpenAPI document: 1.0.0
    Generated by OpenAPI Generator (https://openapi-generator.tech)

    Do not edit the class manually.
"""  # noqa: E501


import unittest
import datetime

from petstore_api.models.bathing import Bathing  # noqa: E501

class TestBathing(unittest.TestCase):
    """Bathing unit test stubs"""

    def setUp(self):
        pass

    def tearDown(self):
        pass

    def make_instance(self, include_optional) -> Bathing:
        """Test Bathing
            include_option is a boolean, when False only required
            params are included, when True both required and
            optional params are included """
        # uncomment below to create an instance of `Bathing`
        """
        model = Bathing()  # noqa: E501
        if include_optional:
            return Bathing(
                task_name = 'cleaning_deep',
                function_name = 'care_nourish',
                content = ''
            )
        else:
            return Bathing(
                task_name = 'cleaning_deep',
                function_name = 'care_nourish',
                content = '',
        )
        """

    def testBathing(self):
        """Test Bathing"""
        # inst_req_only = self.make_instance(include_optional=False)
        # inst_req_and_optional = self.make_instance(include_optional=True)

if __name__ == '__main__':
    unittest.main()

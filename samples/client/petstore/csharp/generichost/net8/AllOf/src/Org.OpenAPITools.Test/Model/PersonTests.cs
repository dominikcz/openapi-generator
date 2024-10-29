/*
 * Example
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using Xunit;

using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using Org.OpenAPITools.Model;
using Org.OpenAPITools.Client;
using System.Reflection;

namespace Org.OpenAPITools.Test.Model
{
    /// <summary>
    ///  Class for testing Person
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the model.
    /// </remarks>
    public class PersonTests : IDisposable
    {
        // TODO uncomment below to declare an instance variable for Person
        //private Person instance;

        public PersonTests()
        {
            // TODO uncomment below to create an instance of Person
            //instance = new Person();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of Person
        /// </summary>
        [Fact]
        public void PersonInstanceTest()
        {
            // TODO uncomment below to test "IsType" Person
            //Assert.IsType<Person>(instance);
        }

        /// <summary>
        /// Test deserialize a Adult from type Person
        /// </summary>
        [Fact]
        public void AdultDeserializeFromPersonTest()
        {
            // TODO uncomment below to test deserialize a Adult from type Person
            //Assert.IsType<Person>(JsonConvert.DeserializeObject<Person>(new Adult().ToJson()));
        }

        /// <summary>
        /// Test deserialize a Child from type Person
        /// </summary>
        [Fact]
        public void ChildDeserializeFromPersonTest()
        {
            // TODO uncomment below to test deserialize a Child from type Person
            //Assert.IsType<Person>(JsonConvert.DeserializeObject<Person>(new Child().ToJson()));
        }

        /// <summary>
        /// Test the property 'FirstName'
        /// </summary>
        [Fact]
        public void FirstNameTest()
        {
            // TODO unit test for the property 'FirstName'
        }

        /// <summary>
        /// Test the property 'LastName'
        /// </summary>
        [Fact]
        public void LastNameTest()
        {
            // TODO unit test for the property 'LastName'
        }

        /// <summary>
        /// Test the property 'Type'
        /// </summary>
        [Fact]
        public void TypeTest()
        {
            // TODO unit test for the property 'Type'
        }
    }
}

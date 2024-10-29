/*
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;
using OpenAPIClientUtils = Org.OpenAPITools.Client.ClientUtils;

namespace Org.OpenAPITools.Model
{
    /// <summary>
    /// EnumTest
    /// </summary>
    [DataContract(Name = "Enum_Test")]
    public partial class EnumTest : IEquatable<EnumTest>, IValidatableObject
    {
        /// <summary>
        /// Defines EnumString
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EnumStringEnum
        {
            /// <summary>
            /// Enum UPPER for value: UPPER
            /// </summary>
            [EnumMember(Value = "UPPER")]
            UPPER = 1,

            /// <summary>
            /// Enum Lower for value: lower
            /// </summary>
            [EnumMember(Value = "lower")]
            Lower = 2,

            /// <summary>
            /// Enum Empty for value: 
            /// </summary>
            [EnumMember(Value = "")]
            Empty = 3,

            /// <summary>
            /// Enum ValuewithTab for value: Value\twith tab
            /// </summary>
            [EnumMember(Value = "Value\twith tab")]
            ValuewithTab = 4,

            /// <summary>
            /// Enum ValueWithQuote for value: Value with \&quot; quote
            /// </summary>
            [EnumMember(Value = "Value with \" quote")]
            ValueWithQuote = 5,

            /// <summary>
            /// Enum ValueWithEscapedQuote for value: Value with escaped \&quot; quote
            /// </summary>
            [EnumMember(Value = "Value with escaped \" quote")]
            ValueWithEscapedQuote = 6,

            /// <summary>
            /// Enum Duplicatevalue for value: Duplicate\nvalue
            /// </summary>
            [EnumMember(Value = "Duplicate\nvalue")]
            Duplicatevalue = 7,

            /// <summary>
            /// Enum Duplicatevalue2 for value: Duplicate\r\nvalue
            /// </summary>
            [EnumMember(Value = "Duplicate\r\nvalue")]
            Duplicatevalue2 = 8
        }


        /// <summary>
        /// Gets or Sets EnumString
        /// </summary>
        [DataMember(Name = "enum_string", EmitDefaultValue = false)]
        public EnumStringEnum? EnumString { get; set; }
        /// <summary>
        /// Defines EnumStringRequired
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EnumStringRequiredEnum
        {
            /// <summary>
            /// Enum UPPER for value: UPPER
            /// </summary>
            [EnumMember(Value = "UPPER")]
            UPPER = 1,

            /// <summary>
            /// Enum Lower for value: lower
            /// </summary>
            [EnumMember(Value = "lower")]
            Lower = 2,

            /// <summary>
            /// Enum Empty for value: 
            /// </summary>
            [EnumMember(Value = "")]
            Empty = 3,

            /// <summary>
            /// Enum ValuewithTab for value: Value\twith tab
            /// </summary>
            [EnumMember(Value = "Value\twith tab")]
            ValuewithTab = 4,

            /// <summary>
            /// Enum ValueWithQuote for value: Value with \&quot; quote
            /// </summary>
            [EnumMember(Value = "Value with \" quote")]
            ValueWithQuote = 5,

            /// <summary>
            /// Enum ValueWithEscapedQuote for value: Value with escaped \&quot; quote
            /// </summary>
            [EnumMember(Value = "Value with escaped \" quote")]
            ValueWithEscapedQuote = 6,

            /// <summary>
            /// Enum Duplicatevalue for value: Duplicate\nvalue
            /// </summary>
            [EnumMember(Value = "Duplicate\nvalue")]
            Duplicatevalue = 7,

            /// <summary>
            /// Enum Duplicatevalue2 for value: Duplicate\r\nvalue
            /// </summary>
            [EnumMember(Value = "Duplicate\r\nvalue")]
            Duplicatevalue2 = 8
        }


        /// <summary>
        /// Gets or Sets EnumStringRequired
        /// </summary>
        [DataMember(Name = "enum_string_required", IsRequired = true, EmitDefaultValue = true)]
        public EnumStringRequiredEnum EnumStringRequired { get; set; }
        /// <summary>
        /// Defines EnumInteger
        /// </summary>
        public enum EnumIntegerEnum
        {
            /// <summary>
            /// Enum NUMBER_1 for value: 1
            /// </summary>
            NUMBER_1 = 1,

            /// <summary>
            /// Enum NUMBER_MINUS_1 for value: -1
            /// </summary>
            NUMBER_MINUS_1 = -1
        }


        /// <summary>
        /// Gets or Sets EnumInteger
        /// </summary>
        [DataMember(Name = "enum_integer", EmitDefaultValue = false)]
        public EnumIntegerEnum? EnumInteger { get; set; }
        /// <summary>
        /// Defines EnumIntegerOnly
        /// </summary>
        public enum EnumIntegerOnlyEnum
        {
            /// <summary>
            /// Enum NUMBER_2 for value: 2
            /// </summary>
            NUMBER_2 = 2,

            /// <summary>
            /// Enum NUMBER_MINUS_2 for value: -2
            /// </summary>
            NUMBER_MINUS_2 = -2
        }


        /// <summary>
        /// Gets or Sets EnumIntegerOnly
        /// </summary>
        [DataMember(Name = "enum_integer_only", EmitDefaultValue = false)]
        public EnumIntegerOnlyEnum? EnumIntegerOnly { get; set; }
        /// <summary>
        /// Defines EnumNumber
        /// </summary>
        [JsonConverter(typeof(StringEnumConverter))]
        public enum EnumNumberEnum
        {
            /// <summary>
            /// Enum NUMBER_1_DOT_1 for value: 1.1
            /// </summary>
            [EnumMember(Value = "1.1")]
            NUMBER_1_DOT_1 = 1,

            /// <summary>
            /// Enum NUMBER_MINUS_1_DOT_2 for value: -1.2
            /// </summary>
            [EnumMember(Value = "-1.2")]
            NUMBER_MINUS_1_DOT_2 = 2
        }


        /// <summary>
        /// Gets or Sets EnumNumber
        /// </summary>
        [DataMember(Name = "enum_number", EmitDefaultValue = false)]
        public EnumNumberEnum? EnumNumber { get; set; }

        /// <summary>
        /// Gets or Sets OuterEnum
        /// </summary>
        [DataMember(Name = "outerEnum", EmitDefaultValue = true)]
        public OuterEnum? OuterEnum { get; set; }

        /// <summary>
        /// Gets or Sets OuterEnumInteger
        /// </summary>
        [DataMember(Name = "outerEnumInteger", EmitDefaultValue = false)]
        public OuterEnumInteger? OuterEnumInteger { get; set; }

        /// <summary>
        /// Gets or Sets OuterEnumDefaultValue
        /// </summary>
        [DataMember(Name = "outerEnumDefaultValue", EmitDefaultValue = false)]
        public OuterEnumDefaultValue? OuterEnumDefaultValue { get; set; }

        /// <summary>
        /// Gets or Sets OuterEnumIntegerDefaultValue
        /// </summary>
        [DataMember(Name = "outerEnumIntegerDefaultValue", EmitDefaultValue = false)]
        public OuterEnumIntegerDefaultValue? OuterEnumIntegerDefaultValue { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="EnumTest" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected EnumTest()
        {
            this.AdditionalProperties = new Dictionary<string, object>();
        }
        /// <summary>
        /// Initializes a new instance of the <see cref="EnumTest" /> class.
        /// </summary>
        /// <param name="enumString">enumString.</param>
        /// <param name="enumStringRequired">enumStringRequired (required).</param>
        /// <param name="enumInteger">enumInteger.</param>
        /// <param name="enumIntegerOnly">enumIntegerOnly.</param>
        /// <param name="enumNumber">enumNumber.</param>
        /// <param name="outerEnum">outerEnum.</param>
        /// <param name="outerEnumInteger">outerEnumInteger.</param>
        /// <param name="outerEnumDefaultValue">outerEnumDefaultValue.</param>
        /// <param name="outerEnumIntegerDefaultValue">outerEnumIntegerDefaultValue.</param>
        public EnumTest(EnumStringEnum? enumString = default(EnumStringEnum?), EnumStringRequiredEnum enumStringRequired = default(EnumStringRequiredEnum), EnumIntegerEnum? enumInteger = default(EnumIntegerEnum?), EnumIntegerOnlyEnum? enumIntegerOnly = default(EnumIntegerOnlyEnum?), EnumNumberEnum? enumNumber = default(EnumNumberEnum?), OuterEnum? outerEnum = default(OuterEnum?), OuterEnumInteger? outerEnumInteger = default(OuterEnumInteger?), OuterEnumDefaultValue? outerEnumDefaultValue = default(OuterEnumDefaultValue?), OuterEnumIntegerDefaultValue? outerEnumIntegerDefaultValue = default(OuterEnumIntegerDefaultValue?))
        {
            this.EnumStringRequired = enumStringRequired;
            this.EnumString = enumString;
            this.EnumInteger = enumInteger;
            this.EnumIntegerOnly = enumIntegerOnly;
            this.EnumNumber = enumNumber;
            this.OuterEnum = outerEnum;
            this.OuterEnumInteger = outerEnumInteger;
            this.OuterEnumDefaultValue = outerEnumDefaultValue;
            this.OuterEnumIntegerDefaultValue = outerEnumIntegerDefaultValue;
            this.AdditionalProperties = new Dictionary<string, object>();
        }

        /// <summary>
        /// Gets or Sets additional properties
        /// </summary>
        [JsonExtensionData]
        public IDictionary<string, object> AdditionalProperties { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class EnumTest {\n");
            sb.Append("  EnumString: ").Append(EnumString).Append("\n");
            sb.Append("  EnumStringRequired: ").Append(EnumStringRequired).Append("\n");
            sb.Append("  EnumInteger: ").Append(EnumInteger).Append("\n");
            sb.Append("  EnumIntegerOnly: ").Append(EnumIntegerOnly).Append("\n");
            sb.Append("  EnumNumber: ").Append(EnumNumber).Append("\n");
            sb.Append("  OuterEnum: ").Append(OuterEnum).Append("\n");
            sb.Append("  OuterEnumInteger: ").Append(OuterEnumInteger).Append("\n");
            sb.Append("  OuterEnumDefaultValue: ").Append(OuterEnumDefaultValue).Append("\n");
            sb.Append("  OuterEnumIntegerDefaultValue: ").Append(OuterEnumIntegerDefaultValue).Append("\n");
            sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public virtual string ToJson()
        {
            return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="input">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object input)
        {
            return OpenAPIClientUtils.compareLogic.Compare(this, input as EnumTest).AreEqual;
        }

        /// <summary>
        /// Returns true if EnumTest instances are equal
        /// </summary>
        /// <param name="input">Instance of EnumTest to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(EnumTest input)
        {
            return OpenAPIClientUtils.compareLogic.Compare(this, input).AreEqual;
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            unchecked // Overflow is fine, just wrap
            {
                int hashCode = 41;
                hashCode = (hashCode * 59) + this.EnumString.GetHashCode();
                hashCode = (hashCode * 59) + this.EnumStringRequired.GetHashCode();
                hashCode = (hashCode * 59) + this.EnumInteger.GetHashCode();
                hashCode = (hashCode * 59) + this.EnumIntegerOnly.GetHashCode();
                hashCode = (hashCode * 59) + this.EnumNumber.GetHashCode();
                hashCode = (hashCode * 59) + this.OuterEnum.GetHashCode();
                hashCode = (hashCode * 59) + this.OuterEnumInteger.GetHashCode();
                hashCode = (hashCode * 59) + this.OuterEnumDefaultValue.GetHashCode();
                hashCode = (hashCode * 59) + this.OuterEnumIntegerDefaultValue.GetHashCode();
                if (this.AdditionalProperties != null)
                {
                    hashCode = (hashCode * 59) + this.AdditionalProperties.GetHashCode();
                }
                return hashCode;
            }
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }

}

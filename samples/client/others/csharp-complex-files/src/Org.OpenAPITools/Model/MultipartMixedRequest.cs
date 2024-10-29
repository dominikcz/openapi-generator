/*
 * MultipartFile test
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
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
    /// MultipartMixedRequest
    /// </summary>
    [DataContract(Name = "multipartMixed_request")]
    public partial class MultipartMixedRequest : IEquatable<MultipartMixedRequest>, IValidatableObject
    {

        /// <summary>
        /// Gets or Sets Status
        /// </summary>
        [DataMember(Name = "status", IsRequired = true, EmitDefaultValue = true)]
        public MultipartMixedStatus Status { get; set; }
        /// <summary>
        /// Initializes a new instance of the <see cref="MultipartMixedRequest" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected MultipartMixedRequest() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="MultipartMixedRequest" /> class.
        /// </summary>
        /// <param name="status">status (required).</param>
        /// <param name="marker">marker.</param>
        /// <param name="file">a file (required).</param>
        /// <param name="statusArray">statusArray.</param>
        public MultipartMixedRequest(MultipartMixedStatus status = default(MultipartMixedStatus), MultipartMixedRequestMarker marker = default(MultipartMixedRequestMarker), System.IO.Stream file = default(System.IO.Stream), List<MultipartMixedStatus> statusArray = default(List<MultipartMixedStatus>))
        {
            this.Status = status;
            // to ensure "file" is required (not null)
            if (file == null)
            {
                throw new ArgumentNullException("file is a required property for MultipartMixedRequest and cannot be null");
            }
            this.File = file;
            this.Marker = marker;
            this.StatusArray = statusArray;
        }

        /// <summary>
        /// Gets or Sets Marker
        /// </summary>
        [DataMember(Name = "marker", EmitDefaultValue = false)]
        public MultipartMixedRequestMarker Marker { get; set; }

        /// <summary>
        /// a file
        /// </summary>
        /// <value>a file</value>
        [DataMember(Name = "file", IsRequired = true, EmitDefaultValue = true)]
        public System.IO.Stream File { get; set; }

        /// <summary>
        /// Gets or Sets StatusArray
        /// </summary>
        [DataMember(Name = "statusArray", EmitDefaultValue = false)]
        public List<MultipartMixedStatus> StatusArray { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class MultipartMixedRequest {\n");
            sb.Append("  Status: ").Append(Status).Append("\n");
            sb.Append("  Marker: ").Append(Marker).Append("\n");
            sb.Append("  File: ").Append(File).Append("\n");
            sb.Append("  StatusArray: ").Append(StatusArray).Append("\n");
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
            return OpenAPIClientUtils.compareLogic.Compare(this, input as MultipartMixedRequest).AreEqual;
        }

        /// <summary>
        /// Returns true if MultipartMixedRequest instances are equal
        /// </summary>
        /// <param name="input">Instance of MultipartMixedRequest to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(MultipartMixedRequest input)
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
                hashCode = (hashCode * 59) + this.Status.GetHashCode();
                if (this.Marker != null)
                {
                    hashCode = (hashCode * 59) + this.Marker.GetHashCode();
                }
                if (this.File != null)
                {
                    hashCode = (hashCode * 59) + this.File.GetHashCode();
                }
                if (this.StatusArray != null)
                {
                    hashCode = (hashCode * 59) + this.StatusArray.GetHashCode();
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

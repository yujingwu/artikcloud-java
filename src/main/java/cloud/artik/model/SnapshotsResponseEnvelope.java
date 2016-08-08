/**
 * ARTIK Cloud API
 * No descripton provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package cloud.artik.model;

import java.util.Objects;
import cloud.artik.model.SnapshotResponses;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-08T13:51:37.707-07:00")
public class SnapshotsResponseEnvelope   {
  @SerializedName("data")
  private SnapshotResponses data = null;

  @SerializedName("sdid")
  private String sdid = null;

  public SnapshotsResponseEnvelope data(SnapshotResponses data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(example = "null", value = "")
  public SnapshotResponses getData() {
    return data;
  }

  public void setData(SnapshotResponses data) {
    this.data = data;
  }

  public SnapshotsResponseEnvelope sdid(String sdid) {
    this.sdid = sdid;
    return this;
  }

   /**
   * Get sdid
   * @return sdid
  **/
  @ApiModelProperty(example = "null", value = "")
  public String getSdid() {
    return sdid;
  }

  public void setSdid(String sdid) {
    this.sdid = sdid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SnapshotsResponseEnvelope snapshotsResponseEnvelope = (SnapshotsResponseEnvelope) o;
    return Objects.equals(this.data, snapshotsResponseEnvelope.data) &&
        Objects.equals(this.sdid, snapshotsResponseEnvelope.sdid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, sdid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SnapshotsResponseEnvelope {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    sdid: ").append(toIndentedString(sdid)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


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
import cloud.artik.model.Tag;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;


/**
 * Device Type Information
 */
@ApiModel(description = "Device Type Information")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-08-08T13:51:37.707-07:00")
public class DeviceType   {
  @SerializedName("id")
  private String id = null;

  @SerializedName("uniqueName")
  private String uniqueName = null;

  @SerializedName("latestVersion")
  private Integer latestVersion = null;

  @SerializedName("lastUpdated")
  private Long lastUpdated = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("uid")
  private String uid = null;

  @SerializedName("oid")
  private String oid = null;

  @SerializedName("hasCloudConnector")
  private Boolean hasCloudConnector = null;

  @SerializedName("approved")
  private Boolean approved = null;

  @SerializedName("published")
  private Boolean published = null;

  @SerializedName("protected")
  private Boolean _protected = null;

  @SerializedName("inStore")
  private Boolean inStore = null;

  @SerializedName("ownedByCurrentUser")
  private Boolean ownedByCurrentUser = null;

  @SerializedName("tags")
  private List<Tag> tags = new ArrayList<Tag>();

  @SerializedName("rsp")
  private Boolean rsp = null;

  @SerializedName("issuerDn")
  private String issuerDn = null;

  @SerializedName("vid")
  private String vid = null;

  public DeviceType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Device Type ID.
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "Device Type ID.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public DeviceType uniqueName(String uniqueName) {
    this.uniqueName = uniqueName;
    return this;
  }

   /**
   * Unique Name.
   * @return uniqueName
  **/
  @ApiModelProperty(example = "null", value = "Unique Name.")
  public String getUniqueName() {
    return uniqueName;
  }

  public void setUniqueName(String uniqueName) {
    this.uniqueName = uniqueName;
  }

  public DeviceType latestVersion(Integer latestVersion) {
    this.latestVersion = latestVersion;
    return this;
  }

   /**
   * Latest Manifest version.
   * @return latestVersion
  **/
  @ApiModelProperty(example = "null", value = "Latest Manifest version.")
  public Integer getLatestVersion() {
    return latestVersion;
  }

  public void setLatestVersion(Integer latestVersion) {
    this.latestVersion = latestVersion;
  }

  public DeviceType lastUpdated(Long lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

   /**
   * Get lastUpdated
   * @return lastUpdated
  **/
  @ApiModelProperty(example = "null", value = "")
  public Long getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public DeviceType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name.
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Name.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DeviceType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description.
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Description.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DeviceType uid(String uid) {
    this.uid = uid;
    return this;
  }

   /**
   * User ID.
   * @return uid
  **/
  @ApiModelProperty(example = "null", value = "User ID.")
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public DeviceType oid(String oid) {
    this.oid = oid;
    return this;
  }

   /**
   * Organization ID.
   * @return oid
  **/
  @ApiModelProperty(example = "null", value = "Organization ID.")
  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public DeviceType hasCloudConnector(Boolean hasCloudConnector) {
    this.hasCloudConnector = hasCloudConnector;
    return this;
  }

   /**
   * Uses Cloud Connectors SDK
   * @return hasCloudConnector
  **/
  @ApiModelProperty(example = "null", value = "Uses Cloud Connectors SDK")
  public Boolean getHasCloudConnector() {
    return hasCloudConnector;
  }

  public void setHasCloudConnector(Boolean hasCloudConnector) {
    this.hasCloudConnector = hasCloudConnector;
  }

  public DeviceType approved(Boolean approved) {
    this.approved = approved;
    return this;
  }

   /**
   * Approval status.
   * @return approved
  **/
  @ApiModelProperty(example = "null", value = "Approval status.")
  public Boolean getApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }

  public DeviceType published(Boolean published) {
    this.published = published;
    return this;
  }

   /**
   * Published status.
   * @return published
  **/
  @ApiModelProperty(example = "null", value = "Published status.")
  public Boolean getPublished() {
    return published;
  }

  public void setPublished(Boolean published) {
    this.published = published;
  }

  public DeviceType _protected(Boolean _protected) {
    this._protected = _protected;
    return this;
  }

   /**
   * Protected status.
   * @return _protected
  **/
  @ApiModelProperty(example = "null", value = "Protected status.")
  public Boolean getProtected() {
    return _protected;
  }

  public void setProtected(Boolean _protected) {
    this._protected = _protected;
  }

  public DeviceType inStore(Boolean inStore) {
    this.inStore = inStore;
    return this;
  }

   /**
   * In Store.
   * @return inStore
  **/
  @ApiModelProperty(example = "null", value = "In Store.")
  public Boolean getInStore() {
    return inStore;
  }

  public void setInStore(Boolean inStore) {
    this.inStore = inStore;
  }

  public DeviceType ownedByCurrentUser(Boolean ownedByCurrentUser) {
    this.ownedByCurrentUser = ownedByCurrentUser;
    return this;
  }

   /**
   * Does the current user own a device of this device type
   * @return ownedByCurrentUser
  **/
  @ApiModelProperty(example = "null", value = "Does the current user own a device of this device type")
  public Boolean getOwnedByCurrentUser() {
    return ownedByCurrentUser;
  }

  public void setOwnedByCurrentUser(Boolean ownedByCurrentUser) {
    this.ownedByCurrentUser = ownedByCurrentUser;
  }

  public DeviceType tags(List<Tag> tags) {
    this.tags = tags;
    return this;
  }

  public DeviceType addTagsItem(Tag tagsItem) {
    this.tags.add(tagsItem);
    return this;
  }

   /**
   * Tags
   * @return tags
  **/
  @ApiModelProperty(example = "null", value = "Tags")
  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public DeviceType rsp(Boolean rsp) {
    this.rsp = rsp;
    return this;
  }

   /**
   * Require Secure Device Registration (SDR) Protocol.
   * @return rsp
  **/
  @ApiModelProperty(example = "null", value = "Require Secure Device Registration (SDR) Protocol.")
  public Boolean getRsp() {
    return rsp;
  }

  public void setRsp(Boolean rsp) {
    this.rsp = rsp;
  }

  public DeviceType issuerDn(String issuerDn) {
    this.issuerDn = issuerDn;
    return this;
  }

   /**
   * Issuer Distinguished Name (Used in SDR)
   * @return issuerDn
  **/
  @ApiModelProperty(example = "null", value = "Issuer Distinguished Name (Used in SDR)")
  public String getIssuerDn() {
    return issuerDn;
  }

  public void setIssuerDn(String issuerDn) {
    this.issuerDn = issuerDn;
  }

  public DeviceType vid(String vid) {
    this.vid = vid;
    return this;
  }

   /**
   * Vendor ID. (Used in SDR)
   * @return vid
  **/
  @ApiModelProperty(example = "null", value = "Vendor ID. (Used in SDR)")
  public String getVid() {
    return vid;
  }

  public void setVid(String vid) {
    this.vid = vid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceType deviceType = (DeviceType) o;
    return Objects.equals(this.id, deviceType.id) &&
        Objects.equals(this.uniqueName, deviceType.uniqueName) &&
        Objects.equals(this.latestVersion, deviceType.latestVersion) &&
        Objects.equals(this.lastUpdated, deviceType.lastUpdated) &&
        Objects.equals(this.name, deviceType.name) &&
        Objects.equals(this.description, deviceType.description) &&
        Objects.equals(this.uid, deviceType.uid) &&
        Objects.equals(this.oid, deviceType.oid) &&
        Objects.equals(this.hasCloudConnector, deviceType.hasCloudConnector) &&
        Objects.equals(this.approved, deviceType.approved) &&
        Objects.equals(this.published, deviceType.published) &&
        Objects.equals(this._protected, deviceType._protected) &&
        Objects.equals(this.inStore, deviceType.inStore) &&
        Objects.equals(this.ownedByCurrentUser, deviceType.ownedByCurrentUser) &&
        Objects.equals(this.tags, deviceType.tags) &&
        Objects.equals(this.rsp, deviceType.rsp) &&
        Objects.equals(this.issuerDn, deviceType.issuerDn) &&
        Objects.equals(this.vid, deviceType.vid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, uniqueName, latestVersion, lastUpdated, name, description, uid, oid, hasCloudConnector, approved, published, _protected, inStore, ownedByCurrentUser, tags, rsp, issuerDn, vid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeviceType {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    uniqueName: ").append(toIndentedString(uniqueName)).append("\n");
    sb.append("    latestVersion: ").append(toIndentedString(latestVersion)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    oid: ").append(toIndentedString(oid)).append("\n");
    sb.append("    hasCloudConnector: ").append(toIndentedString(hasCloudConnector)).append("\n");
    sb.append("    approved: ").append(toIndentedString(approved)).append("\n");
    sb.append("    published: ").append(toIndentedString(published)).append("\n");
    sb.append("    _protected: ").append(toIndentedString(_protected)).append("\n");
    sb.append("    inStore: ").append(toIndentedString(inStore)).append("\n");
    sb.append("    ownedByCurrentUser: ").append(toIndentedString(ownedByCurrentUser)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
    sb.append("    rsp: ").append(toIndentedString(rsp)).append("\n");
    sb.append("    issuerDn: ").append(toIndentedString(issuerDn)).append("\n");
    sb.append("    vid: ").append(toIndentedString(vid)).append("\n");
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


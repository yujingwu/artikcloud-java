/*
 * ARTIK Cloud API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package cloud.artik.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * WebSocket Registration Message
 */
@ApiModel(description = "WebSocket Registration Message")

public class RegisterMessage {
  @SerializedName("cid")
  private String cid = null;

  @SerializedName("authorization")
  private String authorization = null;

  @SerializedName("sdid")
  private String sdid = null;

  @SerializedName("ts")
  private Long ts = null;

  @SerializedName("type")
  private String type = "register";

  public RegisterMessage cid(String cid) {
    this.cid = cid;
    return this;
  }

   /**
   * Confirmation ID.
   * @return cid
  **/
  @ApiModelProperty(example = "null", value = "Confirmation ID.")
  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public RegisterMessage authorization(String authorization) {
    this.authorization = authorization;
    return this;
  }

   /**
   * Authorization header containing access token (Bearer access_token).
   * @return authorization
  **/
  @ApiModelProperty(example = "null", value = "Authorization header containing access token (Bearer <access_token>).")
  public String getAuthorization() {
    return authorization;
  }

  public void setAuthorization(String authorization) {
    this.authorization = authorization;
  }

  public RegisterMessage sdid(String sdid) {
    this.sdid = sdid;
    return this;
  }

   /**
   * Source Device ID.
   * @return sdid
  **/
  @ApiModelProperty(example = "null", value = "Source Device ID.")
  public String getSdid() {
    return sdid;
  }

  public void setSdid(String sdid) {
    this.sdid = sdid;
  }

  public RegisterMessage ts(Long ts) {
    this.ts = ts;
    return this;
  }

   /**
   * Timestamp (past, present or future). Defaults to current time if not provided.
   * @return ts
  **/
  @ApiModelProperty(example = "null", value = "Timestamp (past, present or future). Defaults to current time if not provided.")
  public Long getTs() {
    return ts;
  }

  public void setTs(Long ts) {
    this.ts = ts;
  }

  public RegisterMessage type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Type.
   * @return type
  **/
  @ApiModelProperty(example = "null", value = "Type.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterMessage registerMessage = (RegisterMessage) o;
    return Objects.equals(this.cid, registerMessage.cid) &&
        Objects.equals(this.authorization, registerMessage.authorization) &&
        Objects.equals(this.sdid, registerMessage.sdid) &&
        Objects.equals(this.ts, registerMessage.ts) &&
        Objects.equals(this.type, registerMessage.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cid, authorization, sdid, ts, type);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterMessage {\n");
    
    sb.append("    cid: ").append(toIndentedString(cid)).append("\n");
    sb.append("    authorization: ").append(toIndentedString(authorization)).append("\n");
    sb.append("    sdid: ").append(toIndentedString(sdid)).append("\n");
    sb.append("    ts: ").append(toIndentedString(ts)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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


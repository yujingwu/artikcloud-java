package cloud.artik.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;




/**
 * Action details.
 **/
@ApiModel(description = "Action details.")
public class ActionDetails   {
  
  @SerializedName("parameters")
  private Map<String, Object> parameters = new HashMap<String, Object>();
  
  @SerializedName("name")
  private String name = null;
  

  
  /**
   * Parameters.
   **/
  @ApiModelProperty(value = "Parameters.")
  public Map<String, Object> getParameters() {
    return parameters;
  }
  public void setParameters(Map<String, Object> parameters) {
    this.parameters = parameters;
  }

  
  /**
   * Name.
   **/
  @ApiModelProperty(value = "Name.")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionDetails actionDetails = (ActionDetails) o;
    return Objects.equals(this.parameters, actionDetails.parameters) &&
        Objects.equals(this.name, actionDetails.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parameters, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionDetails {\n");
    
    sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
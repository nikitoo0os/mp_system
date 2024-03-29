package org.openapitools.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Objects;

/**
 * ContentV1BarcodesPostRequest
 */

@JsonTypeName("_content_v1_barcodes_post_request")
public class ContentV1BarcodesPostRequest {

  @JsonProperty("count")
  private Integer count;

  public ContentV1BarcodesPostRequest count(Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Кол-во баркодов которые надо сгенерировать, максимальное доступное количество баркодов для генерации - `5000`
   * @return count
  */
  
  @Schema(name = "count", example = "1", description = "Кол-во баркодов которые надо сгенерировать, максимальное доступное количество баркодов для генерации - `5000`", required = false)
  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentV1BarcodesPostRequest contentV1BarcodesPostRequest = (ContentV1BarcodesPostRequest) o;
    return Objects.equals(this.count, contentV1BarcodesPostRequest.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(count);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentV1BarcodesPostRequest {\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
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


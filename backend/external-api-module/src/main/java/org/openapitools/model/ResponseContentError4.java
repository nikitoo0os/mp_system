package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.ResponseContentError4AdditionalErrors;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ResponseContentError4
 */

@JsonTypeName("responseContentError4")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-11-14T20:34:42.239477400+03:00[Europe/Moscow]")
public class ResponseContentError4 implements ContentV1TagIdDelete200Response1, ContentV1TagIdDelete400Response1, ContentV1TagPost400Response {

  @JsonProperty("data")
  private JsonNullable<Object> data = JsonNullable.undefined();

  @JsonProperty("error")
  private Boolean error;

  @JsonProperty("errorText")
  private String errorText;

  @JsonProperty("additionalErrors")
  private ResponseContentError4AdditionalErrors additionalErrors;

  public ResponseContentError4 data(Object data) {
    this.data = JsonNullable.of(data);
    return this;
  }

  /**
   * Get data
   * @return data
  */
  
  @Schema(name = "data", required = false)
  public JsonNullable<Object> getData() {
    return data;
  }

  public void setData(JsonNullable<Object> data) {
    this.data = data;
  }

  public ResponseContentError4 error(Boolean error) {
    this.error = error;
    return this;
  }

  /**
   * Флаг ошибки
   * @return error
  */
  
  @Schema(name = "error", description = "Флаг ошибки", required = false)
  public Boolean getError() {
    return error;
  }

  public void setError(Boolean error) {
    this.error = error;
  }

  public ResponseContentError4 errorText(String errorText) {
    this.errorText = errorText;
    return this;
  }

  /**
   * Описание ошибки
   * @return errorText
  */
  
  @Schema(name = "errorText", description = "Описание ошибки", required = false)
  public String getErrorText() {
    return errorText;
  }

  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  public ResponseContentError4 additionalErrors(ResponseContentError4AdditionalErrors additionalErrors) {
    this.additionalErrors = additionalErrors;
    return this;
  }

  /**
   * Get additionalErrors
   * @return additionalErrors
  */
  @Valid 
  @Schema(name = "additionalErrors", required = false)
  public ResponseContentError4AdditionalErrors getAdditionalErrors() {
    return additionalErrors;
  }

  public void setAdditionalErrors(ResponseContentError4AdditionalErrors additionalErrors) {
    this.additionalErrors = additionalErrors;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseContentError4 responseContentError4 = (ResponseContentError4) o;
    return Objects.equals(this.data, responseContentError4.data) &&
        Objects.equals(this.error, responseContentError4.error) &&
        Objects.equals(this.errorText, responseContentError4.errorText) &&
        Objects.equals(this.additionalErrors, responseContentError4.additionalErrors);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, error, errorText, additionalErrors);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseContentError4 {\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorText: ").append(toIndentedString(errorText)).append("\n");
    sb.append("    additionalErrors: ").append(toIndentedString(additionalErrors)).append("\n");
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


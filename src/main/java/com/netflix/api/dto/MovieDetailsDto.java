
package com.netflix.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backdrop_path",
    "id",
    "original_language",
    "original_title",
    "overview",
    "poster_path",
    "runtime",
    "title"
})
public class MovieDetailsDto {

  @JsonProperty("backdrop_path")
  private String backdropPath;
  @JsonProperty("id")
  private Integer id;
  @JsonProperty("original_language")
  private String originalLanguage;
  @JsonProperty("original_title")
  private String originalTitle;
  @JsonProperty("overview")
  private String overview;
  @JsonProperty("poster_path")
  private String posterPath;
  @JsonProperty("runtime")
  private Integer runtime;
  @JsonProperty("title")
  private String title;

  @JsonProperty("backdrop_path")
  public String getBackdropPath() {
    return backdropPath;
  }

  @JsonProperty("backdrop_path")
  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonProperty("original_language")
  public String getOriginalLanguage() {
    return originalLanguage;
  }

  @JsonProperty("original_language")
  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  @JsonProperty("original_title")
  public String getOriginalTitle() {
    return originalTitle;
  }

  @JsonProperty("original_title")
  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  @JsonProperty("overview")
  public String getOverview() {
    return overview;
  }

  @JsonProperty("overview")
  public void setOverview(String overview) {
    this.overview = overview;
  }

  @JsonProperty("poster_path")
  public String getPosterPath() {
    return posterPath;
  }

  @JsonProperty("poster_path")
  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  @JsonProperty("runtime")
  public Integer getRuntime() {
    return runtime;
  }

  @JsonProperty("runtime")
  public void setRuntime(Integer runtime) {
    this.runtime = runtime;
  }

  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  @JsonProperty("title")
  public void setTitle(String title) {
    this.title = title;
  }
}

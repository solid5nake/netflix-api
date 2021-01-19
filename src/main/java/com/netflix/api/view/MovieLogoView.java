package com.netflix.api.view;

import com.netflix.api.dto.Hdmovielogo;
import com.netflix.api.dto.Moviethumb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieLogoView {

  private String movieId;
  private List<Hdmovielogo> movieLogo = null;
  private List<Moviethumb> thumbnail = null;

  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  public String getMovieId() {
    return movieId;
  }

  public void setMovieId(String movieId) {
    this.movieId = movieId;
  }

  public List<Hdmovielogo> getMovieLogo() {
    return movieLogo;
  }

  public void setMovieLogo(List<Hdmovielogo> movieLogo) {
    this.movieLogo = movieLogo;
  }

  public List<Moviethumb> getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(List<Moviethumb> thumbnail) {
    this.thumbnail = thumbnail;
  }

}

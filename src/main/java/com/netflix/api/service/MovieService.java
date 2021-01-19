package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.client.MovieLogoClient;
import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.dto.MovieLogoDto;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  private MovieClient client;

  @Autowired
  private MovieLogoClient logoClient;

  @Value("${tmdb.api_key}")
  private String tmdbApiKey;

  @Value("${fanart.api_key}")
  private String fanartApiKey;

  public MovieView getBannerMovie(String movieId) {

    MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey);
    MovieLogoDto logo = logoClient.getMovieLogos(movieId, fanartApiKey);

    MovieView view = new MovieView();

    view.setBackdropPath(movie.getBackdropPath());
    view.setPosterPath(movie.getPosterPath());
    view.setId(movie.getId());
    view.setOverview(movie.getOverview());
    view.setTitle(movie.getTitle());
    view.setRuntime(movie.getRuntime());
    view.setGenres(movie.getGenres());
//  view.setYoutubeKey(movie.getYoutubeKey());
    view.setHdmovielogo(logo.getHdmovielogo());
    view.setMoviethumb(logo.getMoviethumb());

    return view;
  }
}

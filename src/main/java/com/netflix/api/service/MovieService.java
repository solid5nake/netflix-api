package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.dto.MovieDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  private MovieClient client;

  public MovieDetailsDto getMovie(String movieId) {
    MovieDetailsDto movie = client.getMovieDetails(movieId,"f0762b04aa2c57fcee36e57e453488ed");
    return movie;
  }
}

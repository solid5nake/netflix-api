package com.netflix.api.controller;

import com.netflix.api.service.MovieService;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

  @Autowired
  private MovieService service;

  @CrossOrigin
  @GetMapping("/movies/{movieId}")
  public MovieView getMovie(@PathVariable String movieId) {
    return service.getBannerMovie(movieId);
  }
}

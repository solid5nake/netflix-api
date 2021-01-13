package com.netflix.api.controller;

import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MovieController {

  @Autowired
  private MovieService service;

  @GetMapping("/movie/{movieId}")
  public MovieDetailsDto getMovie(@PathVariable String movieId) {
    return service.getMovie(movieId);
  }
}

package com.netflix.api.client;

import com.netflix.api.dto.MovieDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://api.themoviedb.org/3/", name="TMDB-API")
public interface MovieClient {

//  @GetMapping("/movie/{movieId}")
//  public MovieDetailsDto getMovieDetails(@PathVariable String movieId, @RequestParam(value = "api_key") String apiKey);
//}
  @GetMapping("/movie/{movieId}")
  public MovieDetailsDto getMovieDetails(@PathVariable String movieId, @RequestParam(value = "api_key") String apiKey,@RequestParam(value = "language") String language, @RequestParam( value = "append_to_response") String videos);
}
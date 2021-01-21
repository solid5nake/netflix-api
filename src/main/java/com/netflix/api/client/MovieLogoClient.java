package com.netflix.api.client;

import com.netflix.api.dto.MovieLogoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://webservice.fanart.tv/v3/", name="FANARTTV-API")
public interface MovieLogoClient {

  @GetMapping("/movies/{id}")
  public MovieLogoDto getMovieLogos(@PathVariable String id, @RequestParam(value = "api_key") String apiKey);
}

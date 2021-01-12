package com.netflix.api.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://api.themoviedb.org/3/movie/76341?api_key=f0762b04aa2c57fcee36e57e453488ed", name="TMDB-API")
public interface MovieClient {

}

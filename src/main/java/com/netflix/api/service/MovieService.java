package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieClient client;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;
//  System.out.println(tmdbApiKey);


    //  public MovieDetailsDto getMovie(String movieId) {
//    MovieDetailsDto movie = client.getMovieDetails(movieId,"f0762b04aa2c57fcee36e57e453488ed");
//    return movie;
//  }
    public MovieView getBannerMovie(String movieId) {

        MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey);
        MovieView view = new MovieView();

        view.setBackdropPath(movie.getBackdropPath());
        view.setPosterPath(movie.getPosterPath());
        view.setId(movie.getId());
        view.setOverview(movie.getOverview());
        view.setTitle(movie.getTitle());
        view.setRuntime(movie.getRuntime());
//        view.setYoutubeKey(movie.getYoutubeKey());

        return view;
    }
}

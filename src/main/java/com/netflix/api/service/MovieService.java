package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.client.MovieLogoClient;
import com.netflix.api.dto.Crew;
import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.dto.MovieLogoDto;
import com.netflix.api.dto.Result;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private String language = "en-US";
//    combinatie van videos en credits voor de append to usage call
    private String videosAndCredits = "videos,credits";
//    private String credits = "credits";

    public MovieView getBannerMovie(String movieId) {

//    MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey);
        MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey, language, videosAndCredits);
        MovieLogoDto logo = logoClient.getMovieLogos(movieId, fanartApiKey);
        System.out.println(movie);

        MovieView view = new MovieView();

//    System.out.println(youtubeKeyResult);
        view.setBackdropPath(movie.getBackdropPath());
        view.setPosterPath(movie.getPosterPath());
        view.setId(movie.getId());
        view.setOverview(movie.getOverview());
        view.setTitle(movie.getTitle());
        view.setRuntime(movie.getRuntime());
        view.setGenres(movie.getGenres());
        view.setHdmovielogo(logo.getHdmovielogo());

        view.setMoviethumb(logo.getMoviethumb());
//       v will set videos with results with lists of trailer info
//    view.setVideos(movie.getVideos());
//       v will set result with list of trailer info
//        view.setResult(movie.getVideos().getResults());
        List<Result> listForYoutubeKey = movie.getVideos().getResults();
        view.setYoutubeKey(listForYoutubeKey.get(0));

//        view.setCredits(movie.getCredits());
        view.setDirector(movie.getCredits());
//        List<Crew> listOfCrewForDirector = movie.getCredits().getCrew();
//        if(listOfCrewForDirector)
//        System.out.println(listOfCrewForDirector);
//        System.out.println("list director =  " + listOfCrewForDirector.stream().filter(t -> t.getJob().equals("Director")).findFirst().get());
//            view.setDirector(listOfCrewForDirector.stream().filter(t -> t.getJob().equals("Director")).findFirst().get());
        return view;
    }
}
package com.netflix.api.controller;

import com.netflix.api.genresdto.GenreID;
import com.netflix.api.service.GenreService;
import com.netflix.api.service.MovieService;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;
    @Autowired
    private GenreService genreService;

    @CrossOrigin
    @GetMapping("/movies/{movieId}")
    public MovieView getMovie(@PathVariable String movieId) {
        return service.getBannerMovie(movieId);
    }

    @GetMapping("/movies/genres")
    public GenreID getGenreMovies(@RequestParam(value = "with_genres", required = false) String genre,
                                  @RequestParam(value = "language", required = false) String language,
                                  @RequestParam(value = "with_cast", required = false) String cast,
                                  @RequestParam(value = "with_company", required = false) String company,
                                  @RequestParam(value = "with_decade", required = false) String decade
    ) {

//        return genreService.getGenreMovies(genre, language, cast, company, decade);
//        return genreService.getGenreMovies(genre, language);
        if (genre != null)
            return genreService.getMoviesByGenre(genre);
        else if (cast != null)
           return  genreService.getMoviesByCast(cast);
        else if (company != null)
         return  genreService.getMoviesByCompany(company);
//       else if (decade != null){
//          return  genreService.getMoviesByDecade(decade);
//        }
       else
//        System.out.println("genre= " + genre);
//        System.out.println("language= " + language);
//        System.out.println("cast= " + cast);
        System.out.println("company= " + company);
//        System.out.println("decade= " + decade);
        return new GenreID();
    }
}

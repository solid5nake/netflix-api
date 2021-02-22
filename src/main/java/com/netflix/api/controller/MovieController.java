package com.netflix.api.controller;

import com.netflix.api.enums.Cast;
import com.netflix.api.enums.Decade;
import com.netflix.api.enums.Genre;
import com.netflix.api.enums.Company;
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

    @CrossOrigin
    @GetMapping("/movies/genres")
    public Object getGenreMovies(@RequestParam(value = "with_genres", required = false) Genre genre,
                                 @RequestParam(value = "language", required = false) String language,
                                 @RequestParam(value = "with_cast", required = false) Cast cast,
                                 @RequestParam(value = "with_company", required = false) Company company,
                                 @RequestParam(value = "with_decade", required = false) Decade decade
    ) {
//        v returns 40 movie ids or 40 movie views, only switch on the appropriate one
//        if (genre != null)
//            return genreService.getMoviesByGenre(genre);
        if (genre != null)
            return genreService.getMovieViewsByGenre(genre);
        else if (cast != null)
            return genreService.getMoviesByCast(cast);
        else if (company != null)
            return genreService.getMoviesByCompany(company);
        else if (decade != null) {
            return genreService.getMoviesByDecade(decade);
        } else
            return new GenreID();
    }
}

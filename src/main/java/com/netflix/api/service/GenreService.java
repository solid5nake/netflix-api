package com.netflix.api.service;

import com.netflix.api.enums.Cast;
import com.netflix.api.enums.Company;
import com.netflix.api.enums.Decade;
import com.netflix.api.enums.Genre;
import com.netflix.api.client.MovieClient;
import com.netflix.api.genresdto.GenreID;
import com.netflix.api.genresdto.Result;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static com.netflix.api.enums.Cast.*;
import static com.netflix.api.enums.Company.*;
import static com.netflix.api.enums.Decade.*;
import static com.netflix.api.enums.Genre.*;

@Service
public class GenreService {

    @Autowired
    private MovieClient client;
    @Autowired
    private MovieService service;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

    @Value("${fanart.api_key}")
    private String fanartApiKey;

    private String language = "en-US";

//    private List<Result> get40MoviesByGenre(String genreNumberTMDB) {
//        GenreID first20Movies = client.getMoviesByGenre(tmdbApiKey, 1, genreNumberTMDB, language);
//        GenreID second20Movies = client.getMoviesByGenre(tmdbApiKey, 2, genreNumberTMDB, language);
//        List<Result> total40movies = new ArrayList<>();
//        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
//        return total40movies;
    }

    //public static Element valueOfLabel(String ID) {
//    for (Element e : values()) {
//        if (e.ID.equals(ID)) {
//            return e;
//        }
//    }

    public List<MovieView> get40MovieViewsByGenres(Genre genre) {
        return switch (genre) {
            case COMEDY -> get40MovieViewsByGenre(COMEDY.getId());
            case FAMILY -> get40MovieViewsByGenre(FAMILY.getId());
            case ACTION -> get40MovieViewsByGenre(ACTION.getId());
            case THRILLER -> get40MovieViewsByGenre(THRILLER.getId());
            case FANTASY -> get40MovieViewsByGenre(FANTASY.getId());
            case CRIME -> get40MovieViewsByGenre(CRIME.getId());
            case ADVENTURE -> get40MovieViewsByGenre(ADVENTURE.getId());
            default -> throw new IllegalStateException("Unexpected value: " + genre);
        };
    }

    private List<MovieView> get40MovieViewsByGenre(String genreNumberTMDB) {
        GenreID firstPage = client.getMoviesByGenre(tmdbApiKey, 1, genreNumberTMDB, language);
        GenreID secondPage = client.getMoviesByGenre(tmdbApiKey, 2, genreNumberTMDB, language);
        List<Result> totalMovies = new ArrayList<>();
        Stream.of(firstPage.getResults(), secondPage.getResults()).forEach(totalMovies::addAll);
        MovieView movieView = new MovieView();

        List<MovieView> listOf40GenreMovieViews = new ArrayList<>();

        for (int i = 0; i < totalMovies.size(); i++) {
            movieView = service.getBannerMovie(totalMovies.get(i).toString());
            listOf40GenreMovieViews.add(movieView);
            if(listOf40GenreMovieViews.size()==40){
                break;
            }
        }
        return listOf40GenreMovieViews;
    }

    public List<Result> getMoviesByCompany(Company company) {
        return switch (company) {
            case LUCAS_FILM -> get40MoviesByCompany(LUCAS_FILM.getId());
            case DISNEY -> get40MoviesByCompany(DISNEY.getId());
            case PIXAR -> get40MoviesByCompany(PIXAR.getId());
            case NEW_LINE_CINEMA -> get40MoviesByCompany(NEW_LINE_CINEMA.getId());
            case WARNER_BROS_ENTERTAINMENT_US -> get40MoviesByCompany(WARNER_BROS_ENTERTAINMENT_US.getId());
            default -> throw new IllegalStateException("Unexpected value: " + company);
        };
    }

    private List<Result> get40MoviesByCompany(String companyNumberTMDB) {
        GenreID first20Movies = client.getMoviesByCompany(tmdbApiKey, 1, companyNumberTMDB, language);
        GenreID second20Movies = client.getMoviesByCompany(tmdbApiKey, 2, companyNumberTMDB, language);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }

    public List<Result> getMoviesByCast(Cast cast) {
        return switch (cast) {
            case TOM_CRUISE -> get40MoviesByCast(TOM_CRUISE.getId());
            case ROBERT_DE_NIRO -> get40MoviesByCast(ROBERT_DE_NIRO.getId());
            case AL_PACINO -> get40MoviesByCast(AL_PACINO.getId());

            default -> throw new IllegalStateException("Unexpected value: " + cast);
        };
    }

    private List<Result> get40MoviesByCast(String castNumberTMDB) {
        GenreID first20Movies = client.getMoviesByCast(tmdbApiKey, 1, castNumberTMDB, language);
        GenreID second20Movies = client.getMoviesByCast(tmdbApiKey, 2, castNumberTMDB, language);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }

    public List<Result> getMoviesByDecade(Decade decade) {
        return switch (decade) {
            case EIGHTIES -> get40MoviesByDecade(EIGHTIES.getEarliestDate(), EIGHTIES.getLatestDate());
            case NINETIES -> get40MoviesByDecade(NINETIES.getEarliestDate(), NINETIES.getLatestDate());
            case NOUGHTIES -> get40MoviesByDecade(NOUGHTIES.getEarliestDate(), NOUGHTIES.getLatestDate());

            default -> throw new IllegalStateException("Unexpected value: " + decade);
        };
    }

    private List<Result> get40MoviesByDecade(String earliestDate, String latestDate) {
        GenreID first20Movies = client.getMoviesByDecade(tmdbApiKey, 1, language, earliestDate, latestDate);
        GenreID second20Movies = client.getMoviesByDecade(tmdbApiKey, 2, language, earliestDate, latestDate);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }
}

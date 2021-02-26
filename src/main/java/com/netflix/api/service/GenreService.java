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
import java.util.Arrays;
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

    //    @Value("${fanart.api_key}")
//    private String fanartApiKey;
    @Value("${languageTMDB}")
    private String language;

    public List<MovieView> getMovieViewsByGenre(Genre genre) {
        Genre[] genreArray = new Genre[]{COMEDY, FAMILY, ACTION, THRILLER, FANTASY, CRIME, ADVENTURE};
        List<Genre> genreList = new ArrayList<>(Arrays.asList(genreArray));

        if (genreList.contains(genre)) {
            return getMovieViewsByGenre(genre.getId(), 40);
        }

        throw new IllegalStateException("Unexpected value: " + genre);
    }

    private List<MovieView> getMovieViewsByGenre(String genreNumberTMDB, Integer length) {
        List<MovieView> movieViews = new ArrayList<>();
        List<Result> movies = getMoviesByGenre(genreNumberTMDB, length);
        movies.forEach((movie) -> {
            MovieView movieView = service.getBannerMovie(movie.toString());
            movieViews.add(movieView);
        });
        return movieViews;
    }

    private List<Result> getMoviesByGenre(String genreNumberTMDB, Integer length) {
        List<Result> movies = new ArrayList<>();
        Integer page = 1;
        Integer oldSize = -1;
        while ((movies.size() < length) && (movies.size() != oldSize)) {
            oldSize = movies.size();
            GenreID moviesPage = client.getMoviesByGenre(tmdbApiKey, page, genreNumberTMDB, language);
            movies.addAll(moviesPage.getResults());
            page++;
        }
        return movies.subList(0, length);
    }

    private List<MovieView> loopListOfIDAndGetMovieViews(GenreID firstPage, GenreID secondPage) {
        List<Result> totalMovies = new ArrayList<>();
        Stream.of(firstPage.getResults(), secondPage.getResults()).forEach(totalMovies::addAll);
        MovieView movieView = new MovieView();
        List<MovieView> listOf40GenreMovieViews = new ArrayList<>();
        for (Result totalMovie : totalMovies) {
            movieView = service.getBannerMovie(totalMovie.toString());
            listOf40GenreMovieViews.add(movieView);
            if (listOf40GenreMovieViews.size() == 40) {
                break;
            }
        }
        return listOf40GenreMovieViews;
    }

    public List<MovieView> getMovieViewsByCompany(Company company) {
        return switch (company) {
            case LUCAS_FILM -> get40MoviesByCompany(LUCAS_FILM.getId());
            case DISNEY -> get40MoviesByCompany(DISNEY.getId());
            case PIXAR -> get40MoviesByCompany(PIXAR.getId());
            case NEW_LINE_CINEMA -> get40MoviesByCompany(NEW_LINE_CINEMA.getId());
            case WARNER_BROS_ENTERTAINMENT_US -> get40MoviesByCompany(WARNER_BROS_ENTERTAINMENT_US.getId());
            default -> throw new IllegalStateException("Unexpected value: " + company);
        };
    }

    private List<MovieView> get40MoviesByCompany(String companyNumberTMDB) {
        GenreID firstPage = client.getMoviesByCompany(tmdbApiKey, 1, companyNumberTMDB, language);
        GenreID secondPage = client.getMoviesByCompany(tmdbApiKey, 2, companyNumberTMDB, language);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }

    public List<MovieView> getMovieViewsByCast(Cast cast) {
        return switch (cast) {
            case TOM_CRUISE -> get40MoviesByCast(TOM_CRUISE.getId());
            case ROBERT_DE_NIRO -> get40MoviesByCast(ROBERT_DE_NIRO.getId());
            case AL_PACINO -> get40MoviesByCast(AL_PACINO.getId());
            default -> throw new IllegalStateException("Unexpected value: " + cast);
        };
    }

    public List<MovieView> get40MoviesByCast(String tmdbCastId) {
        GenreID firstPage = client.getMoviesByCast(tmdbApiKey, 1, tmdbCastId, language);
        GenreID secondPage = client.getMoviesByCast(tmdbApiKey, 2, tmdbCastId, language);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }

    public List<MovieView> getMovieViewsByDecade(Decade decade) {
        return switch (decade) {
            case EIGHTIES -> get40MoviesByDecade(EIGHTIES.getEarliestDate(), EIGHTIES.getLatestDate());
            case NINETIES -> get40MoviesByDecade(NINETIES.getEarliestDate(), NINETIES.getLatestDate());
            case NOUGHTIES -> get40MoviesByDecade(NOUGHTIES.getEarliestDate(), NOUGHTIES.getLatestDate());
            default -> throw new IllegalStateException("Unexpected value: " + decade);
        };
    }

    private List<MovieView> get40MoviesByDecade(String earliestDate, String latestDate) {
        GenreID firstPage = client.getMoviesByDecade(tmdbApiKey, 1, language, earliestDate, latestDate);
        GenreID secondPage = client.getMoviesByDecade(tmdbApiKey, 2, language, earliestDate, latestDate);
        return loopListOfIDAndGetMovieViews(firstPage, secondPage);
    }
}


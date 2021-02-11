package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.genresdto.Result;
import com.netflix.api.genresdto.GenreID;
import com.netflix.api.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class GenreService {

    @Autowired
    private MovieClient genreClient;
    @Autowired
    private MovieService service;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

    @Value("${fanart.api_key}")
    private String fanartApiKey;

    private String language = "en-US";

    private Integer page = 2;
    private List<MovieView> listOf40GenreMovieViews = new ArrayList<>();
    ;

    enum Element {
        H("Hydrogen"),
        HE("Helium"),
        NE("Neon");
        public final String ID;

        private Element(String ID) {
            this.ID = ID;
        }
    }

    //public static Element valueOfLabel(String ID) {
//    for (Element e : values()) {
//        if (e.ID.equals(ID)) {
//            return e;
//        }
//    }
//    return null;
//}
    public List<Result> getMoviesByGenre(String genre) {
        return switch (genre.toLowerCase()) {
            case "comedy" -> get40MoviesByGenre("35");
            case "action" -> get40MoviesByGenre("28");
            case "thriller" -> get40MoviesByGenre("53");
            case "family" -> get40MoviesByGenre("10751");
            case "fantasy" -> get40MoviesByGenre("14");
            case "crime" -> get40MoviesByGenre("80");
            case "adventure" -> get40MoviesByGenre("12");
            default -> throw new IllegalStateException("Unexpected value: " + genre);
        };
    }

    private List<Result> get40MoviesByGenre(String genreNumberTMDB) {
        GenreID first20Movies = genreClient.getMoviesByGenre(tmdbApiKey, 1, genreNumberTMDB, language);
        GenreID second20Movies = genreClient.getMoviesByGenre(tmdbApiKey, 2, genreNumberTMDB, language);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }


    public List<MovieView> get40MovieViewsByGenres(String genre) {
        return switch (genre.toLowerCase()) {
            case "comedy" -> get40MovieViewsByGenre("35");
            case "family" -> get40MovieViewsByGenre("10751");
            case "action" -> get40MovieViewsByGenre("28");
            case "thriller" -> get40MovieViewsByGenre("53");
            case "fantasy" -> get40MovieViewsByGenre("14");
            case "crime" -> get40MovieViewsByGenre("80");
            case "adventure" -> get40MovieViewsByGenre("12");
            default -> throw new IllegalStateException("Unexpected value: " + genre);
        };
    }

    private List<MovieView> get40MovieViewsByGenre(String genreNumberTMDB) {
        GenreID first20Movies = genreClient.getMoviesByGenre(tmdbApiKey, 1, genreNumberTMDB, language);
        GenreID second20Movies = genreClient.getMoviesByGenre(tmdbApiKey, 2, genreNumberTMDB, language);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        MovieView movieView = new MovieView();

        for (int i = 0; i < total40movies.size(); i++) {
//            try {
//                movieView = service.getBannerMovie(total40movies.get(i).toString());
//            } catch (Exception e) {
//                i++;
//                movieView = service.getBannerMovie(total40movies.get(i).toString());
//            }
            movieView = service.getBannerMovie(total40movies.get(i).toString());
            listOf40GenreMovieViews.add(movieView);
            if(listOf40GenreMovieViews.size()==40){
                break;
            }
        }
        return listOf40GenreMovieViews;
    }


    public List<Result> getMoviesByCompany(String company) {
        return switch (company.toLowerCase()) {
            case "lucasfilm" -> get40MoviesByCompany("1");
            case "disney" -> get40MoviesByCompany("2");
            case "pixar" -> get40MoviesByCompany("3");
            case "newlinecinema" -> get40MoviesByCompany("12");
            default -> throw new IllegalStateException("Unexpected value: " + company);
        };
    }

    private List<Result> get40MoviesByCompany(String companyNumberTMDB) {
        GenreID first20Movies = genreClient.getMoviesByCompany(tmdbApiKey, 1, companyNumberTMDB, language);
        GenreID second20Movies = genreClient.getMoviesByCompany(tmdbApiKey, 2, companyNumberTMDB, language);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }

    public List<Result> getMoviesByCast(String cast) {
        return switch (cast.toLowerCase()) {
            case "tomcruise" -> get40MoviesByCast("500");
            case "robertdeniro" -> get40MoviesByCast("380");
            case "alpacino" -> get40MoviesByCast("1158");

            default -> throw new IllegalStateException("Unexpected value: " + cast);
        };
    }

    private List<Result> get40MoviesByCast(String castNumberTMDB) {
        GenreID first20Movies = genreClient.getMoviesByCast(tmdbApiKey, 1, castNumberTMDB, language);
        GenreID second20Movies = genreClient.getMoviesByCast(tmdbApiKey, 2, castNumberTMDB, language);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }

    public List<Result> getMoviesByDecade(String decade) {
        return switch (decade.toLowerCase()) {
            case "80" -> get40MoviesByDecade("1980-01-01", "1989-12-31");
            case "90" -> get40MoviesByDecade("1990-01-01", "1999-12-31");
            case "00" -> get40MoviesByDecade("2000-01-01", "2009-12-31");

            default -> throw new IllegalStateException("Unexpected value: " + decade);
        };
    }

    private List<Result> get40MoviesByDecade(String earliestDate, String latestDate) {
        GenreID first20Movies = genreClient.getMoviesByDecade(tmdbApiKey, 1, language, earliestDate, latestDate);
        GenreID second20Movies = genreClient.getMoviesByDecade(tmdbApiKey, 2, language, earliestDate, latestDate);
        List<Result> total40movies = new ArrayList<>();
        Stream.of(first20Movies.getResults(), second20Movies.getResults()).forEach(total40movies::addAll);
        return total40movies;
    }
}

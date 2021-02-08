package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.genresdto.Result;
import com.netflix.api.genresdto.GenreID;
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

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

    @Value("${fanart.api_key}")
    private String fanartApiKey;

    private String language = "en-US";

    private Integer page = 2;
    enum Element{
    H("Hydrogen"),
    HE("Helium"),
    NE("Neon");

        public final String ID;

        private Element(String ID) {
            this.ID = ID;
        }

}

//    public String getGenreMovies(String genre, String cast, String company, String decade) {
//        System.out.print(genre + cast + company + decade);
//        return genre;
//    }
//    public GenreID getGenreMovies(String genre, String language, String  cast, String company, String decade) {
////        MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey, language, videosAndCredits);
//        GenreID genreId = genreClient.getGenreIDs(tmdbApiKey, genre,);
//        System.out.print(genreId);
//        return genreId;
//    }
//    public GenreID getGenreMovies(String cast) {
////        MovieDetailsDto movie = client.getMovieDetails(movieId, tmdbApiKey, language, videosAndCredits);
//        GenreID genreId = genreClient.getIDForCast(tmdbApiKey, cast);
//        System.out.print(genreId);
//        return genreId;
//    }
//public static Element valueOfLabel(String ID) {
//    for (Element e : values()) {
//        if (e.ID.equals(ID)) {
//            return e;
//        }
//    }
//    return null;
//}
    public List<Result> getMoviesByGenre(String genre) {

//        switch (genre.toLowerCase(Locale.ROOT)) {
       return switch (genre) {
//            case  "comedy"-> genreClient.getMoviesByGenre(tmdbApiKey, page, "35", language);
//            case "action" ->  genreClient.getMoviesByGenre(tmdbApiKey, page, "28", language);
//            case "thriller" ->  genreClient.getMoviesByGenre(tmdbApiKey, page, "53", language);
//            case "family" ->  genreClient.getMoviesByGenre(tmdbApiKey, page, "10751", language);
//            case "fantasy" ->  genreClient.getMoviesByGenre(tmdbApiKey, page, "14", language);
           case "fantasy" ->  get40MoviesByGenre("14");
//            case "crime" ->  genreClient.getMoviesByGenre(tmdbApiKey, page, "80", language);
//            case "adventure" -> genreClient.getMoviesByGenre(tmdbApiKey, page, "12", language);
           default -> throw new IllegalStateException("Unexpected value: " + genre);
       };
//        return genreClient.getMoviesByGenre(tmdbApiKey, page, genre, language);
    }
private List<Result> get40MoviesByGenre(String genreNumberTMDB){
    GenreID first20Movies = genreClient.getMoviesByGenre(tmdbApiKey, 1, genreNumberTMDB, language);
    List<Result> first20Results = first20Movies.getResults();
    GenreID second20Movies = genreClient.getMoviesByGenre(tmdbApiKey, 2, genreNumberTMDB, language);
    List<Result> second20Results = second20Movies.getResults();
    List<Result> total40movies = new ArrayList<>();
    Stream.of(first20Results, second20Results).forEach(total40movies::addAll);

    return total40movies;
}
    public GenreID getMoviesByCompany(String company) {
        return genreClient.getMoviesByCompany(tmdbApiKey, page, company, language);
    }

    public GenreID getMoviesByCast(String cast) {
        return genreClient.getMoviesByCast(tmdbApiKey, page, cast, language);
    }

//    public GenreID getMoviesByDecade(String decade) {
//        return genreClient.getMoviesByCast(tmdbApiKey, cast, language);
//    }
}

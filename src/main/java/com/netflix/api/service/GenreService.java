package com.netflix.api.service;

import com.netflix.api.client.MovieClient;
import com.netflix.api.dto.MovieDetailsDto;
import com.netflix.api.genresdto.GenreID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private MovieClient genreClient;

    @Value("${tmdb.api_key}")
    private String tmdbApiKey;

    @Value("${fanart.api_key}")
    private String fanartApiKey;

    private String language = "en-US";

    private Integer page = 1;
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
    public GenreID getMoviesByGenre(String genre) {

        return genreClient.getMoviesByGenre(tmdbApiKey, page, genre, language);
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

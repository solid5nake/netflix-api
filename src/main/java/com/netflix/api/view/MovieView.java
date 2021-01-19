package com.netflix.api.view;


import com.netflix.api.dto.Genre;
import com.netflix.api.dto.Hdmovielogo;
import com.netflix.api.dto.Moviethumb;

import java.util.List;

public class MovieView {

    private Integer id;
    private String title;
    private String overview;
    private String youtubeKey;
    private Integer runtime;
    private String posterPath;
    private String backdropPath;
    private List<Hdmovielogo> hdmovielogo;
    private List<Moviethumb> moviethumb;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    private List<Genre> genres;

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getYoutubeKey() {
        return youtubeKey;
    }

    public void setYoutubeKey(String youtubeKey) {
        this.youtubeKey = youtubeKey;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBackdropPath(String backdropPath) {
//        MovieDetailsDto movieDetailsDto;
        this.backdropPath = backdropPath;
    }

    public void setId(Integer id) {

        this.id = id;
    }
    public String getBackdropPath() {
        return backdropPath;
    }

    public Integer getId() {
        return id;
    }

    public List<Hdmovielogo> getHdmovielogo() {
        return hdmovielogo;
    }

    public void setHdmovielogo(List<Hdmovielogo> hdmovielogo) {
        this.hdmovielogo = hdmovielogo;
    }

    public List<Moviethumb> getMoviethumb() {
        return moviethumb;
    }

    public void setMoviethumb(List<Moviethumb> moviethumb) {
        this.moviethumb = moviethumb;
    }
}

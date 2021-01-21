package com.netflix.api.view;


import com.netflix.api.dto.*;
//import com.netflix.api.dto.Result;

import java.util.List;

public class MovieView {

    private Integer id;
    private String title;
    private String overview;
    private Integer runtime;
    private String posterPath;
    private String backdropPath;
    private List<Hdmovielogo> hdmovielogo;
    private List<Moviethumb> moviethumb;
    private List<Genre> genres;
    private String youtubeKey;
    private Videos videos;
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getYoutubeKey() {
        return youtubeKey;
    }

    public void setYoutubeKey(Result youtubeKey) {
        this.youtubeKey = youtubeKey.getKey();
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }


    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

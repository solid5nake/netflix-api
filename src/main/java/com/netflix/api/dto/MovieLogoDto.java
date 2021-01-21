
package com.netflix.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieLogoDto {

    private String tmdb_id;
    private List<Hdmovielogo> hdmovielogo = null;
    private List<Moviethumb> moviethumb = null;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getTmdb_id() {
        return tmdb_id;
    }

    public void setTmdb_id(String tmdb_id) {
        this.tmdb_id = tmdb_id;
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
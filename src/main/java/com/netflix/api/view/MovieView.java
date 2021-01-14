package com.netflix.api.view;


public class MovieView {

    private String backdropPath;
    private Integer id;

    private String overview;
    private String youtubeKey;
    private String posterPath;
    private Integer runtime;
    private String title;



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

//

}

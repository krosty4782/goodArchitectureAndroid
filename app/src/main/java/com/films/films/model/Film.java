package com.films.films.model;

/**
 * Created by mauriziofolcini on 02/10/2015.
 */

public class Film {
    private String Title;
    private String Year;
    private String imdbID;
    private String Released;
    private String Genre;
    private String Director;
    private String Plot;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }
}

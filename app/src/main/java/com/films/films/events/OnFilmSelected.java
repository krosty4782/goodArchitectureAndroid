package com.films.films.events;

/**
 * Created by mauriziofolcini on 16/10/2015.
 */
public class OnFilmSelected {

    private String imdbCode;

    public OnFilmSelected(String imdbCode) {
        this.imdbCode = imdbCode;
    }

    public String getImdbCode() {
        return imdbCode;
    }
}

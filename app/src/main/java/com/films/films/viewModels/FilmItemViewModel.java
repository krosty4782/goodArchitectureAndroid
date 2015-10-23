package com.films.films.viewModels;

import com.films.films.model.Film;


/**
 * Created by mauriziofolcini on 02/10/2015.
 */
public class FilmItemViewModel extends ViewModel {

    private Film mFilm;

    public FilmItemViewModel(Film film) {
        this.mFilm = film;
    }

    public void setFilm(Film film) {
        this.mFilm = film;
    }

    public String getFilmTitle() {
        return mFilm.getTitle();
    }

    public String getFilmYear() {
        return mFilm.getYear();
    }

}


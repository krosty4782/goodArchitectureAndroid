package com.films.films.services;

import com.films.films.MainApplication;
import com.films.films.R;
import com.films.films.model.Film;
import com.films.films.model.Films;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by mauriziofolcini on 10/10/2015.
 */
public interface OmdbService {
    String SERVICE_ENDPOINT =  MainApplication.getAppContext().getString(R.string.api_url);

    @GET("/")
    Observable<Films> getFilms(@Query("s") String film);

    @GET("/")
    Observable<Film> getFilmDetail(@Query("i") String film);
}

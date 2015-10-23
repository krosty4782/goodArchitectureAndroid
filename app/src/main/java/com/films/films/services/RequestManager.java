package com.films.films.services;

import com.films.films.model.Film;
import com.films.films.model.Films;

import rx.Observable;

/**
 * Created by mauriziofolcini on 23/10/2015.
 */
public class RequestManager {

    private static OmdbService service = ServiceFactory.createRetrofitService(OmdbService.class, OmdbService.SERVICE_ENDPOINT);

    public static Observable<Film> getFilmDetail(String query) {
        return service.getFilmDetail(query);
    }

    public static Observable<Films> getFilms(String query) {
        return service.getFilms(query);
    }
}

package com.films.films.viewModels;


import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.films.films.services.RequestManager;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FilmDetailViewModel extends BaseViewModel {

    public ObservableField<String> mTitle = new ObservableField<>();
    public ObservableField<String> mYear = new ObservableField<>();
    public ObservableField<String> mReleased = new ObservableField<>();
    public ObservableField<String> mGenre = new ObservableField<>();
    public ObservableField<String> mDirector = new ObservableField<>();
    public ObservableField<String> mPlot = new ObservableField<>();
    public ObservableInt mFilmErrorVisibility = new ObservableInt();
    public ObservableInt mFilmSpinnerVisibility = new ObservableInt();

    public FilmDetailViewModel() {
        mFilmErrorVisibility.set(View.GONE);
    }

    public void performFilmDetailsSearch(String query) {
        mFilmSpinnerVisibility.set(View.VISIBLE);
        RequestManager.getFilmDetail(query)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(film -> {
                    mFilmSpinnerVisibility.set(View.GONE);
                    mFilmErrorVisibility.set(View.GONE);
                    mTitle.set(film.getTitle());
                    mYear.set(film.getYear());
                    mReleased.set(film.getReleased());
                    mGenre.set(film.getGenre());
                    mDirector.set(film.getDirector());
                    mPlot.set(film.getPlot());
                }, throwable -> {
                    mFilmSpinnerVisibility.set(View.GONE);
                    mFilmErrorVisibility.set(View.VISIBLE);
                });
    }
}


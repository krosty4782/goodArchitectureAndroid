package com.films.films.viewModels;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.films.films.R;
import com.films.films.adapters.FilmAdapter;
import com.films.films.fragments.FilmDetailFragment;
import com.films.films.fragments.MainFragment;
import com.films.films.model.Film;
import com.films.films.services.RequestManager;
import com.squareup.otto.Subscribe;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private List<Film> mfilms;
    public ObservableInt mErrorVisibility = new ObservableInt();
    public ObservableField<String> mErrorText =  new ObservableField<>();
    private Context mContext;
    private MainFragment mView;

    public MainViewModel(MainFragment mView) {
        this.mView = mView;
        mContext = mView.getActivity();
    }

    public List<Film> getMfilms() {
        return mfilms;
    }

    public void setMfilms(List<Film> films) {
        this.mfilms = films;
    }

    public void searchClicked(View view) {
        performSearch(mView.getSearchText());
    }

    public void performSearch(String query) {

        RequestManager.getFilms(query)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(films -> films.getSearch())
                .subscribe(films -> {
                    if (films.size() > 0) {
                        mErrorVisibility.set(View.GONE);
                        this.setMfilms(films);
                        mView.setUpFilmsAdapter(new FilmAdapter(mfilms));
                    } else {
                        mView.setUpFilmsAdapter(null);
                        mErrorText.set(mContext.getString(R.string.no_results));
                        mErrorVisibility.set(View.VISIBLE);
                    }
                }, throwable -> {
                    Log.e("ERROR", throwable.toString());
                });
    }

    @Subscribe
    public void onFilmSelected(String imdbCode) {
        Bundle bundle = new Bundle();
        bundle.putString("imdbCode", imdbCode);
        FilmDetailFragment filmDetailFragment = new FilmDetailFragment();
        filmDetailFragment.setArguments(bundle);
        mView.addFragment(filmDetailFragment, true);
    }
}


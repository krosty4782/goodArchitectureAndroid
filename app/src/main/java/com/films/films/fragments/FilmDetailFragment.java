package com.films.films.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.films.films.R;
import com.films.films.databinding.FilmDetailFragmentBinding;
import com.films.films.viewModels.FilmDetailViewModel;


public class FilmDetailFragment extends BaseFragment{
    public static final String TAG = "FilmDetailFragment";
    private FilmDetailViewModel mFilmDetailViewModel;
    private FilmDetailFragmentBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFilmDetailViewModel = new FilmDetailViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.film_detail_fragment,null);
        mBinding = FilmDetailFragmentBinding.bind(mView);
        mFilmDetailViewModel = new FilmDetailViewModel();
        mBinding.setViewModel(mFilmDetailViewModel);
        setUpFragment();
        return mView;
    }

    private void setUpFragment() {
        Bundle args = getArguments();
        String imdbCode = args.getString("imdbCode");
        mFilmDetailViewModel.performFilmDetailsSearch(imdbCode);
    }
}


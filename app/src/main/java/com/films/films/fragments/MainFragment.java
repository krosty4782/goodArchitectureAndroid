package com.films.films.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.films.films.MainApplication;
import com.films.films.R;

import com.films.films.adapters.FilmAdapter;
import com.films.films.databinding.MainFragmentBinding;
import com.films.films.events.OnFilmSelected;
import com.films.films.viewModels.MainViewModel;
import com.squareup.otto.Subscribe;

/**
 * Created by mauriziofolcini on 02/10/2015.
 */
public class MainFragment extends BaseFragment {
    public static final String TAG = "MainFragment";
    private MainViewModel mMainViewModel;
    private MainFragmentBinding mBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.getBus().register(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        mBinding = MainFragmentBinding.bind(view);
        mMainViewModel = new MainViewModel(this);
        mBinding.setViewModel(mMainViewModel);
        mBinding.filmList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainApplication.getBus().unregister(this);
    }

    public String getSearchText() {
        return mBinding.searchEdit.getText().toString();
    }

    public void setUpFilmsAdapter(FilmAdapter adapter) {
        mBinding.filmList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onFilmSelected(OnFilmSelected event) {
        mMainViewModel.onFilmSelected(event.getImdbCode());
    }
}


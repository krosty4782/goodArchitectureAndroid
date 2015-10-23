package com.films.films.adapters;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import com.films.films.MainApplication;
import com.films.films.R;
import com.films.films.databinding.FilmItemBinding;
import com.films.films.events.OnFilmAdapterItemClicked;
import com.films.films.events.OnFilmSelected;
import com.films.films.model.Film;
import com.films.films.viewModels.FilmItemViewModel;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> implements OnFilmAdapterItemClicked{
    private List<Film> films;

    public FilmAdapter(List<Film> films) {
        this.films = films;
    }

    @Override
    public FilmViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        FilmItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.film_item,
                viewGroup,
                false);
        return new FilmViewHolder(binding, this);
    }

    @Override
    public void onBindViewHolder(FilmViewHolder filmViewHolder, int i) {
        filmViewHolder.bindFilm(films.get(i));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    @Override
    public void onFilmAdapterItemClicked(int itemPosition) {
        MainApplication.getBus().post(new OnFilmSelected(films.get(itemPosition).getImdbID()));
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        final FilmItemBinding binding;

        public FilmViewHolder(FilmItemBinding binding, OnFilmAdapterItemClicked listener) {
            super(binding.filmItemContainer);
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(v -> {
                listener.onFilmAdapterItemClicked(getLayoutPosition());
            });
        }

        void bindFilm(Film film) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new FilmItemViewModel(film));
            } else {
                binding.getViewModel().setFilm(film);
            }
        }
    }
}


package com.vitalii.mvpmovie.contract;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import com.vitalii.mvpmovie.model.Movie;
import com.vitalii.mvpmovie.service.MovieListModelDB;

import java.util.List;

public interface MovieListContract {

    interface Model {

        interface OnFinishedListener {
            void onFinished(List<Movie> moviesArrayList);
            void onFailure(Throwable throwable);
        }

        interface RoomDatabase {
            LiveData<List<Movie>> getAllMovies();
            void insertMovie(List<Movie> movieList);
        }

        void getMovieList(OnFinishedListener onFinishedListener, int pageNumber);
    }

    interface View {

        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(List<Movie> movieListArray);
        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {

        void onDestroy();
        void getMoreData(int pageNumber);
        void requestDataFromServer();
        void getAllMovieFromDB(LifecycleOwner lifecycleOwner);
    }
}

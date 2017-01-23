package com.example.shaharraz.mms.base;

import com.example.shaharraz.mms.models.MovieResponse;
import com.example.shaharraz.mms.service.MovieViewInterface;


import java.util.ArrayList;

import rx.Observer;

/**
 * Created by ShaharRaz on 21/01/2017.
 */
public class MoviePresenter extends BasePresenter implements Observer<ArrayList<MovieResponse>> {

    private MovieViewInterface mViewInterface;

    public MoviePresenter(MovieViewInterface viewInterface) {
        mViewInterface = viewInterface;
    }


    @Override
    public void onCompleted() {
        mViewInterface.onCompleted();

    }

    @Override
    public void onError(Throwable e) {
        mViewInterface.onError(e.getMessage());

    }

    @Override
    public void onNext(ArrayList<MovieResponse> movieResponses) {
        mViewInterface.onMovies(movieResponses);
    }

    public void fetchMovies() {
        unSubscribeAll();
        subscribe(mViewInterface.getMovies(), MoviePresenter.this);
    }

}


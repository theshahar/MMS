package com.example.shaharraz.mms.service;

import com.example.shaharraz.mms.models.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by ShaharRaz on 21/01/2017.
 */
public interface MovieViewInterface {


    void onCompleted();

    void onError(String message);

    void onMovies(ArrayList<MovieResponse> movieResponses);

    Observable<ArrayList<MovieResponse>> getMovies();

}

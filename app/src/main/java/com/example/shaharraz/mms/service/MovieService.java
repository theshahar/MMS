package com.example.shaharraz.mms.service;

import com.example.shaharraz.mms.models.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ShaharRaz on 20/01/2017.
 */
public interface MovieService {

    @GET("/api/api.php?director=Quentin%20Tarantino")
    Observable<ArrayList<MovieResponse>> getMovies();


}

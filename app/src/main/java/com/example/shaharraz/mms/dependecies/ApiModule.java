package com.example.shaharraz.mms.dependecies;

import com.example.shaharraz.mms.service.MovieService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by ShaharRaz on 20/01/2017.
 */
@Module
public class ApiModule {

    @Provides
    @CustomScope
    MovieService provideMovieService (Retrofit retrofit){
        return retrofit.create(MovieService.class);
    }



}

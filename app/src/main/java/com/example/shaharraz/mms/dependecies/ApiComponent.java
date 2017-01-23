package com.example.shaharraz.mms.dependecies;

import com.example.shaharraz.mms.fragment.MovieListFragment;

import dagger.Component;

/**
 * Created by ShaharRaz on 20/01/2017.
 */


@CustomScope
@Component(modules = ApiModule.class , dependencies = NetworkComponent.class)
public interface ApiComponent {

    void inject (MovieListFragment fragment);
}

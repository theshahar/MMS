package com.example.shaharraz.mms.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shaharraz.mms.R;
import com.example.shaharraz.mms.adapter.ListAdapter;
import com.example.shaharraz.mms.application.MovieApplication;
import com.example.shaharraz.mms.base.MoviePresenter;
import com.example.shaharraz.mms.models.MovieResponse;
import com.example.shaharraz.mms.service.MovieService;
import com.example.shaharraz.mms.service.MovieViewInterface;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

/**
 * A simple {@link Fragment} subclass.
 */


public class MovieListFragment extends Fragment implements MovieViewInterface {

    public static final String TAG = MovieListFragment.class.getSimpleName();
    private ListAdapter mAdapter;
    private MoviePresenter mPresenter;
    private View mMainContainer;
    private ProgressDialog mDialog;

    @Inject
    MovieService mService;


    public MovieListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_movie_list, container, false);
        mAdapter = new ListAdapter(getContext());

        final RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.movie_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(mAdapter);
        mMainContainer = v.findViewById(R.id.main_container);

        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MovieApplication) getActivity().getApplication())
                .getApiComponent()
                .inject(MovieListFragment.this);

        mPresenter = new MoviePresenter(MovieListFragment.this);
        mPresenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
        mPresenter.fetchMovies();
        mDialog = new ProgressDialog(getContext());
        mDialog.setIndeterminate(true);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setTitle(getResources().getString(R.string.downloading));
        mDialog.setMessage(getResources().getString(R.string.please_wait));
        mDialog.show();
    }

    @Override
    public void onCompleted() {
        mDialog.dismiss();
    }

    @Override
    public void onError(String message) {
        mDialog.dismiss();
        Snackbar.make(mMainContainer, message, Snackbar.LENGTH_LONG)
                .show();
    }

    @Override
    public void onMovies(ArrayList<MovieResponse> movieResponses) {
        mAdapter.addMovies(movieResponses);
    }

    @Override
    public Observable<ArrayList<MovieResponse>> getMovies() {
        return mService.getMovies();
    }
}

package com.example.shaharraz.mms.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaharraz.mms.R;
import com.example.shaharraz.mms.models.MovieResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ShaharRaz on 20/01/2017.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    private ArrayList<MovieResponse> mMoviesArray;
    private Context mContext;

    public ListAdapter(Context context) {
        mContext = context;
        mMoviesArray = new ArrayList<>();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false);
        return new MyHolder(v);

    }

    @Override
    public void onBindViewHolder(ListAdapter.MyHolder holder, int position) {
        holder.bind(mMoviesArray.get(position));


    }

    @Override
    public int getItemCount() {
        return mMoviesArray.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView txtCard;
        private ImageView imgCard;
        private MovieResponse mMovie;


        public MyHolder(View itemView) {
            super(itemView);
            txtCard = (TextView) itemView.findViewById(R.id.txtCard);
            imgCard = (ImageView) itemView.findViewById(R.id.imgCard);


        }

        public void bind(MovieResponse mOneMovie) {
            mMovie = mOneMovie;
            txtCard.setText(mMovie.getShow_title());
            Picasso.with(mContext).load(mMovie.getPoster()).into(imgCard);

        }


    }

    public void addMovies(ArrayList<MovieResponse> movieResponseList) {
        mMoviesArray.addAll(movieResponseList);
        notifyDataSetChanged();
    }
}

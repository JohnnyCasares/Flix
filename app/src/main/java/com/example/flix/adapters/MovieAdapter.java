package com.example.flix.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flix.R;
import com.example.flix.models.Movie;

import java.security.acl.LastOwnerException;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
        //Adapter<MovieAdapter.ViewHolder>

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    //Usually involves inflating a layout from xml and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent,false);
        return new ViewHolder(movieView);



    }


    //Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //GEt movie at the passed position
        Movie movie = movies.get(position);
        //Bind the movie data into the ViewHolder()VH
        holder.bind(movie);

    }


    //RETURN THE TOTAl count of items
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);


        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverView());
            String imageURL;
            //if phone is in landscape
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                //then imageurl = backdrop image
                imageURL = movie.getBackDropPath();
            }else
                imageURL = movie.getPosterPath();

            //else image =poster image

            Glide.with(context).load(imageURL).into(ivPoster);

        }
    }
}

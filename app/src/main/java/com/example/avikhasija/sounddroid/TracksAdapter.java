package com.example.avikhasija.sounddroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avik Hasija on 7/19/2015.
 */
public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder{
        //ViewHolder holds view passed from OnCreateViewHolder
        //Also holds any fields we may need to access often, like title TextView (findviewbyID is resource intensive)
        private final TextView titleTextView;
        private final ImageView thumbImageView;

        ViewHolder (View v){
            super(v);
            //view contains textview
            //FindviewById is expensive operation - this allows only doing it once
            titleTextView = (TextView) v.findViewById(R.id.track_title);
            thumbImageView = (ImageView)v.findViewById(R.id.track_thumbnail);

        }
    }

    private List<Track> mTracks;
    private Context mContext;

    //constructor
    TracksAdapter(Context context, List<Track> tracks){
        mContext = context;
        mTracks = tracks;

    }

    //NEXT 3 : Similar to getView override method in custom listadapter; splits functionality
    //Instead of creating view each time, create viewholder objects and keep them
    //when data is updated, it simply needs to be binded to the view. efficiency added
    @Override
    public int getItemCount() {
        //returns number of items in list
        return mTracks.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        //Data populates view - called often
        Track track = mTracks.get(i);
        viewHolder.titleTextView.setText(track.getTitle());
        Picasso.with(mContext).load(track.getAvatarURL()).into(viewHolder.thumbImageView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //creating view from layout - called few times (to create view)
        //inflates layout into view, passed to view holder

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.track_row, viewGroup, false);

        return new ViewHolder(v);
    }
}

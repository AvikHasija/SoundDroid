package com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Avikshit on 7/19/2015.
 */
public interface SoundCloudService {

    static final String CLIENT_ID = "";

    @GET("/tracks?client_id="+CLIENT_ID)
    public void searchSongs(@Query("q") String query, Callback<List<Track>> cb);
}

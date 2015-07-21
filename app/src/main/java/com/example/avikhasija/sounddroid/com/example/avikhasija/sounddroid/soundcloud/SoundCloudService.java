package com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Avikshit on 7/19/2015.
 */
public interface SoundCloudService {

    static final String CLIENT_ID = "d62d381c60815ce5a7b55fc1863d72e4";

    @GET("/tracks?client_id="+CLIENT_ID)
    public void searchSongs(@Query("q") String query, Callback<List<Track>> cb);

    @GET("/tracks?client_id="+CLIENT_ID)
    public void getRecentSongs(@Query("created_at[from]") String date, Callback<List<Track>> cb);
}

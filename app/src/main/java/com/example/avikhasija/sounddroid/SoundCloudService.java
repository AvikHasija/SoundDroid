package com.example.avikhasija.sounddroid;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Avikshit on 7/19/2015.
 */
public interface SoundCloudService {

    static final String CLIENT_ID = "d62d381c60815ce5a7b55fc1863d72e4";

    @GET("/tracks?client_id="+CLIENT_ID)
    public List<Track> searchSongs(@Query("q")String query);
}

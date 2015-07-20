package com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud;

import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Avik Hasija on 7/19/2015.
 */
public class Track {
    @SerializedName("title")
    private String mTitle;

    @SerializedName("stream_url")
    private String mStreamURL;

    @SerializedName("id")
    private int mID;

    @SerializedName("artwork_url")
    private String artworkURL;

    public String getArtworkURL() {
        return artworkURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getStreamURL() {
        return mStreamURL;
    }

    public int getID() {
        return mID;
    }

    public String getAvatarURL(){
        String avatarURL = artworkURL;
        if(avatarURL != null){
            avatarURL = avatarURL.replace("large", "tiny");
        }
        return avatarURL;
    }
}

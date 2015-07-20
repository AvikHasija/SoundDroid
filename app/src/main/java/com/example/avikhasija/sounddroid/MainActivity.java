package com.example.avikhasija.sounddroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud.SoundCloud;
import com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud.SoundCloudService;
import com.example.avikhasija.sounddroid.com.example.avikhasija.sounddroid.soundcloud.Track;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    private TracksAdapter mAdapter;
    private List<Track> mTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List is an interface; arraylist is class that implements List
        mTracks = new ArrayList<Track>();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.songs_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new TracksAdapter(this, mTracks);
        recyclerView.setAdapter(mAdapter);

        SoundCloudService service = SoundCloud.getService();
        service.searchSongs("dark horse", new Callback<List<Track>>() {
            @Override
            public void success(List<Track> tracks, Response response) {
                mTracks.clear();
                mTracks.addAll(tracks);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

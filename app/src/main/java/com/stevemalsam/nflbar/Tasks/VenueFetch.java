package com.stevemalsam.nflbar.Tasks;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.stevemalsam.nflbar.Models.ScheduleItem;
import com.stevemalsam.nflbar.Models.Venue;
import com.stevemalsam.nflbar.WebServices.NFLBarService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by stevo on 7/9/14.
 */
public class VenueFetch extends AsyncTaskLoader {
    public static final String VENUES_LIST_URL = "https://s3.amazonaws.com/jon-hancock-phunware/nflapi-static.json";

    public VenueFetch(Context context) {
        super(context);
    }


    @Override
    public Object loadInBackground() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss Z").create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setConverter(new GsonConverter(gson))
                .setEndpoint(NFLBarService.URL)
                .build();

        NFLBarService nflBarService = restAdapter.create(NFLBarService.class);

        List<Venue> venues = nflBarService.listVenues();

        return venues;
    }
}

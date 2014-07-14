package com.stevemalsam.nflbar.WebServices;

import com.stevemalsam.nflbar.Models.Venue;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by stevo on 7/9/14.
 */
public interface NFLBarService {
    public static final String URL = "https://s3.amazonaws.com";

    @GET("/jon-hancock-phunware/nflapi-static.json")
    void listVenues(Callback<List<Venue>> cb);

    @GET("/jon-hancock-phunware/nflapi-static.json")
    List<Venue> listVenues();
}

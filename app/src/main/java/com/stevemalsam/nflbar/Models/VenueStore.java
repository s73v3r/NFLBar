package com.stevemalsam.nflbar.Models;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stevemalsam.nflbar.Tasks.VenueFetch;
import com.stevemalsam.nflbar.WebServices.NFLBarService;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by stevo on 7/12/14.
 */
public class VenueStore {
    private List<Venue> mVenues;
    private VenueListListener mVenueListListener;

    private static class Holder {
        static final VenueStore INSTANCE = new VenueStore();
    }

    public interface VenueListListener {
        public void venuesLoaded(List<Venue> venues);
    }

    public static VenueStore getInstance() {
        return Holder.INSTANCE;
    }

    public void getVenues(VenueListListener listener) {
        mVenueListListener = listener;
        if(mVenues == null) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss Z").create();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setConverter(new GsonConverter(gson))
                    .setEndpoint(NFLBarService.URL)
                    .build();

            NFLBarService nflBarService = restAdapter.create(NFLBarService.class);

            nflBarService.listVenues(new Callback<List<Venue>>() {
                @Override
                public void success(List<Venue> venues, Response response) {
                    mVenues = venues;
                    mVenueListListener.venuesLoaded(mVenues);
                }

                @Override
                public void failure(RetrofitError error) {

                }
            });

        } else {
            mVenueListListener.venuesLoaded(this.mVenues);
        }
    }

    public Venue getVenue(int index) {
        return mVenues.get(index);
    }
}

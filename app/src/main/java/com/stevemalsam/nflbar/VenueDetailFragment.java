package com.stevemalsam.nflbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.stevemalsam.nflbar.Models.Venue;
import com.stevemalsam.nflbar.Models.VenueStore;

/**
 * A fragment representing a single Venue detail screen.
 * This fragment is either contained in a {@link VenueListActivity}
 * in two-pane mode (on tablets) or a {@link VenueDetailActivity}
 * on handsets.
 */
public class VenueDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Venue mItem;
    private ImageView mVenueImage;
    private TextView mVenueName;
    private TextView mVenueAddress;
    private TextView mVenueCity;
    private ProgressBar mProgressBar;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VenueDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = VenueStore.getInstance().getVenue(getArguments().getInt(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_venue_detail, container, false);

        mVenueImage = (ImageView)rootView.findViewById(R.id.venueImage);
        mVenueName = (TextView)rootView.findViewById(R.id.venueName);
        mVenueAddress = (TextView)rootView.findViewById(R.id.venueAddress);
        mVenueCity = (TextView)rootView.findViewById(R.id.venueCity);

        mProgressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.VISIBLE);

        updateUI();

        return rootView;
    }

    private void updateUI() {
        if(mItem.getImageUrl() != null && !mItem.getImageUrl().isEmpty()) {
            Picasso.with(getActivity())
                    .load(mItem.getImageUrl())
                    .into(mVenueImage, new Callback() {

                        @Override
                        public void onSuccess() {
                            if(mProgressBar != null) {
                                mProgressBar.setVisibility(View.GONE);
                            }
                        }

                        @Override
                        public void onError() {
                            if(mProgressBar != null) {
                                mProgressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        } else {
            mVenueImage.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.placeholder));
        }

        mVenueName.setText(mItem.getName());
        mVenueAddress.setText(mItem.getAddress());

        StringBuilder sb = new StringBuilder();
        sb.append(mItem.getCity())
                .append(" ")
                .append(mItem.getState())
                .append(", ")
                .append(mItem.getZip());
        mVenueCity.setText(sb.toString());


    }
}

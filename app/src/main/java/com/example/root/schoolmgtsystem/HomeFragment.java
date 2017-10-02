package com.example.root.schoolmgtsystem;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<HomeModel> mHomeData;
    private HomeAdapter homeAdapter;
    RecyclerView.LayoutManager layoutManager;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //initialize the recycler view
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        //initialize the ArrayList that will contain the data
        mHomeData = new ArrayList<>();
        //initialize the adapter and set it to recycler view
        homeAdapter = new HomeAdapter(getActivity(), mHomeData);
        //Set the layout
        layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(homeAdapter);
        //Fetch the data
        initializeData();

        return rootView;
    }
    private void initializeData() {
        //Retrieve the resources from the XML file
        String[] homeTextlist = getResources().getStringArray(R.array.teachers_homepage);
        TypedArray homeImageResources = getResources().obtainTypedArray(R.array.teachers_homepage_images);
        //clear the existing data to avoid duplication
        mHomeData.clear();

        //clear arraylist of home object with text and image details of each box
        for (int i = 0; i < homeTextlist.length; i++) {
            mHomeData.add(new HomeModel(homeTextlist[i], homeImageResources.getResourceId(i, 0)));
        }

        //Clean up the data in the typed array once is created
        homeImageResources.recycle();

        //notify the adapter of the change
        homeAdapter.notifyDataSetChanged();

    }

}

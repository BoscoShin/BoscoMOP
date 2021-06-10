package com.example.mp2021am_20170839;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class list extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup listView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        getActivity().setTitle("목록");


        return listView;

    }
}
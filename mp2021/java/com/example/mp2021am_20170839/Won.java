package com.example.mp2021am_20170839;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Won extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup wonView = (ViewGroup) inflater.inflate(R.layout.fragment_won, container, false);

        getActivity().setTitle("개인정보");


        return wonView;

    }

}

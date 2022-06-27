package com.techroof.openstationuser.HostFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techroof.openstationuser.R;


public class ListingsHostFragment extends Fragment {


    public ListingsHostFragment() {
        // Required empty public constructor
    }

    public static ListingsHostFragment newInstance(String param1, String param2) {
        ListingsHostFragment fragment = new ListingsHostFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listings_host, container, false);
    }
}
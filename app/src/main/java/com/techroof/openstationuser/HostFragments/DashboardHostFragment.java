package com.techroof.openstationuser.HostFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techroof.openstationuser.R;


public class DashboardHostFragment extends Fragment {

    public DashboardHostFragment() {
        // Required empty public constructor
    }

    public static DashboardHostFragment newInstance(String param1, String param2) {
        DashboardHostFragment fragment = new DashboardHostFragment();
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
        return inflater.inflate(R.layout.fragment_dashboard_host, container, false);
    }
}
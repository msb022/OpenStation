package com.techroof.openstationuser.HostFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techroof.openstationuser.R;

public class InboxHostFragment extends Fragment {


    public InboxHostFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static InboxHostFragment newInstance(String param1, String param2) {
        InboxHostFragment fragment = new InboxHostFragment();
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
        return inflater.inflate(R.layout.fragment_inbox_host, container, false);
    }
}
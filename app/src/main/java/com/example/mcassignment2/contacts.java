package com.example.mcassignment2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class contacts extends Fragment {
    private static final String TAG = "SpeedDial";

    private PageViewModel pageViewModel;
    private View v;
    private RecyclerView recyclerView;

    public static speeddial newInstance() {
        return new speeddial();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
        Intent i=new Intent(getActivity(),frag.class);
        getActivity().startActivity(i);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contacts, container, false);
        final TextView textView = root.findViewById(R.id.section_label);


        recyclerView=root.findViewById(R.id.r1);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager=linearLayoutManager;
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }

        });

        return root;
    }



}
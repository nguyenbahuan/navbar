package com.example.navbar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class HomeFragment extends Fragment {

        ImageButton imgBtnShow;
        TextView textShow;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        imgBtnShow.findViewById(R.id.imgBtnShow);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imgBtnShow = view.findViewById(R.id.imgBtnShow);


        imgBtnShow.setOnClickListener(v -> toMenuFragment());
        return view;
    }

    private void toMenuFragment() {
        Fragment fragmentMenu = new MenuFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_layout,fragmentMenu,null);
        fragmentTransaction.addToBackStack(null).commit();
    }
}
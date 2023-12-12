package com.example.navbar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddFoodFragment extends Fragment {
    Context context ;
    Activity activity;
    MyDataHelper db;
    EditText nameFood;
    EditText priceFood;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_food, container, false);
        nameFood =  view.findViewById(R.id.foodName);
        priceFood =  view.findViewById(R.id.foodPrice);
        Button add = view.findViewById(R.id.btnAddFood);

        add.setOnClickListener(v -> {
            MyDataHelper db = new MyDataHelper(getActivity());
            db.addFood(nameFood.getText().toString().trim(),Integer.valueOf(priceFood.getText().toString().trim()));
        });

        return view;
    }
}
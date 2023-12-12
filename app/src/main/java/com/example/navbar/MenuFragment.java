package com.example.navbar;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.service.controls.actions.FloatAction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MenuFragment extends Fragment {

    RecyclerView menuView;
    FloatingActionButton btnAddMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        btnAddMenu = view.findViewById(R.id.btnAddMenu);
        menuView = view.findViewById(R.id.menuView);

        btnAddMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment addFoodFragment = new AddFoodFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_layout, addFoodFragment, null);
                fragmentTransaction.addToBackStack(null).commit();
//                Intent intent = new Intent(getActivity(), AddFoodActivity.class);
//                startActivity(intent);
            }
        });



        return view;
    }

    private void setUpOnBackPressed() {
        requireActivity().getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(isEnabled()) {
                    setEnabled(false);
                    requireActivity().onBackPressed();
                }
            }
        });
    }
}
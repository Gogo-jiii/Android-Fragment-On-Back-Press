package com.example.fragmentonbackpress;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOneFragment extends Fragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_one, container, false);

        button = view.findViewById(R.id.btnGotoSecondFragment);
        button.setOnClickListener(v -> gotoSecondFragment());
        return view;
    }

    private void gotoSecondFragment() {
        FragmentTwoFragment fragment2 = new FragmentTwoFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack("Fragment2");
        fragmentTransaction.replace(R.id.container, fragment2,"Fragment2");
        fragmentTransaction.commit();
    }
}
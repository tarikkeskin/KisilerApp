package com.example.kisilerapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisilerapplication.R;
import com.example.kisilerapplication.databinding.FragmentAnasayfaBinding;


public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding tasarim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false);

        tasarim.toolbarAnasayfa.setTitle("Kişiler");

        tasarim.fab.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);

        });

        return tasarim.getRoot();
    }
}
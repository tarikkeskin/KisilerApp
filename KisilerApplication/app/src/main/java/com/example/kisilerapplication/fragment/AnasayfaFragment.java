package com.example.kisilerapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisilerapplication.R;
import com.example.kisilerapplication.databinding.FragmentAnasayfaBinding;
import com.example.kisilerapplication.entity.Kisiler;


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

        tasarim.buttonDetay.setOnClickListener(view -> {

            Kisiler kisi = new Kisiler(1,"ahmet","sfdsdf");
            //Using Direction when sending data
            AnasayfaFragmentDirections.KisiDetayGecis gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi);
            Navigation.findNavController(view).navigate(gecis);

        });

        return tasarim.getRoot();
    }
}
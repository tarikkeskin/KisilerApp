package com.example.kisilerapplication.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisilerapplication.R;
import com.example.kisilerapplication.databinding.FragmentKisiDetayBinding;
import com.example.kisilerapplication.entity.Kisiler;


public class KisiDetayFragment extends Fragment {

    private FragmentKisiDetayBinding tasarim;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Data binding
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_detay,container, false);
        tasarim.setKisiDetayFragment(this);

        tasarim.setKisiDetayToolbarBaslik("Kişi Detay");


        KisiDetayFragmentArgs bundle = KisiDetayFragmentArgs.fromBundle(getArguments());
        Kisiler gelenKisi = bundle.getKisi();
        tasarim.setKisiNesnesi(gelenKisi);

        return tasarim.getRoot();
    }

    public void buttonGuncelle(int kisi_id,String kisi_adi,String kisi_tel){
        Log.e("Kişi Güncelle",kisi_id + kisi_adi + kisi_tel);
    }

}
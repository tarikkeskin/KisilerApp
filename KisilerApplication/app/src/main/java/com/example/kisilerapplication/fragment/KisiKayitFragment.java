package com.example.kisilerapplication.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisilerapplication.R;
import com.example.kisilerapplication.databinding.FragmentKisiKayitBinding;
import com.example.kisilerapplication.viewmodel.KisiKayitFragmentViewModel;


public class KisiKayitFragment extends Fragment {

    private FragmentKisiKayitBinding tasarim;
    private KisiKayitFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Data binding
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false);
        tasarim.setKisiKayitFragment(this); // Initialize the kisikayıt fragment object

        tasarim.setKisiKayitToolbarBaslik("Kişi Kayıt");

        return tasarim.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KisiKayitFragmentViewModel.class);
    }

    public void buttonKaydetTikla(String kisi_ad, String kisi_tel){
        viewModel.kayit(kisi_ad,kisi_tel);
    }

}
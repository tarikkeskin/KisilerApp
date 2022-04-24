package com.example.kisilerapplication.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.repo.KisilerDaoRepository;

public class KisiKayitFragmentViewModel extends ViewModel {
    private KisilerDaoRepository kisilerDaoRepository = new KisilerDaoRepository();

    public void kayit(String kisi_ad,String kisi_tel){
        kisilerDaoRepository.kisiKayit(kisi_ad,kisi_tel);
    }
}

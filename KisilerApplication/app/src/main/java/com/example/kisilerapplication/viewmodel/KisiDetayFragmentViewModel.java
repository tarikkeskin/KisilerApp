package com.example.kisilerapplication.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.repo.KisilerDaoRepository;

public class KisiDetayFragmentViewModel extends ViewModel {
    private KisilerDaoRepository kisilerDaoRepository = new KisilerDaoRepository();

    public void guncelle(int kisi_id,String kisi_ad,String kisi_tel){
        kisilerDaoRepository.kisiGuncelle(kisi_id,kisi_ad,kisi_tel);
    }
}

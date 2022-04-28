package com.example.kisilerapplication.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.repo.KisilerDaoRepository;

public class KisiDetayFragmentViewModel extends AndroidViewModel {
    private KisilerDaoRepository kisilerDaoRepository;

    public KisiDetayFragmentViewModel(@NonNull Application application) {
        super(application);
        kisilerDaoRepository = new KisilerDaoRepository(application);
    }

    public void guncelle(int kisi_id, String kisi_ad, String kisi_tel){
        kisilerDaoRepository.kisiGuncelle(kisi_id,kisi_ad,kisi_tel);
    }
}

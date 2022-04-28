package com.example.kisilerapplication.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.repo.KisilerDaoRepository;

public class KisiKayitFragmentViewModel extends AndroidViewModel {
    private KisilerDaoRepository kisilerDaoRepository;

    public KisiKayitFragmentViewModel(@NonNull Application application) {
        super(application);
        kisilerDaoRepository = new KisilerDaoRepository(application);
    }

    public void kayit(String kisi_ad, String kisi_tel){
        kisilerDaoRepository.kisiKayit(kisi_ad,kisi_tel);
    }
}

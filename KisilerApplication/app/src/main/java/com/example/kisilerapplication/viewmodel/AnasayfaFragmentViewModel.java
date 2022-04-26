package com.example.kisilerapplication.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.repo.KisilerDaoRepository;

public class AnasayfaFragmentViewModel extends ViewModel {
    private KisilerDaoRepository kisilerDaoRepository = new KisilerDaoRepository();

    public void ara(String aramaKelimesi){
        kisilerDaoRepository.kisiAra(aramaKelimesi);
    }

    public void sil(int kisi_id){
        kisilerDaoRepository.kisiSil(kisi_id);
    }
}

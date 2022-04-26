package com.example.kisilerapplication.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.entity.Kisiler;
import com.example.kisilerapplication.repo.KisilerDaoRepository;

import java.util.List;

public class AnasayfaFragmentViewModel extends ViewModel {
    private KisilerDaoRepository kisilerDaoRepository = new KisilerDaoRepository();
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();

    public AnasayfaFragmentViewModel() {
        kisilerYukle();
        kisilerListesi = kisilerDaoRepository.kisileriGetir();
    }

    public void kisilerYukle(){
        kisilerDaoRepository.tumKisileriAl();
    }

    public void ara(String aramaKelimesi){
        kisilerDaoRepository.kisiAra(aramaKelimesi);
    }

    public void sil(int kisi_id){
        kisilerDaoRepository.kisiSil(kisi_id);
    }
}

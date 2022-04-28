package com.example.kisilerapplication.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.kisilerapplication.entity.Kisiler;
import com.example.kisilerapplication.repo.KisilerDaoRepository;

import java.util.List;

public class AnasayfaFragmentViewModel extends AndroidViewModel {
    private KisilerDaoRepository kisilerDaoRepository;
    public MutableLiveData<List<Kisiler>> kisilerListesi = new MutableLiveData<>();

    public AnasayfaFragmentViewModel(@NonNull Application application) {
        super(application);
        kisilerDaoRepository = new KisilerDaoRepository(application);
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

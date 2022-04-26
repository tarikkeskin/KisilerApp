package com.example.kisilerapplication.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisilerapplication.entity.Kisiler;

import java.util.ArrayList;
import java.util.List;

public class KisilerDaoRepository {

    private MutableLiveData<List<Kisiler>> kisilerListesi;

    public KisilerDaoRepository() {
        kisilerListesi = new MutableLiveData<>();
    }

    public MutableLiveData<List<Kisiler>> kisileriGetir(){
        return kisilerListesi;
    }

    public void kisiKayit(String kisi_ad, String kisi_tel){
        Log.e("Kişi Kayıt",kisi_ad+" - " +kisi_tel);
    }

    public void kisiGuncelle(int kisi_id,String kisi_ad,String kisi_tel){
        Log.e("Kişi Güncelle",kisi_id + kisi_ad + kisi_tel);
    }

    public void kisiAra(String aramaKelimesi) {
        Log.e("Kişi Ara",aramaKelimesi);
    }

    public void kisiSil(int kisi_id){
        Log.e("Kişi sil",String.valueOf(kisi_id));
    }

    public void tumKisileriAl(){
        ArrayList<Kisiler> liste = new ArrayList<>();
        Kisiler k1 = new Kisiler(1,"Veli","123456");
        Kisiler k2 = new Kisiler(2,"elif","1663426");
        Kisiler k3 = new Kisiler(3,"ahmet","1123126");
        Kisiler k4 = new Kisiler(3,"ahmet","1123126");
        liste.add(k1);
        liste.add(k2);
        liste.add(k3);
        liste.add(k4);
        kisilerListesi.setValue(liste);

    }

}

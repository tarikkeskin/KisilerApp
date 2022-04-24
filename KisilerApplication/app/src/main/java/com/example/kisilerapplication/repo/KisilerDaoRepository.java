package com.example.kisilerapplication.repo;

import android.util.Log;

public class KisilerDaoRepository {

    public void kisiKayit(String kisi_ad,String kisi_tel){
        Log.e("Kişi Kayıt",kisi_ad+" - " +kisi_tel);
    }

    public void kisiGuncelle(int kisi_id,String kisi_ad,String kisi_tel){
        Log.e("Kişi Güncelle",kisi_id + kisi_ad + kisi_tel);
    }

    public void kisiAra(String aramaKelimesi){
        Log.e("Kişi Ara",aramaKelimesi);
    }

}

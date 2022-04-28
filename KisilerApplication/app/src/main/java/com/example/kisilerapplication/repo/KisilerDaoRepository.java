package com.example.kisilerapplication.repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kisilerapplication.entity.Kisiler;
import com.example.kisilerapplication.room.Veritabani;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class KisilerDaoRepository {

    private MutableLiveData<List<Kisiler>> kisilerListesi;
    private Veritabani vt;

    public KisilerDaoRepository(Application application) {
        kisilerListesi = new MutableLiveData<>();
        vt = Veritabani.veritabaniErisim(application);
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
        Disposable disposable = vt.kisilerDao().tumKisiler()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(liste -> {
                    kisilerListesi.setValue(liste);
                });
    }

}

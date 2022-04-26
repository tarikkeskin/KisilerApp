package com.example.kisilerapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisilerapplication.R;
import com.example.kisilerapplication.databinding.CardTasarimBinding;
import com.example.kisilerapplication.entity.Kisiler;
import com.example.kisilerapplication.fragment.AnasayfaFragmentDirections;
import com.example.kisilerapplication.viewmodel.AnasayfaFragmentViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class KisilerAdapter extends RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kisiler> kisilerListesi;
    private AnasayfaFragmentViewModel viewModel;

    public KisilerAdapter(Context mContext, List<Kisiler> kisilerListesi, AnasayfaFragmentViewModel viewModel) {
        this.mContext = mContext;
        this.kisilerListesi = kisilerListesi;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
         * Card tasarim Data binding
         */
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardTasarimBinding tasarim = DataBindingUtil.inflate(layoutInflater, R.layout.card_tasarim, parent,false);
        return new CardTasarimTutucu(tasarim);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kisiler kisi = kisilerListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.setKisiNesnesi(kisi);

        //Data binding dont support card event handler

        /**
         *click componenets
         * data transfer
         */
        t.satirCard.setOnClickListener(view -> {
            AnasayfaFragmentDirections.KisiDetayGecis gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi);
            Navigation.findNavController(view).navigate(gecis);

        });

        t.imageViewSilResim.setOnClickListener(view -> {
            Snackbar.make(view,kisi.getKisi_ad() +" silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("Evet",view1 -> {
                        viewModel.sil(kisi.getKisi_id());
                    })
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return kisilerListesi.size();
    }

}

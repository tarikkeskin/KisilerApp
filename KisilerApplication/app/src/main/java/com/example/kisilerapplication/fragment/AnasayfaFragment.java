package com.example.kisilerapplication.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisilerapplication.R;
import com.example.kisilerapplication.adapter.KisilerAdapter;
import com.example.kisilerapplication.databinding.FragmentAnasayfaBinding;
import com.example.kisilerapplication.entity.Kisiler;
import com.example.kisilerapplication.viewmodel.AnasayfaFragmentViewModel;

import java.util.ArrayList;


public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener{

    private FragmentAnasayfaBinding tasarim;
    private AnasayfaFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // DataBinding
        tasarim = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa,container, false);
        tasarim.setAnasayfaFragment(this);
        tasarim.setAnasayfaToolbarBaslik("Kişiler");

        /**
         * Adding menu toolbar
         */
        ((AppCompatActivity) getActivity()).setSupportActionBar(tasarim.toolbarAnasayfa);


        //Grid recycler view vertical&horizontal
        //tasarim.rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));

        viewModel.kisilerListesi.observe(getViewLifecycleOwner(),liste -> {
            KisilerAdapter adapter = new KisilerAdapter(requireContext(),liste,viewModel);
            tasarim.setKisilerAdapter(adapter);
        });



        return tasarim.getRoot();
    }

    public void fabTikla(View view){
        Navigation.findNavController(view).navigate(R.id.kisiKayitGecis);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        viewModel = new ViewModelProvider(this).get(AnasayfaFragmentViewModel.class);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu,menu);
        /**
         * item connection
         */
        MenuItem item = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);


        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query); // when icaon selected pressed
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText); // harf girdikce
        return true;
    }


    /*
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_ara:
                Log.e("Kişi Ara Icon","Secildi");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */


}
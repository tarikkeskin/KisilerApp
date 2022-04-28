package com.example.kisilerapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class KisiDetayVFM extends ViewModelProvider.NewInstanceFactory {
    private final Application application;

    public KisiDetayVFM(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new KisiDetayFragmentViewModel(application);
    }
}

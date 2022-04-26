package com.example.kisilerapplication.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.kisilerapplication.entity.Kisiler;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface KisilerDao {
    @Query("select * from kisiler")
    Single<List<Kisiler>> tumKisiler();
}

package com.example.uas_180030459.services;

import com.example.uas_180030459.model.ResponseData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiMusic {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponseData> addData(
            @Field("judul_lagu") String judulLagu,
            @Field("nama_penyanyi") String namaPenyanyi,
            @Field("album") String album,
            @Field("tahun") String tahun,
            @Field("photo") String photo,
            @Field("genre") String genre
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ResponseData> editData(
            @Field("id") String id,
            @Field("judul_lagu") String judulLagu,
            @Field("nama_penyanyi") String namaPenyanyi,
            @Field("album") String album,
            @Field("tahun") String tahun,
            @Field("photo") String photo,
            @Field("genre") String genre
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ResponseData> deleteData(
            @Field("id") String id
    );

    @FormUrlEncoded
    @POST("search.php")
    Call<ResponseData> searchData(
            @Field("search") String keyword
    );

    @GET("getdata.php")
    Call<ResponseData> getData();
}

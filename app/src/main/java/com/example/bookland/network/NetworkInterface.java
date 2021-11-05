package com.example.bookland.network;


import com.example.bookland.modelBook.BookResponse;

import java.io.File;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkInterface {
    @GET("search")
    Call<BookResponse> getBooksByName(@Query("q") String name);

}

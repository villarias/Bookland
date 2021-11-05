package com.example.bookland.network;

import com.example.bookland.AppExecutors;
import com.example.bookland.modelBook.BookResponse;

import java.io.File;
import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRunnable implements Runnable{

    private final NetworkListener networkListener;
    private final String name ;
    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://v1.nocodeapi.com/villarias/gr/uXMhsIocjeoXXJRw/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    NetworkInterface service = retrofit.create(NetworkInterface.class);
    final String appKey="MP4x8MboUU0pqECZxYO49g";


    public NetworkRunnable(NetworkListener bookLoaded,String name){
        networkListener = bookLoaded;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            BookResponse response = service.getBooksByName(name).execute().body();
            AppExecutors.getInstance().mainThread().execute(()-> {
                networkListener.onBookLoaded(response);
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


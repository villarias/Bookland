package com.example.bookland.network;

import android.util.Log;

import com.example.bookland.AppExecutors;
import com.example.bookland.database.Book;
import com.example.bookland.modelBook.BookResponse;
import com.example.bookland.modelBook.Result;

import java.util.ArrayList;
import java.util.List;

public class NetworkDataSource {
    private static NetworkDataSource sInstance;
    private final List<Book> booksObtained;
    public synchronized static NetworkDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new NetworkDataSource();
        }
        return sInstance;
    }

    public NetworkDataSource(){
        booksObtained = new ArrayList<>();
    };

    public List<Book> loadBooks(String name) {

        AppExecutors.getInstance().networkIO().execute(new NetworkRunnable(new NetworkListener() {
            @Override
            public void onBookLoaded(BookResponse books) {
                for(Result r : books.getResults()){
                    Book aux = new Book();
                    aux.setAuthor(r.getAuthor().getName());
                    aux.setTitle(r.getTitle());
                    aux.setImage("https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1397161148l/18209368._SX98_.jpg");
                   // aux.setRating(r.getRatingsCount());
                    Log.i("Titulo",r.getTitle());
                    booksObtained.add(aux);
                }
            }
        },name));
        return booksObtained;
    }
}

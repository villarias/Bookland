package com.example.bookland.network;

import com.example.bookland.modelBook.BookResponse;

import java.io.File;

public interface NetworkListener {
    public void onBookLoaded(BookResponse books );
}

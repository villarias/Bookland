package com.example.bookland.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Book b);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertList(List<Book> books);

    @Update
    public void update(Book b);

    @Query("SELECT * FROM book WHERE title = :titulo")
    public Book get(String titulo);

    @Delete
    public void delete(Book b);

    @Query("SELECT * FROM book WHERE favourite =1")
    public List<Book> getFavourites();

    @Query("SELECT * FROM book WHERE reading =1")
    public List<Book> getReading();

    @Query("SELECT * FROM book WHERE toBeRead =1")
    public List<Book> getToBeRead();



}

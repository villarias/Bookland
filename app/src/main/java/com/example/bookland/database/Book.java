package com.example.bookland.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Book")
public class Book {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private long idBook;
    @ColumnInfo(name = "title")
    String title;
    @ColumnInfo(name = "author")
    String author;
    @ColumnInfo(name = "image")
    String image;
    @ColumnInfo(name = "rating")
    int rating;
    @ColumnInfo(name="favourite")
    int favourite;
    @ColumnInfo(name="reading")
    int reading;
    @ColumnInfo(name="toBeRead")
    int toBeRead;
    @ColumnInfo(name="publication_year")
    int publicationYear;
    @ColumnInfo(name="publication_month")
    int publicationMonth;
    @ColumnInfo(name = "publication_day")
    int publicationDay;

    public Book(){

        favourite =0;
        reading =0;
        toBeRead=0;

    }

    public Book(String title, String author, String image, int rating,int year,int month,int day) {

        this.title = title;
        this.author = author;
        this.image = image;
        this.rating = rating;
        this.publicationYear = year;
        this.publicationMonth = month;
        this.publicationDay = day;
        favourite =0;
        reading =0;
        toBeRead=0;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setFavourite(int favourite) { this.favourite = favourite; }

    public void setReading(int reading) { this.reading = reading; }

    public void setToBeRead(int toBeRead) { this.toBeRead = toBeRead; }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public int getRating() {
        return rating;
    }

    public int getFavourite() { return favourite; }

    public int getReading() { return reading; }

    public int getToBeRead() { return toBeRead; }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPublicationMonth() {
        return publicationMonth;
    }

    public void setPublicationMonth(int publicationMonth) {
        this.publicationMonth = publicationMonth;
    }

    public int getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(int day) {
        this.publicationDay = day;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

}

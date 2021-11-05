
package com.example.bookland.modelBook;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("obj_id")
    @Expose
    private Integer objId;
    @SerializedName("books_count")
    @Expose
    private Integer booksCount;
    @SerializedName("ratings_count")
    @Expose
    private Integer ratingsCount;
    @SerializedName("text_reviews_count")
    @Expose
    private Integer textReviewsCount;
    @SerializedName("original_publication_year")
    @Expose
    private Integer originalPublicationYear;
    @SerializedName("original_publication_month")
    @Expose
    private Integer originalPublicationMonth;
    @SerializedName("original_publication_day")
    @Expose
    private Integer originalPublicationDay;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("small_image_url")
    @Expose
    private String smallImageUrl;

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(Integer booksCount) {
        this.booksCount = booksCount;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public Integer getTextReviewsCount() {
        return textReviewsCount;
    }

    public void setTextReviewsCount(Integer textReviewsCount) {
        this.textReviewsCount = textReviewsCount;
    }

    public Integer getOriginalPublicationYear() {
        return originalPublicationYear;
    }

    public void setOriginalPublicationYear(Integer originalPublicationYear) {
        this.originalPublicationYear = originalPublicationYear;
    }

    public Integer getOriginalPublicationMonth() {
        return originalPublicationMonth;
    }

    public void setOriginalPublicationMonth(Integer originalPublicationMonth) {
        this.originalPublicationMonth = originalPublicationMonth;
    }

    public Integer getOriginalPublicationDay() {
        return originalPublicationDay;
    }

    public void setOriginalPublicationDay(Integer originalPublicationDay) {
        this.originalPublicationDay = originalPublicationDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

}

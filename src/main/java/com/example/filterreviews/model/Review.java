package com.example.filterreviews.model;

import lombok.Data;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Review {

    private String reviewId;
    private String reviewText;
    private Integer numLikes;
    private Integer numComments;
    private Integer numShares;
    private Integer rating;
     private Long createdOnTime;
    private String createdOnDate;

    public Review(String reviewId, String reviewText, Integer numLikes, Integer numComments, Integer numShares, Integer rating, Long createdOnTime, String createdOnDate) {
        this.reviewId = reviewId;
        this.reviewText = reviewText;
        this.numLikes = numLikes;
        this.numComments = numComments;
        this.numShares = numShares;
        this.rating = rating;
        this.createdOnTime = createdOnTime;
        OffsetDateTime of = OffsetDateTime.parse(createdOnDate);
        this.createdOnDate = of.format( DateTimeFormatter.ofPattern("yyyy-MM-d HH:mm:ss"));
    }
}

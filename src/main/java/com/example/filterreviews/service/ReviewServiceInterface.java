package com.example.filterreviews.service;

import com.example.filterreviews.model.Review;

import java.util.Comparator;
import java.util.List;

public interface ReviewServiceInterface {

    public List<Review> getAll();
    public List<Review> filterReview(String rating, String minumum, String date, String text);
    public Comparator<Review> getComparator(String rating,String date);
}

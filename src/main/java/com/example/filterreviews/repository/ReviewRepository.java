package com.example.filterreviews.repository;

import com.example.filterreviews.dataHolder.DataHolder;
import com.example.filterreviews.model.Review;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewRepository {

public List<Review> getAll(){
    return DataHolder.reviews;
}
}

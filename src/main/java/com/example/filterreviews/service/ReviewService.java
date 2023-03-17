package com.example.filterreviews.service;

import com.example.filterreviews.model.Review;
import com.example.filterreviews.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements ReviewServiceInterface {

private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> getAll() {
        return reviewRepository.getAll();
    }

    @Override
    public List<Review> filterReview(String rating, String minumum, String date, String text) {

        Comparator<Review> reviewComparator = getComparator( rating,date );
        int min = Integer.parseInt( minumum );
        List<Review> reviews = getAll().stream().filter( review -> review.getRating() >= min)
                .sorted(reviewComparator).collect( Collectors.toList());
        if(text.equals( "yes" )){
            List<Review> withReviewText = reviews.stream().filter( review -> !(review.getReviewText().isBlank()) )
                    .collect( Collectors.toList());
            List<Review> withoutReviewText = reviews.stream().filter( review -> review.getReviewText().isBlank() )
                    .collect( Collectors.toList());
            withReviewText.addAll( withoutReviewText );
            return withReviewText;
        }
        return reviews;
    }

    @Override
    public Comparator<Review> getComparator(String rating, String date) {
        //case higerest rating and oldest by date
        Comparator<Review> comparator = Comparator.comparing( Review::getRating ).reversed().thenComparing(Review::getCreatedOnTime);
//        "lowest"
//        oldest
//                newest

        if(rating.equals("highest") && date.equals( "newest"))
        comparator = Comparator.comparing( Review::getRating ).thenComparing( Review::getCreatedOnTime ).reversed();
        else if(rating.equals("lowest") && date.equals( "newest"))
        comparator = Comparator.comparing( Review::getRating ).reversed().thenComparing( Review::getCreatedOnTime ).reversed();
        else if(rating.equals("lowest") && date.equals( "oldest"))
            comparator = Comparator.comparing( Review::getRating ).thenComparing( Review::getCreatedOnTime );
        return comparator;
    }
}

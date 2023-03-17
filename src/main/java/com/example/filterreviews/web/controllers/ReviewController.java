package com.example.filterreviews.web.controllers;

import com.example.filterreviews.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = {"/", "/review"})
public class ReviewController {

private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    @GetMapping
    public String getFilterForm(){
    return "filterForm";
    }
    @PostMapping("/filter")
    public String filterParametars(@RequestParam String rating,
                                   @RequestParam String minimum,
                                   @RequestParam String date,
                                   @RequestParam String text,
                                   Model model){

        model.addAttribute( "reviews",reviewService.filterReview( rating,minimum,date,text ) );
        model.addAttribute( "rating",rating );
        model.addAttribute( "date",date );
        model.addAttribute( "text",text );
        model.addAttribute( "minimum",minimum );
        return "filteredReviews";
    }


}

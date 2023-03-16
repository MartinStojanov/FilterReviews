package com.example.filterreviews.dataHolder;

import com.example.filterreviews.model.Review;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Review> reviews = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/static/reviews (2).json");
        JSONArray a = (JSONArray) jsonParser.parse(reader);

        for (Object o : a) {
            JSONObject person = (JSONObject) o;

            String reviewId = ( String ) person.get( "reviewId" );
            String reviewText =  ( String ) person.get( "reviewText" );
            Integer numLikes = Integer.parseInt( person.get( "numLikes" ).toString());
            Integer numComments =  Integer.parseInt( person.get( "numComments" ).toString());
            Integer numShares = Integer.parseInt(person.get( "numShares" ).toString());
            Integer rating = Integer.parseInt( person.get( "rating" ).toString());
            Long createdOnTime = Long.parseLong(person.get( "reviewCreatedOnTime" ).toString());
            String createdOnDate = ( String ) person.get( "reviewCreatedOnDate" );
            reviews.add( new Review( reviewId,reviewText,numLikes,numComments,numShares,rating,createdOnTime,createdOnDate ) );
        }
    }

}

package com.sinyak.ordercake.service;

import com.sinyak.ordercake.entity.Reviews;
import com.sinyak.ordercake.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private final ReviewsRepository reviewsRepository;

    public ReviewService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    public List<Reviews> findAll(){
        return reviewsRepository.findAll();
    }

    public void deleteByID(int id){
        reviewsRepository.deleteById(id);
    }

    public void save(Reviews reviews){
        reviewsRepository.save(reviews);
    }
}

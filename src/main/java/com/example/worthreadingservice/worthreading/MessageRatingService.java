package com.example.worthreadingservice.worthreading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MessageRatingService  {

    WorthReadingRepository repo;


    public MessageRatingService(WorthReadingRepository repo) {
        this.repo = repo;
    }

    public void removeLike(Long messageId, Long userId) {
    }

    public void addLike(Long messageId, Long userId) {
    }

    public void removeDislike(Long messageId, Long userId) {
    }

    public void addDislike(Long messageId, Long userId) {
    }

    public int getAmountOfLikes(Long messageId) {
        int placeholder = 1;
        return placeholder;
    }


    public List<UserDto> getUsersWhoDisliked(Long messageId) {

        return new ArrayList<>();
    }
}

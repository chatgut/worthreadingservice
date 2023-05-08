package com.example.worthreadingservice.controller;

import com.example.worthreadingservice.service.MessageRatingService;
import com.example.worthreadingservice.service.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {

    private final MessageRatingService messageRatingService;

    public LikeController(MessageRatingService messageRatingService) {
        this.messageRatingService = messageRatingService;
    }

    @PutMapping("/like/{messageId}/{userId}/{liked}")
    ResponseEntity<Void> toggleLike(@PathVariable Long messageId, @PathVariable Long userId, @PathVariable boolean liked) {
        if (liked)
            messageRatingService.removeLike(messageId, userId);
         else
            messageRatingService.addLike(messageId, userId);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/like/amount/{messageId}")
    ResponseEntity<Integer> getAmountOfLikes(@PathVariable Long messageId){
        int likesCount = messageRatingService.getAmountOfLikes(messageId);
        return ResponseEntity.ok(likesCount);
    }
    @GetMapping("/like/isLiked/{messageId}/{userId}")
    ResponseEntity<Boolean> isLiked(@PathVariable Long messageId, @PathVariable Long userId){
        boolean isLiked = messageRatingService.isLiked(messageId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/like/users/{messageId}")
    List<UserDto> getUsersWhoLikeMessage(@PathVariable Long messageId) {
        return messageRatingService.getUsersWhoLikeMessage(messageId);
    }

    @GetMapping("/like/messages/{userId}")
    List<UserDto> getMessagesLikedByUser(@PathVariable Long userId) {
        return messageRatingService.getMessagesLikedByUser(userId);
    }

}

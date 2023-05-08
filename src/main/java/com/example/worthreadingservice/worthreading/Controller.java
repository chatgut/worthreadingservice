package com.example.worthreadingservice.worthreading;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private MessageRatingService messageRatingService;

    public Controller(MessageRatingService messageRatingService) {
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

    @GetMapping("/dislike/users/{messageId}")
    List<UserDto> getDislikeUsers(@PathVariable Long messageId) {
        return messageRatingService.getUsersWhoLikeMessage(messageId);
    }

    @GetMapping("/dislike/messages/{userId}")
    List<UserDto> getMessagesLikedByUser(@PathVariable Long userId) {
        return messageRatingService.getMessagesLikedByUser(userId);
    }




}

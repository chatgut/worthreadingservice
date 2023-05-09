package com.example.worthreadingservice.controller;

import com.example.worthreadingservice.service.LikeService;
import com.example.worthreadingservice.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService messageRatingService) {
        this.likeService = messageRatingService;
    }

    @PutMapping("/like/{messageId}/{userId}/{liked}")
    ResponseEntity<Void> toggleLike(@PathVariable Long messageId, @PathVariable Long userId, @PathVariable boolean liked) {
        if (liked)
            likeService.removeLike(messageId, userId);
         else
            likeService.addLike(messageId, userId);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/like/amount/{messageId}")
    ResponseEntity<Integer> getAmountOfLikes(@PathVariable Long messageId){
        int likesCount = likeService.getAmountOfLikes(messageId);
        return ResponseEntity.ok(likesCount);
    }
    @GetMapping("/like/isLiked/{messageId}/{userId}")
    ResponseEntity<Boolean> isLiked(@PathVariable Long messageId, @PathVariable Long userId){
        boolean isLiked = likeService.isLiked(messageId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("/like/users/{messageId}")
    List<UserDto> getUsersWhoLikeMessage(@PathVariable Long messageId) {
        return likeService.getUsersWhoLikeMessage(messageId);
    }

    @GetMapping("/like/messages/{userId}")
    List<UserDto> getMessagesLikedByUser(@PathVariable Long userId) {
        return likeService.getMessagesLikedByUser(userId);
    }

}

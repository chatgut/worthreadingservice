package com.example.worthreadingservice.controller;

import com.example.worthreadingservice.service.LikeService;
import com.example.worthreadingservice.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worthreading")
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

    @GetMapping("/like/isLiked/{messageId}/{userId}")
    ResponseEntity<Boolean> isLiked(@PathVariable Long messageId, @PathVariable Long userId){
        boolean isLiked = likeService.isLiked(messageId, userId);
        return ResponseEntity.ok(isLiked);
    }


    /** Endpoints below is not implemented in the frontend yet.
     */

    @GetMapping("/like/amount/{messageId}")
    ResponseEntity<Integer> getAmountOfLikes(@PathVariable Long messageId){
        int likesCount = likeService.getAmountOfLikes(messageId);
        return ResponseEntity.ok(likesCount);
    }

    @GetMapping("/like/users/{messageId}")
    List<UserDto> getUsersWhoLikeMessage(@PathVariable Long messageId) {
        return likeService.getUsersWhoLikeMessage(messageId);
    }

    @GetMapping("/like/messages/{userId}")
    List<UserDto> getMessagesLikedByUser(@PathVariable Long userId) {
        //Todo: implement in likeService
        return likeService.getMessagesLikedByUser(userId);
    }

}

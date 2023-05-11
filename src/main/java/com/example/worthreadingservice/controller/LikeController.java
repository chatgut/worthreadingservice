package com.example.worthreadingservice.controller;

import com.example.worthreadingservice.service.LikeService;
import com.example.worthreadingservice.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worthreading/like/")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService messageRatingService) {
        this.likeService = messageRatingService;
    }

    @PutMapping("{messageId}/{userId}/{liked}")
    ResponseEntity<Void> toggleLike(@PathVariable Long messageId, @PathVariable Long userId, @PathVariable boolean liked) {
        if (liked)
            likeService.removeLike(messageId, userId);
         else
            likeService.addLike(messageId, userId);
         return ResponseEntity.ok().build();
    }

    @GetMapping("isLiked/{messageId}/{userId}")
    ResponseEntity<Boolean> isLiked(@PathVariable Long messageId, @PathVariable Long userId){
        boolean isLiked = likeService.isLiked(messageId, userId);
        return ResponseEntity.ok(isLiked);
    }

    @GetMapping("amount/{messageId}")
    ResponseEntity<Integer> getAmountOfLikes(@PathVariable Long messageId){
        int likesCount = likeService.getAmountOfLikes(messageId);
        return ResponseEntity.ok(likesCount);
    }

    /** Endpoint below is not implemented in the frontend yet and is depending on user service 2 running */

    @GetMapping("users/{messageId}")
    List<UserDto> getUsersWhoLikeMessage(@PathVariable Long messageId) {
        return likeService.getUsersWhoLikeMessage(messageId);
    }

    /** Endpoint below is not implemented in the frontend nor here yet.
     * The message service may or may not have implemented an endpoint for this to use.
     * The code in likeService for this to work should be about the same as "getUsersWhoLikeMessage".
     */

    @GetMapping("messages/{userId}")
    List<UserDto> getMessagesLikedByUser(@PathVariable Long userId) {
        //Todo: implement in likeService
        return likeService.getMessagesLikedByUser(userId);
    }

}

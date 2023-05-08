package com.example.worthreadingservice.worthreading;

import com.example.worthreadingservice.worthreading.entity.MessageEntity;
import com.example.worthreadingservice.worthreading.entity.UserEntity;
import com.example.worthreadingservice.worthreading.repository.MessageRepository;
import com.example.worthreadingservice.worthreading.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MessageRatingService  {

    MessageRepository messageRepo;
    UserRepository userRepo;


    public MessageRatingService(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    public void removeLike(Long messageId, Long userId) {
    }

    public void addLike(Long messageId, Long userId) {

        MessageEntity message = messageRepo.findById(messageId).orElse(null);
        if (message == null) {
            message = new MessageEntity();
            message.setId(messageId);
        }

        UserEntity user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            user = new UserEntity();
            user.setId(userId);
            userRepo.save(user);
        }

        message.getUserIds().add(user);
        messageRepo.save(message);
    }


    public int getAmountOfLikes(Long messageId) {
        int placeholder = 1;
        return placeholder;
    }


    public List<UserDto> getUsersWhoLikeMessage(Long messageId) {
        return new ArrayList<>();
    }

    public List<UserDto> getMessagesLikedByUser(Long messageId) {
        return new ArrayList<>();
    }

}

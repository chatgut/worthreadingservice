package com.example.worthreadingservice.service;

import com.example.worthreadingservice.dto.UserDto;
import com.example.worthreadingservice.entity.MessageEntity;
import com.example.worthreadingservice.entity.UserEntity;
import com.example.worthreadingservice.repository.MessageRepository;
import com.example.worthreadingservice.repository.UserRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class LikeService {

    MessageRepository messageRepo;
    UserRepository userRepo;

    public LikeService(MessageRepository messageRepo, UserRepository userRepo) {
        this.messageRepo = messageRepo;
        this.userRepo = userRepo;
    }

    public void addLike(String messageId, String userId) {
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

    @Transactional
    public void removeLike(String messageId, String userId) {
        messageRepo.findById(messageId).ifPresent(m -> m.getUserIds().removeIf(user -> user.getId().equals(userId)));
    }

    public boolean isLiked(String messageId, String userId) {
        return messageRepo.findById(messageId).map(m -> m.getUserIds().stream().anyMatch(u -> u.getId().equals(userId))).orElse(false);
    }

    public Map<String, Boolean> bulkIsLiked(String messageIds, String userId) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();

        JsonObject jsonObject = JsonParser.parseString(messageIds).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("messageIds");

        List<String> messageIdList = gson.fromJson(jsonArray, listType);
        List<String> likedMessageIds = messageRepo.findLikedMessageIdsByUser(messageIdList, userId);

        return messageIdList.stream()
                .collect(Collectors.toMap(
                        messageId -> messageId, likedMessageIds::contains));
    }

    public int getAmountOfLikes(String messageId) {
        return messageRepo.findById(messageId).map(m -> m.getUserIds().size()).orElse(0);
    }





    public List<UserDto> getUsersWhoLikeMessage(String messageId) {
        return callUserApi(messageRepo.findById(messageId)
                .orElseThrow()
                .getUserIds()
                .stream()
                .map(UserEntity::getId)
                .collect(Collectors.joining(",")));
    }

    private List<UserDto> callUserApi(String csv) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8002/users/" + csv;
        String jsonResponse = restTemplate.getForObject(url, String.class);
        return parseUserJson(jsonResponse);
    }

    private List<UserDto> parseUserJson(String jsonResponse) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<UserDto>>(){}.getType();
        return gson.fromJson(jsonResponse, listType);
    }

    public List<UserDto> getMessagesLikedByUser(String userId) {
        //Todo: implement
        return new ArrayList<>();
    }




}

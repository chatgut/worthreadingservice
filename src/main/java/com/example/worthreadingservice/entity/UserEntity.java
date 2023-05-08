package com.example.worthreadingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class UserEntity {

    @Id
    private Long id;

    @ManyToMany(mappedBy = "userIds")
    private Set <MessageEntity> likedMessages = new HashSet<>();

}

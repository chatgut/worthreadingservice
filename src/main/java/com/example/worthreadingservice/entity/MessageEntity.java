package com.example.worthreadingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
public class MessageEntity {

    @Id
    private Long id;


    @ManyToMany(fetch =  FetchType.EAGER)
    private Set<UserEntity> userIds = new HashSet<>();

}

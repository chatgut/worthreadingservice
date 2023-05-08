package com.example.worthreadingservice.repository;

import com.example.worthreadingservice.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository <UserEntity, Long >{
}

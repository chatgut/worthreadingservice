package com.example.worthreadingservice.worthreading.repository;
import com.example.worthreadingservice.worthreading.entity.MessageEntity;
import com.example.worthreadingservice.worthreading.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends ListCrudRepository<MessageEntity, Long> {

}

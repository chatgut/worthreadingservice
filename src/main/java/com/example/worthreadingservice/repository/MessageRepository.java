package com.example.worthreadingservice.repository;
import com.example.worthreadingservice.entity.MessageEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends ListCrudRepository<MessageEntity, String> {





}

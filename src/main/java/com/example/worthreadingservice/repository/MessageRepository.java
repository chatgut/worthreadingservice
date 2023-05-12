package com.example.worthreadingservice.repository;
import com.example.worthreadingservice.entity.MessageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends ListCrudRepository<MessageEntity, String> {

    @Query("SELECT m.id FROM MessageEntity m INNER JOIN m.userIds u WHERE m.id IN :messageIds AND u.id = :userId")
    List<String> findLikedMessageIdsByUser(@Param("messageIds") List<String> messageIdList, @Param("userId") String userId);

}

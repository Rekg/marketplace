package com.codewithrekik.marketplace.infrastructure.persistance;

import com.codewithrekik.marketplace.domain.entities.User;
import com.codewithrekik.marketplace.domain.interfaces.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends MongoRepository<User, String>, UserRepository {
    User findByUsername(String username);
}
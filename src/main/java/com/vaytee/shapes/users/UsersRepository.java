package com.vaytee.shapes.users;

import com.vaytee.shapes.users.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Admin on 2017-07-31.
 */
public interface UsersRepository extends MongoRepository<User, String> {
    User findByUsername(@Param("username") String username);
}

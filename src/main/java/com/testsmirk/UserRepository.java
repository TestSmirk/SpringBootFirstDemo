package com.testsmirk;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Smirk on 2017/3/4.
 */
public interface UserRepository extends MongoRepository<User,Long>{
    User findByUsername(String name);
}

package com.testsmirk;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Smirk on 2017/3/4.
 */
public interface UserRepository extends MongoRepository<User,Long>{
    @Query("{'username':?0}")
    User findByUsername(String name);


    @Query("{'id':{'$ne':?0}}")
    User findAllExceptId(String id);

    @Query("{'_id':?0}")
    User findByUserid(String name);
}

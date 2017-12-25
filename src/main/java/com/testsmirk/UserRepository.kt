package com.testsmirk

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

/**
 * Created by Smirk on 2017/3/4.
 */
interface UserRepository : MongoRepository<User, Long> {
    fun findByUsername(name: String): User


}

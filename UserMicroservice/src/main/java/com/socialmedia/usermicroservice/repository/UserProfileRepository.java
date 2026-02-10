package com.socialmedia.usermicroservice.repository;

import com.socialmedia.usermicroservice.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

}

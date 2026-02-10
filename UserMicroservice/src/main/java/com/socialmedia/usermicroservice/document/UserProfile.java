package com.socialmedia.usermicroservice.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
@Document
public class UserProfile {
    @Id
    String id;
    Long authId;
    String userName;
    String name;
    String surName;
    String email;
    String phone;
    String avatar;
    String insta;
    String twitter;
    Boolean isActive;
    Long createAt;

}

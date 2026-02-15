package com.socialmedia.usermicroservice.service;

import com.socialmedia.usermicroservice.document.UserProfile;
import com.socialmedia.usermicroservice.dto.request.CreateUserRequestDto;
import com.socialmedia.usermicroservice.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;
    private final CacheManager cacheManager;

    public void createUser(CreateUserRequestDto dto) {
        repository.save(UserProfile.builder()
                        .authId(dto.getAuthId())
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> getAll() {
        return repository.findAll();
    }

    @Cacheable ("upper-case")
    public String upperName(String name) {
        String result = name.toUpperCase();
        try{
            Thread.sleep(3000L);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    public void clearCache(){
        cacheManager.getCache("upper-case").clear();
    }
}

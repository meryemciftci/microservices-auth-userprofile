package com.socialmedia.usermicroservice.service;

import com.socialmedia.usermicroservice.document.UserProfile;
import com.socialmedia.usermicroservice.dto.request.CreateUserRequestDto;
import com.socialmedia.usermicroservice.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository repository;

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
}

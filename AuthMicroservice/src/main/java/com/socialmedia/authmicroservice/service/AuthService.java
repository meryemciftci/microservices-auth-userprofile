package com.socialmedia.authmicroservice.service;

import com.socialmedia.authmicroservice.dto.request.CreateUserRequestDto;
import com.socialmedia.authmicroservice.dto.request.LoginResponseDto;
import com.socialmedia.authmicroservice.dto.request.RegisterRequestDto;
import com.socialmedia.authmicroservice.entity.Auth;
import com.socialmedia.authmicroservice.manager.UserProfileManager;
import com.socialmedia.authmicroservice.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDto dto) {
         Auth auth = repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                .build());
         userProfileManager.createUser(CreateUserRequestDto.builder()
                         .authId(auth.getId())
                         .email(auth.getEmail())
                         .userName(auth.getUserName())
                 .build());
         return auth;

    }

    public Boolean login(LoginResponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}

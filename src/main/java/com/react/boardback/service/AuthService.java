package com.react.boardback.service;

import org.springframework.http.ResponseEntity;

import com.react.boardback.dto.request.auth.SignInRequestDto;
import com.react.boardback.dto.request.auth.SignUpRequestDto;
import com.react.boardback.dto.response.auth.SignUpResponseDto;
import com.react.boardback.dto.response.auth.SignInResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
} 

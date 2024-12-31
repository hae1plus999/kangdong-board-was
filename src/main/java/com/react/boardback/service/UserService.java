package com.react.boardback.service;

import org.springframework.http.ResponseEntity;

import com.react.boardback.dto.request.user.PatchNicknameRequestDto;
import com.react.boardback.dto.request.user.PatchProfileImageRequestDto;
import com.react.boardback.dto.response.user.GetSignInUserResponseDto;
import com.react.boardback.dto.response.user.GetUserResponseDto;
import com.react.boardback.dto.response.user.PatchProfileImageResponseDto;
import com.react.boardback.dto.response.user.PatchNicknameResponseDto;

public interface UserService {
    
    ResponseEntity<? super GetUserResponseDto> getUser(String email);
    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    ResponseEntity<? super PatchNicknameResponseDto> patchNickname(PatchNicknameRequestDto dto, String email);
    ResponseEntity<? super PatchProfileImageResponseDto> patchProfileImage(PatchProfileImageRequestDto dto, String email);
}

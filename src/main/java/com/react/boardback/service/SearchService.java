package com.react.boardback.service;

import org.springframework.http.ResponseEntity;

import com.react.boardback.dto.response.search.GetPopularListResponseDto;
import com.react.boardback.dto.response.search.GetRelationListResponseDto;

public interface SearchService {
    ResponseEntity<? super GetPopularListResponseDto> getPopularList();
    ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord);
}

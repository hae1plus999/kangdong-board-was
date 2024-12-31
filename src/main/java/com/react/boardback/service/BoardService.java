package com.react.boardback.service;

import org.springframework.http.ResponseEntity;

import com.react.boardback.dto.request.board.PatchBoardRequestDto;
import com.react.boardback.dto.request.board.PostBoardRequestDto;
import com.react.boardback.dto.request.board.PostCommentRequestDto;
import com.react.boardback.dto.response.board.GetBoardResponseDto;
import com.react.boardback.dto.response.board.PostBoardResponseDto;
import com.react.boardback.dto.response.board.PostCommentResponseDto;
import com.react.boardback.dto.response.board.PutFavoriteResponseDto;
import com.react.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.react.boardback.dto.response.board.GetCommentListResponseDto;
import com.react.boardback.dto.response.board.IncreaseViewCountResponseDto;
import com.react.boardback.dto.response.board.PatchBoardResponseDto;
import com.react.boardback.dto.response.board.DeleteBoardResponseDto;
import com.react.boardback.dto.response.board.GetLatestBoardListResponseDto;
import com.react.boardback.dto.response.board.GetSearchBoardListResponseDto;
import com.react.boardback.dto.response.board.GetTop3BoardListResponseDto;
import com.react.boardback.dto.response.board.GetUserBoardListResponseDto;

public interface BoardService {
    ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);
    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchWord, String preSearchWord);
    ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PostCommentResponseDto> PostComment(PostCommentRequestDto dto, Integer boardNumber, String email);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);
    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumber, String email);
    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);
}

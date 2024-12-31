package com.react.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.react.boardback.common.ResponseCode;
import com.react.boardback.common.ResponseMessage;
import com.react.boardback.dto.object.BoardListItem;
import com.react.boardback.dto.response.ResponseDto;
import com.react.boardback.entity.BoardListViewEntity;

import lombok.Getter;

@Getter
public class GetTop3BoardListResponseDto extends ResponseDto{
    
    private List<BoardListItem> top3List;

    private GetTop3BoardListResponseDto(List<BoardListViewEntity> boardListViewEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.top3List = BoardListItem.getList(boardListViewEntities);
    }
    
    public static ResponseEntity<GetTop3BoardListResponseDto> success(List<BoardListViewEntity> boardEntities) {
        GetTop3BoardListResponseDto result = new GetTop3BoardListResponseDto(boardEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } 
}

package com.react.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.react.boardback.entity.BoardEntity;
import com.react.boardback.repository.resultSet.GetBoardResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    boolean existsByBoardNumber(Integer boardNumber);

    BoardEntity findByBoardNumber(Integer boardNumber);

    @Query(
        value = 
        "SELECT " + 
        "B.board_number as boardNumber " +
        ", B.title as title " +
        ", B.content as content " +
        ", B.write_datetime as writeDatetime " +
        ", B.writer_email as writerEmail " +
        ", U.nickname as writerNickname " +
        ", U.profile_image as writerProfileImage " +
        "FROM board AS B " +
        "INNER JOIN `user` AS U " +
        "ON b.writer_email = U.email " +
        "WHERE board_number = ?1 ",
        nativeQuery = true
    )
    GetBoardResultSet getBoard(Integer boardNumber);
}

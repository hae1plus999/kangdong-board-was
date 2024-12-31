package com.react.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.react.boardback.entity.CommentEntity;
import com.react.boardback.repository.resultSet.GetCommentListResultSet;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{

    @Query(
        value = 
        "SELECT " +
        "   U.nickname " + 
        "   , U.profile_image AS profileImage " +
        "   , C.write_datetime AS writeDatetime " +
        "   , C.content " +
        "FROM comment as C " +
        "INNER JOIN `user` as U " +
        "ON C.user_email = U.email " +
        "WHERE C.board_number = ?1 " +
        "ORDER BY write_datetime DESC ",
        nativeQuery = true
    )
    List<GetCommentListResultSet> getCommentList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}

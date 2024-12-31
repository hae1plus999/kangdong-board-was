package com.react.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.react.boardback.entity.FavoriteEntity;
import com.react.boardback.entity.primaryKey.FavoritePk;
import com.react.boardback.repository.resultSet.GetFavoriteListResultSet;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<FavoriteEntity, FavoritePk> {

    FavoriteEntity findByBoardNumberAndUserEmail(Integer boardNumber, String userEmail);
    
    @Query(
        value = 
        "SELECT " +
        "   U.email AS email " + 
        "   , U.nickname AS nickname " +
        "   , U.profile_image AS profileImage " +
        "FROM favorite as F " +
        "INNER JOIN `user` as U " +
        "ON F.user_email = U.email " +
        "WHERE F.board_number = ?1",
        nativeQuery = true
    )
    List<GetFavoriteListResultSet> getFavoriteList(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}

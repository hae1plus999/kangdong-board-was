package com.react.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.react.boardback.entity.SearchLogEntity;
import com.react.boardback.repository.resultSet.GetPopularListResultSet;
import com.react.boardback.repository.resultSet.GetRelationListResultSet;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLogEntity, Integer> {
    
    @Query(
        value = 
        "SELECT search_word as searchWord, COUNT(search_word) as count " +
        "FROM search_log " +
        "WHERE relation is FALSE " +
        "GROUP BY search_word " +
        "ORDER BY count DESC " +
        "LIMIT 15 ",
        nativeQuery=true
    )
    List<GetPopularListResultSet> getPopularList();

    @Query(
        value = 
        "SELECT relation_word as searchWord, COUNT(relation_word) as count " +
        "FROM search_log " +
        "WHERE search_word = ?1 " +
        // "AND relation_word IS NOT NULL" + 
        "GROUP BY relation_word " +
        "ORDER BY count DESC " +
        "LIMIT 15 ",
        nativeQuery=true
    )
    List<GetRelationListResultSet> getRelationList(String searchWord);
}

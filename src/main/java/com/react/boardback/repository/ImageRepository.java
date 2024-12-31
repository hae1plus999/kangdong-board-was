package com.react.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.react.boardback.entity.ImageEntity;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
 
    List<ImageEntity> findByBoardNumber(Integer boardNumber);

    @Transactional
    void deleteByBoardNumber(Integer boardNumber);
}

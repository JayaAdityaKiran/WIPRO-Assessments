package com.example.repository;

import com.example.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    
    List<Like> findByAnswerId(Long answerId);
    
    Optional<Like> findByUserIdAndAnswerId(Long userId, Long answerId);
    
    Long countByAnswerId(Long answerId);
    
    void deleteByUserIdAndAnswerId(Long userId, Long answerId);
    
    boolean existsByUserIdAndAnswerId(Long userId, Long answerId);
}

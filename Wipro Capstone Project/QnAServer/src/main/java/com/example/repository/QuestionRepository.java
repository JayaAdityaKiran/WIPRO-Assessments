package com.example.repository;

import com.example.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    List<Question> findByApprovedTrue();
    
    List<Question> findByApprovedFalse();
    
    List<Question> findByUserId(Long userId);
    
    List<Question> findByStatus(String status);
    
    List<Question> findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(String title, String body);
    
    List<Question> findByTagsContainingIgnoreCase(String tag);
}

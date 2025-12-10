package com.example.repository;

import com.example.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
    List<Answer> findByQuestionId(Long questionId);
    
    List<Answer> findByQuestionIdAndApprovedTrue(Long questionId);
    
    List<Answer> findByUserId(Long userId);
    
    List<Answer> findByApprovedFalse();
    
    Long countByQuestionIdAndApprovedTrue(Long questionId);
}

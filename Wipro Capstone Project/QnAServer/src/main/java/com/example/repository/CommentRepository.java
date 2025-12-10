package com.example.repository;

import com.example.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    List<Comment> findByQuestionId(Long questionId);
    
    List<Comment> findByAnswerId(Long answerId);
    
    List<Comment> findByParentCommentId(Long parentId);
    
    List<Comment> findByQuestionIdAndApprovedTrue(Long questionId);
    
    List<Comment> findByAnswerIdAndApprovedTrue(Long answerId);
    
    List<Comment> findByApprovedFalse();
}

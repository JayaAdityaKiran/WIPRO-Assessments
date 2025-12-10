package com.example.service;

import com.example.client.EmailClient;
import com.example.dto.*;
import com.example.exception.*;
import com.example.model.*;
import com.example.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionService {
    
    private final QuestionRepository questionRepo;
    private final AnswerRepository answerRepo;
    private final CommentRepository commentRepo;
    private final LikeRepository likeRepo;
    private final EmailClient emailClient;
    
    public QuestionService(QuestionRepository questionRepo,
                          AnswerRepository answerRepo,
                          CommentRepository commentRepo,
                          LikeRepository likeRepo,
                          EmailClient emailClient) {
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
        this.commentRepo = commentRepo;
        this.likeRepo = likeRepo;
        this.emailClient = emailClient;
    }
    
    // ========== QUESTION OPERATIONS ==========
    
    @Transactional
    public Question createQuestion(QuestionRequest req) {
        Question question = Question.builder()
                .userId(req.getUserId())
                .title(req.getTitle())
                .body(req.getBody())
                .tags(req.getTags())
                .createdAt(LocalDateTime.now())
                .approved(false)
                .status("OPEN")
                .build();
        
        Question saved = questionRepo.save(question);
        
        // Notify admin via email
        notifyAdminNewQuestion(saved);
        
        return saved;
    }
    
    public List<Question> getAllApprovedQuestions() {
        return questionRepo.findByApprovedTrue();
    }
    
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
    
    public Question getQuestionById(Long id) {
        return questionRepo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));
    }
    
    public List<Question> searchQuestions(String keyword) {
        return questionRepo.findByTitleContainingIgnoreCaseOrBodyContainingIgnoreCase(keyword, keyword);
    }
    
    public List<Question> getQuestionsByTag(String tag) {
        return questionRepo.findByTagsContainingIgnoreCase(tag);
    }
    
    public List<Question> getQuestionsByUser(Long userId) {
        return questionRepo.findByUserId(userId);
    }
    
    public List<Question> getPendingQuestions() {
        return questionRepo.findByApprovedFalse();
    }
    
    @Transactional
    public String approveQuestion(Long id) {
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));
        question.setApproved(true);
        questionRepo.save(question);
        return "QUESTION_APPROVED";
    }
    
    @Transactional
    public String deleteQuestion(Long id) {
        if (!questionRepo.existsById(id)) {
            throw new QuestionNotFoundException("Question not found");
        }
        questionRepo.deleteById(id);
        return "QUESTION_DELETED";
    }
    
    @Transactional
    public String closeThread(Long id) {
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));
        question.setStatus("CLOSED");
        questionRepo.save(question);
        return "THREAD_CLOSED";
    }
    
    @Transactional
    public String markResolved(Long id) {
        Question question = questionRepo.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));
        question.setStatus("RESOLVED");
        questionRepo.save(question);
        return "MARKED_RESOLVED";
    }
    
    // ========== ANSWER OPERATIONS ==========
    
    @Transactional
    public Answer addAnswer(AnswerRequest req) {
        // Check if question exists and is open
        Question question = questionRepo.findById(req.getQuestionId())
                .orElseThrow(() -> new QuestionNotFoundException("Question not found"));
        
        if ("CLOSED".equals(question.getStatus())) {
            throw new RuntimeException("Cannot answer closed question");
        }
        
        Answer answer = Answer.builder()
                .questionId(req.getQuestionId())
                .userId(req.getUserId())
                .body(req.getBody())
                .createdAt(LocalDateTime.now())
                .approved(false)
                .likes(0)
                .build();
        
        Answer saved = answerRepo.save(answer);
        
        // Notify admin via email
        notifyAdminNewAnswer(saved, question);
        
        return saved;
    }
    
    public List<Answer> getAnswersByQuestion(Long questionId, boolean includeUnapproved) {
        if (includeUnapproved) {
            return answerRepo.findByQuestionId(questionId);
        }
        return answerRepo.findByQuestionIdAndApprovedTrue(questionId);
    }
    
    public Answer getAnswerById(Long id) {
        return answerRepo.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException("Answer not found"));
    }
    
    public List<Answer> getPendingAnswers() {
        return answerRepo.findByApprovedFalse();
    }
    
    @Transactional
    public String approveAnswer(Long id) {
        Answer answer = answerRepo.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException("Answer not found"));
        answer.setApproved(true);
        answerRepo.save(answer);
        return "ANSWER_APPROVED";
    }
    
    @Transactional
    public String deleteAnswer(Long id) {
        if (!answerRepo.existsById(id)) {
            throw new AnswerNotFoundException("Answer not found");
        }
        answerRepo.deleteById(id);
        return "ANSWER_DELETED";
    }
    
    // ========== COMMENT OPERATIONS ==========
    
    @Transactional
    public Comment addComment(CommentRequest req) {
        Comment comment = Comment.builder()
                .userId(req.getUserId())
                .body(req.getBody())
                .questionId(req.getQuestionId())
                .answerId(req.getAnswerId())
                .parentCommentId(req.getParentCommentId())
                .createdAt(LocalDateTime.now())
                .approved(true) // Auto-approve comments (can change to false)
                .build();
        
        return commentRepo.save(comment);
    }
    
    public List<Comment> getCommentsByQuestion(Long questionId, boolean includeUnapproved) {
        if (includeUnapproved) {
            return commentRepo.findByQuestionId(questionId);
        }
        return commentRepo.findByQuestionIdAndApprovedTrue(questionId);
    }
    
    public List<Comment> getCommentsByAnswer(Long answerId, boolean includeUnapproved) {
        if (includeUnapproved) {
            return commentRepo.findByAnswerId(answerId);
        }
        return commentRepo.findByAnswerIdAndApprovedTrue(answerId);
    }
    
    public List<Comment> getReplies(Long parentCommentId) {
        return commentRepo.findByParentCommentId(parentCommentId);
    }
    
    @Transactional
    public String deleteComment(Long id) {
        if (!commentRepo.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepo.deleteById(id);
        return "COMMENT_DELETED";
    }
    
    // ========== LIKE OPERATIONS ==========
    
    @Transactional
    public String toggleLike(Long userId, Long answerId) {
        if (likeRepo.existsByUserIdAndAnswerId(userId, answerId)) {
            // Unlike
            likeRepo.deleteByUserIdAndAnswerId(userId, answerId);
            
            // Decrement like count
            Answer answer = answerRepo.findById(answerId)
                    .orElseThrow(() -> new AnswerNotFoundException("Answer not found"));
            answer.setLikes(Math.max(0, answer.getLikes() - 1));
            answerRepo.save(answer);
            
            return "UNLIKED";
        } else {
            // Like
            Like like = Like.builder()
                    .userId(userId)
                    .answerId(answerId)
                    .createdAt(LocalDateTime.now())
                    .build();
            likeRepo.save(like);
            
            // Increment like count
            Answer answer = answerRepo.findById(answerId)
                    .orElseThrow(() -> new AnswerNotFoundException("Answer not found"));
            answer.setLikes(answer.getLikes() + 1);
            answerRepo.save(answer);
            
            return "LIKED";
        }
    }
    
    public Long getLikeCount(Long answerId) {
        return likeRepo.countByAnswerId(answerId);
    }
    
    public boolean hasUserLiked(Long userId, Long answerId) {
        return likeRepo.existsByUserIdAndAnswerId(userId, answerId);
    }
    
    // ========== EMAIL NOTIFICATIONS ==========
    
    private void notifyAdminNewQuestion(Question question) {
        try {
            MailRequest mail = new MailRequest();
            mail.setTo("admin@doconnect.com");
            mail.setSubject("DoConnect - New Question Pending Approval");
            mail.setBodyHtml("<h2>New Question Posted</h2>" +
                           "<p><strong>Title:</strong> " + question.getTitle() + "</p>" +
                           "<p><strong>By User ID:</strong> " + question.getUserId() + "</p>" +
                           "<p><strong>Tags:</strong> " + question.getTags() + "</p>" +
                           "<p>Please login to admin panel to approve.</p>");
            emailClient.sendMail(mail);
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
    
    private void notifyAdminNewAnswer(Answer answer, Question question) {
        try {
            MailRequest mail = new MailRequest();
            mail.setTo("admin@doconnect.com");
            mail.setSubject("DoConnect - New Answer Pending Approval");
            mail.setBodyHtml("<h2>New Answer Posted</h2>" +
                           "<p><strong>Question:</strong> " + question.getTitle() + "</p>" +
                           "<p><strong>By User ID:</strong> " + answer.getUserId() + "</p>" +
                           "<p>Please login to admin panel to approve.</p>");
            emailClient.sendMail(mail);
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}

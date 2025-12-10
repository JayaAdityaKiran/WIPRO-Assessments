package com.example.repository;

import com.example.model.AdminPasswordToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AdminPasswordTokenRepository extends JpaRepository<AdminPasswordToken, Long> {
    Optional<AdminPasswordToken> findByEmailAndOtpAndUsedFalse(String email, String otp);
    void deleteByEmail(String email);
    void deleteByExpiryTimeBefore(LocalDateTime dateTime);
}

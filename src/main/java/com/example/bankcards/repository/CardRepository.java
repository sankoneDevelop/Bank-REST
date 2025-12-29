package com.example.bankcards.repository;

import com.example.bankcards.entity.Card;
import com.example.bankcards.entity.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByOwnerId(Long userId);

    Optional<Card> findByIdAndOwnerId(Long cardId, Long userId);

    List<Card> findByStatus(CardStatus status);

    List<Card> findByOwnerIdAndStatus(Long userId, CardStatus status);
}

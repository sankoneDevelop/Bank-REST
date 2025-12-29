package com.example.bankcards.repository;

import com.example.bankcards.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

    List<Transfer> findByFromCardId(Long cardId);

    List<Transfer> findByToCardId(Long cardId);

    List<Transfer> findByFromCardIdOrToCardId(Long fromCardId, Long toCardId);
}

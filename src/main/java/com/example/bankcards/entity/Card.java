package com.example.bankcards.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumberEncrypted;
    private String lastFourDigits;
    private LocalDate expirationDate;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    private BigDecimal balance;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "fromCard", cascade = CascadeType.ALL)
    private Set<Transfer> transfersFrom = new HashSet<>();

    @OneToMany(mappedBy = "toCard", cascade = CascadeType.ALL)
    private Set<Transfer> transfersTo = new HashSet<>();


}

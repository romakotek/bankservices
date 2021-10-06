package com.example.bankservices.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal creditAmount;
    private BigDecimal remainingAmount;
    private Integer termInMonths;
    private LocalDateTime startDateTime;
    private BigDecimal yearlyInterest;



}

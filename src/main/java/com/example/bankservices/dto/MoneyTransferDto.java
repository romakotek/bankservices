package com.example.bankservices.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MoneyTransferDto {

    private Long sendAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;
}
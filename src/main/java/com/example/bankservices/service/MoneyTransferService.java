package com.example.bankservices.service;

import com.example.bankservices.dto.MoneyTransferDto;
import com.example.bankservices.exception.NoBankAccountException;

public interface MoneyTransferService {

    public String transfer(MoneyTransferDto moneyTransferDto) throws NoBankAccountException;
}
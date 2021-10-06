package com.example.bankservices.controller;

import com.example.bankservices.dto.MoneyTransferDto;
import com.example.bankservices.exception.NoBankAccountException;
import com.example.bankservices.service.MoneyTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MoneyTransferController {

    private final MoneyTransferService moneyTransferService;

    @PostMapping("v1/transfer")
    public String transfer(@RequestBody MoneyTransferDto moneyTransferDto) throws NoBankAccountException {
        return moneyTransferService.transfer(moneyTransferDto);
    }

}


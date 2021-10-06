package com.example.bankservices.service;

import com.example.bankservices.dto.MoneyTransferDto;
import com.example.bankservices.exception.NoBankAccountException;
import com.example.bankservices.model.BankAccount;
import com.example.bankservices.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MoneyTransferServiceImpl implements MoneyTransferService {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public String transfer(MoneyTransferDto moneyTransferDto) throws NoBankAccountException {
        Optional<BankAccount> senderAccountOptional = bankAccountRepository
                .findById(moneyTransferDto.getSendAccountId());
        Optional<BankAccount> receiverAccountOptional = bankAccountRepository
                .findById(moneyTransferDto.getReceiverAccountId());

        if (hasAccountsPresent(senderAccountOptional, receiverAccountOptional)) {
            BankAccount receiverAccount = receiverAccountOptional.get();
            BankAccount senderAccount = senderAccountOptional.get();
            BigDecimal transferAmount = moneyTransferDto.getAmount();
            if (isEnoughMoney(senderAccount, transferAmount)) {
                senderAccount.setBalance(senderAccount.getBalance().subtract(transferAmount));
                bankAccountRepository.save(senderAccount);

                receiverAccount.setBalance(receiverAccount.getBalance().add(transferAmount));
                bankAccountRepository.save(receiverAccount);
                return "OK";
            }
        }
        throw new NoBankAccountException("No such account found");
    }

    private boolean isEnoughMoney(BankAccount senderAccount, BigDecimal transferAmount) {
        return senderAccount.getBalance().compareTo(transferAmount) >= 0;
    }

    private boolean hasAccountsPresent(Optional<BankAccount> senderAccountOptional,
                                       Optional<BankAccount> receiverAccountOptional) {
        return senderAccountOptional.isPresent() && receiverAccountOptional.isPresent();
    }
}

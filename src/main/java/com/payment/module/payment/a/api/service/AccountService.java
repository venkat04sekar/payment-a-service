package com.payment.module.payment.a.api.service;

import com.payment.module.payment.a.api.dao.AccountDao;
import com.payment.module.payment.a.api.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountRepo;

    public Account updateAccountDetail(Account paymentDetail){
        Account account =  accountRepo.findByAccountId(paymentDetail.getAccountId());
        int currentBalanceAmount = 0;
        if(null != account)
            currentBalanceAmount = account.getBalanceAmount();
        if(paymentDetail.getTransactionAmount()>0 || (paymentDetail.getTransactionAmount()<0 &&
                currentBalanceAmount>=Math.abs(paymentDetail.getTransactionAmount()) )){
            int updatedAmont = currentBalanceAmount+paymentDetail.getTransactionAmount();
            account.setBalanceAmount(updatedAmont);
            return accountRepo.save(account);
        }
        else{
            throw new RuntimeException("Cannot debit transaction amount since no sufficient balance in account");
        }

    }

    public int getCurrentBalance(int accountId) {
        Account accountDetail = accountRepo.findByAccountId(accountId);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(null != accountDetail){
            return accountDetail.getBalanceAmount();
        }
        else{
            throw new RuntimeException("Invalid Account Id");
        }
    }

    public Account createAccount(Account account) {
        return accountRepo.save(account);
    }
}

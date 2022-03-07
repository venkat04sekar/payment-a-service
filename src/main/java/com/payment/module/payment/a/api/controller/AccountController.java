package com.payment.module.payment.a.api.controller;

import com.payment.module.payment.a.api.entity.Account;
import com.payment.module.payment.a.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/savings/a")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PostMapping("/balance")
    public Account updateAccountBalance(@RequestBody Account paymentDetail){
        return accountService.updateAccountDetail(paymentDetail);
    }

    @GetMapping("/balance/{accountId}")
    public ResponseEntity<Integer> getCurrentBalance(@PathVariable(value = "accountId") int accountId ){
        return new ResponseEntity<Integer>(accountService.getCurrentBalance(accountId), HttpStatus.OK);



    }
}

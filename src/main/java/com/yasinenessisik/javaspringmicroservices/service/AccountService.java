package com.yasinenessisik.javaspringmicroservices.service;

import com.yasinenessisik.javaspringmicroservices.entity.Account;
import com.yasinenessisik.javaspringmicroservices.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account get(String id){
    return accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
    }
    public Account save(Account account){
        return accountRepository.save(account);
    }
    public Account update(String id,Account account){
        Assert.isNull(id,"Id cannot be null");

        return accountRepository.save(account);
    }
    public void delete(String id){

    }
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

}

package com.yasinenessisik.javaspringmicroservices.controller;

import com.yasinenessisik.javaspringmicroservices.entity.Account;
import com.yasinenessisik.javaspringmicroservices.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/account")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id){
        return ResponseEntity.ok(accountService.get(id));
    }
    @PostMapping
        public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }
    @PutMapping
    public ResponseEntity<Account> update(@PathVariable("id")String id,@RequestBody Account account){
        return ResponseEntity.ok(accountService.update(id,account));
    }
    @DeleteMapping
    public void delete(String id){
        accountService.delete(id);
    }

    @GetMapping()
    public List<Account> findAll(){
        return accountService.findAll();
    }

}

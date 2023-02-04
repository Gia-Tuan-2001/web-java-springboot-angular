package com.example.backend.services.account;

import com.example.backend.entities.Account;
import com.example.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account login(String user_name, String password) {
        for (Account a : accountRepository.findAll()) {
            System.out.println(a.getUser_name());
            if (a.getUser_name().equals(user_name) && a.getPassword().toString().equals(password.toString())) {
                return a;
            }
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public boolean deleteOne(int id) {
        Account acc = findById(id);
        if (acc != null) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}

package com.example.desafio_picpay.services;

import com.example.desafio_picpay.domain.user.User;
import com.example.desafio_picpay.domain.user.UserType;
import com.example.desafio_picpay.dtos.UserDTO;
import com.example.desafio_picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void ValidateTransaction(User sender, BigDecimal amount ) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT){
            throw  new Exception("Usuario tipo logista não está autorizado a realizar essa operação!");
        }

        if (sender.getBalance().compareTo(amount) < 0){
            throw  new Exception("Saldo insulficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        return  this.repository.findUserById(id).orElseThrow(()-> new Exception("Usuario não encontrado"));
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveuser(newUser);
        return newUser;
    }

    public List<User> getAllUser(){

        return this.repository.findAll();
    }
    public void saveuser(User user){

        this.repository.save(user);
    }

    public void validateTransaction(User sender, BigDecimal value) {
    }
}

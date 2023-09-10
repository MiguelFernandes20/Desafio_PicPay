package com.example.desafio_picpay.domain.repositories;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
   Optional <User> findUserByDocument(String document);

   Optional <User> findUserById(Long id);
}

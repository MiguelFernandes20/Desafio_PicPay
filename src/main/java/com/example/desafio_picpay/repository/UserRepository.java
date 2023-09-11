package com.example.desafio_picpay.repository;
import com.example.desafio_picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional <User> findUserByDocument(String document);
    Optional <User> findUserById(Long id);
}


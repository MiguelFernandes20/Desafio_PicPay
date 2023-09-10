package com.example.desafio_picpay.domain.repositories;

import com.example.desafio_picpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

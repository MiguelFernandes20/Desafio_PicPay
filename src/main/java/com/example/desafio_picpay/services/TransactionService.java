package com.example.desafio_picpay.services;

import com.example.desafio_picpay.domain.transaction.Transaction;
import com.example.desafio_picpay.domain.user.User;
import com.example.desafio_picpay.dtos.TransactionDTO;
import com.example.desafio_picpay.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NotificationService notification;

    public Transaction createTransaction(TransactionDTO transaction) throws Exception {
        User sender = this.userService.findUserById(transaction.senderId());
        User receiver = this.userService.findUserById(transaction.receiverId());

        userService.ValidateTransaction(sender, transaction.value());

        boolean isAuthorized = this.autowireTransaction(sender, transaction.value());
        if (isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        Transaction newtransaction = new Transaction();
        newtransaction.setAmount(transaction.value());
        newtransaction.setSender(sender);
        newtransaction.setReceiver(receiver);
        newtransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        this.repository.save(newtransaction);
        this.userService.saveuser(sender);
        this.userService.saveuser(receiver);

        this.notification.sendNotification(sender, "Transação realizada com sucesso. ");
        this.notification.sendNotification(receiver, "Transação recebida com sucesso. ");

        return newtransaction;
    }

    public boolean autowireTransaction(User sender, BigDecimal value){
       ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6",Map.class);

       if (authorizationResponse.getStatusCode() == HttpStatus.OK){
               String massage = (String) authorizationResponse.getBody().get("message");
               return ("Autorizado".equalsIgnoreCase(massage));
           }else return false;
        }

}

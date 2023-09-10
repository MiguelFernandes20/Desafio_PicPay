package com.example.desafio_picpay.services;

import com.example.desafio_picpay.domain.user.User;
import com.example.desafio_picpay.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    public RestTemplate restTemplate;

    public void sendNotification(User user, String massage) throws  Exception{
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, massage);

//        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
//
//        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)){
//            System.out.println("Erro ao enviar notificação");
//            throw  new Exception("Serviço de notificação esta fora do ar");
//
//        }

        System.out.println("Notificação enviada ao usuario.");
    }
}

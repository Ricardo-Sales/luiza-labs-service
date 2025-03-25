package com.luiza.labs.controller;

import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.bussiness.ComunicationBussiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comunication")
public class ComunicationController {

    @Autowired
    private ComunicationBussiness comunicationBussiness;

    @PostMapping
    public ResponseEntity<?> sendNotification(
            @RequestBody NotificationResquestDTO notification){
        return ResponseEntity.ok(comunicationBussiness.sendNotification(notification));
    }
}

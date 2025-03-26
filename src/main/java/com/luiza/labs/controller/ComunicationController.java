package com.luiza.labs.controller;

import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.bussiness.ComunicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comunication")
public class ComunicationController {

    @Autowired
    private ComunicationServiceImpl comunicationService;

    @PostMapping("/create")
    public ResponseEntity<?> sendNotification(
            @RequestBody NotificationResquestDTO notification){
        return ResponseEntity.ok(comunicationService.sendNotification(notification));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNotification(
            @RequestBody NotificationResquestDTO notification,
            @PathVariable(name = "id") Long notificationId) {
        return ResponseEntity.ok(comunicationService.updateNotification(notificationId, notification));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findNotification(
            @PathVariable(name = "id") Long notificationId) {
        return ResponseEntity.ok(comunicationService.findNotification(notificationId));
    }

    @GetMapping("/")
    public ResponseEntity<?> findAllNotification() {
        return ResponseEntity.ok(comunicationService.findAllNotification());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotification(
            @PathVariable(name = "id") Long notificationId
    ) {
        return ResponseEntity.ok(comunicationService.deleteNotification(notificationId));
    }
}

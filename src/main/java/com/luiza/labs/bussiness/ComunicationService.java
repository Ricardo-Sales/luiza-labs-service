package com.luiza.labs.bussiness;

import com.luiza.labs.DTO.NotificationResquestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComunicationService {

    ResponseEntity<?> sendNotification(NotificationResquestDTO notification);

    ResponseEntity<?> updateNotification(Long notificationId, NotificationResquestDTO notification);

    ResponseEntity<?> findNotification(Long notificationId);

    ResponseEntity<List<?>> findAllNotification();

    ResponseEntity<?> deleteNotification(Long notificationId);

}

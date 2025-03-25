package com.luiza.labs.bussiness;


import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;
import com.luiza.labs.mappers.NotificationMapper;
import com.luiza.labs.repository.ComunicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ComunicationBussiness {

    @Autowired
    private ComunicationRepository comunicationRepository;

    public ResponseEntity<?> sendNotification(NotificationResquestDTO notification){
        ComunicationEntity notificationEntity = NotificationMapper.toEntity(notification);
        return ResponseEntity.ok(comunicationRepository.save((notificationEntity)));
    }
}

package com.luiza.labs.bussiness;


import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;
import com.luiza.labs.mappers.NotificationMapper;
import com.luiza.labs.repository.ComunicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComunicationServiceImpl implements ComunicationService {

    @Autowired
    private ComunicationRepository comunicationRepository;

    public ResponseEntity<?> sendNotification(NotificationResquestDTO notification){
        ComunicationEntity notificationEntity = NotificationMapper.toEntity(null, notification);
        return ResponseEntity.ok(comunicationRepository.save((notificationEntity)));
    }

    public ResponseEntity<?> updateNotification(Long notificationId, NotificationResquestDTO notification){
        ComunicationEntity notificationEntity = NotificationMapper.toEntity(notificationId, notification);
        return ResponseEntity.ok(comunicationRepository.save((notificationEntity)));
    }

    @Override
    public ResponseEntity<?> findNotification(Long notificationId) {
        return ResponseEntity.ok(comunicationRepository.findById((notificationId)));
    }

    @Override
    public ResponseEntity<List<?>> findAllNotification() {
        return ResponseEntity.ok(comunicationRepository.findAll());
    }

    @Override
    public ResponseEntity<?> deleteNotification(Long notificationId) {
        comunicationRepository.deleteById(notificationId);
        return ResponseEntity.noContent().build();
    }
}

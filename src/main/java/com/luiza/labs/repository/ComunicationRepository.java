package com.luiza.labs.repository;

import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface ComunicationRepository extends JpaRepository<ComunicationEntity, Long> {

     public ResponseEntity<?> saveNotification(NotificationResquestDTO notification);

}

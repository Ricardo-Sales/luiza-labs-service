package com.luiza.labs.controller;

import com.luiza.labs.DTO.ComunicationResponseDTO;
import com.luiza.labs.DTO.ComunicationResquestDTO;
import com.luiza.labs.bussiness.ComunicationServiceImpl;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comunication")
public class ComunicationController {

    @Autowired
    private ComunicationServiceImpl comunicationService;

    @PostMapping("/create")
    public ResponseEntity<?> sendNotification(
            @RequestBody ComunicationResquestDTO notification) throws BadRequestException {
        comunicationService.saveComunication(notification);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNotification(
            @RequestBody ComunicationResquestDTO comunication,
            @PathVariable(name = "id") Long comunicationId) throws BadRequestException {
        comunicationService.updateComunication(comunicationId, comunication);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findNotification(
            @PathVariable(name = "id") Long comunicationId) {
        return ResponseEntity.ok(comunicationService.findNotification(comunicationId));
    }

    @GetMapping("/")
    public ResponseEntity<List<ComunicationResponseDTO>> findAllNotification() {
        return ResponseEntity.ok(comunicationService.findAllComunication());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotification(
            @PathVariable(name = "id") Long comunicationId
    ) {
        comunicationService.deleteComunication(comunicationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

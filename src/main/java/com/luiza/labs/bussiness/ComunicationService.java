package com.luiza.labs.bussiness;

import com.luiza.labs.DTO.ComunicationResponseDTO;
import com.luiza.labs.DTO.ComunicationResquestDTO;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComunicationService {

    void saveComunication(ComunicationResquestDTO notification) throws BadRequestException;

    void updateComunication(Long notificationId, ComunicationResquestDTO notification) throws BadRequestException;

    ComunicationResponseDTO findNotification(Long notificationId);

    List<ComunicationResponseDTO> findAllComunication();

    void deleteComunication(Long notificationId);

}

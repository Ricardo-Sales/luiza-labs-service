package com.luiza.labs.mappers;

import com.luiza.labs.DTO.ComunicationResponseDTO;
import com.luiza.labs.DTO.ComunicationResquestDTO;
import com.luiza.labs.DTO.DestinatarioDTO;
import com.luiza.labs.entity.ComunicationEntity;

public class ComunicationMapper {
    public static ComunicationEntity toEntity(Long notificationId, ComunicationResquestDTO notificationRequest) {
        return new ComunicationEntity(
                notificationId,
                notificationRequest.getDataEnvio(),
                notificationRequest.getDestinatario().getNome(),
                notificationRequest.getDestinatario().getEmail(),
                notificationRequest.getDestinatario().getTelefone(),
                notificationRequest.getMensagem(),
                notificationRequest.getTipoComunicacao(),
                notificationRequest.getCreatedAt(),
                notificationRequest.getUpdatedAt()
        );
    }

    public static ComunicationResponseDTO toResponse(ComunicationEntity comunication) {
        DestinatarioDTO destinatario = new DestinatarioDTO(
                comunication.getNome(),
                comunication.getEmail(),
                comunication.getTelefone()
        );

        return new ComunicationResponseDTO(
                comunication.getId(),
                comunication.getDataEnvio(),
                destinatario,
                comunication.getMensagem(),
                comunication.getTipoComunicacao(),
                comunication.getCreatedAt(),
                comunication.getUpdatedAt()
        );
    }


}

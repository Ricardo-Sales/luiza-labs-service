package com.luiza.labs.mappers;

import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;

public class NotificationMapper {
    public static ComunicationEntity toEntity(Long notificationId, NotificationResquestDTO notificationRequest) {
        return new ComunicationEntity(
                notificationId,
                notificationRequest.getDataEnvio(),
                notificationRequest.getDestinatario().getNome(),
                notificationRequest.getDestinatario().getEmail(),
                notificationRequest.getDestinatario().getTelefone(),
                notificationRequest.getMensagem()
        );
    }
}

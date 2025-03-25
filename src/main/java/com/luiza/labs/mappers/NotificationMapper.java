package com.luiza.labs.mappers;

import com.luiza.labs.DTO.NotificationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;

public class NotificationMapper {
    public static ComunicationEntity toEntity(NotificationResquestDTO notificationRequest) {
        return new ComunicationEntity(
                notificationRequest.getDataEnvio(),
                notificationRequest.getDestinatario(),
                notificationRequest.getMensagem()
        );
    }
}

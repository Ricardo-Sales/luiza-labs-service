package com.luiza.labs.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResquestDTO {
    private String dataEnvio;
    private DestinatarioDTO destinatario;
    private String mensagem;
    private String tipoComunicacao;
}

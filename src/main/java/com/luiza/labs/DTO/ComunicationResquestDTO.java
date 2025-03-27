package com.luiza.labs.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ComunicationResquestDTO {
    private LocalDateTime dataEnvio;
    private DestinatarioDTO destinatario;
    private String mensagem;
    private String tipoComunicacao;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

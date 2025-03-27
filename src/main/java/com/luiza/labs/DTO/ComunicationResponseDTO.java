package com.luiza.labs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComunicationResponseDTO {

    private Long id;
    private LocalDateTime dataEnvio;
    private DestinatarioDTO destinatario;
    private String mensagem;
    private String tipoComunicacao;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

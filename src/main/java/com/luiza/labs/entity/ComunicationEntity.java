package com.luiza.labs.entity;

import com.luiza.labs.DTO.DestinatarioDTO;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ComunicationEntity {
    private String dataEnvio;
    private DestinatarioDTO destinatario;
    private String mensagem;
}

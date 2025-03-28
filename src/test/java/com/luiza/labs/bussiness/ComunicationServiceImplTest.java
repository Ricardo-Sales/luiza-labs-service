package com.luiza.labs.bussiness;


import com.luiza.labs.DTO.ComunicationResquestDTO;
import com.luiza.labs.DTO.DestinatarioDTO;
import com.luiza.labs.entity.ComunicationEntity;
import com.luiza.labs.repository.ComunicationRepository;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@Service
public class ComunicationServiceImplTest{

    @Mock
    ComunicationRepository comunicationRepository;

    @InjectMocks
    @Autowired
    ComunicationServiceImpl comunicationServiceImpl;

    private ComunicationResquestDTO mockComunicationResquestDTO(){
        ComunicationResquestDTO comunicationResquestDTO = new ComunicationResquestDTO();
        DestinatarioDTO destinatarioDTO = new DestinatarioDTO(
                "teste",
                "teste@teste.com",
                "11123456789"
        );

        comunicationResquestDTO.setDataEnvio(LocalDateTime.now());
        comunicationResquestDTO.setDestinatario(destinatarioDTO);
        comunicationResquestDTO.setMensagem("Teste de mensagem");
        comunicationResquestDTO.setTipoComunicacao("SMS");
        return comunicationResquestDTO;
    }
    private ComunicationEntity mockComunicationEntity(){
        ComunicationEntity comunicationEntity = new ComunicationEntity();
        comunicationEntity.setDataEnvio(LocalDateTime.now());
        comunicationEntity.setNome("teste");
        comunicationEntity.setEmail("teste@teste.com");
        comunicationEntity.setTelefone("11123456789");
        comunicationEntity.setMensagem("Teste de mensagem");
        comunicationEntity.setTipoComunicacao("SMS");
        return comunicationEntity;
    }

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveComunicationSuccess() throws BadRequestException {
        ComunicationResquestDTO mockComunication = mockComunicationResquestDTO();

        when(comunicationRepository.save(any())).thenReturn(mockComunicationEntity());

        comunicationServiceImpl.saveComunication(mockComunication);

        Assertions.assertNotNull(mockComunication.getDestinatario());
        Mockito.verify(comunicationRepository, times(1)).save(any());
    }

    @Test
    public void saveComunicationBadRequestTelefone() {
        ComunicationResquestDTO mockComunication = mockComunicationResquestDTO();
        mockComunication.getDestinatario().setTelefone("");

        when(comunicationRepository.save(any())).thenReturn(mockComunicationEntity());

        final BadRequestException errorMessage = assertThrows(BadRequestException.class,
                ()-> comunicationServiceImpl.saveComunication(mockComunication));

        assertEquals(BadRequestException.class, errorMessage.getClass());
        assertEquals("telefone must be 11 characters like 11123456789.", errorMessage.getMessage());
        Mockito.verify(comunicationRepository, times(0)).save(any());
    }


}
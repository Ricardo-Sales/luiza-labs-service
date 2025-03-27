package com.luiza.labs.bussiness;

import com.luiza.labs.DTO.ComunicationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;
import com.luiza.labs.repository.ComunicationRepository;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Service
@ExtendWith(MockitoExtension.class)
class ComunicationServiceImplTest{

    @Mock
    ComunicationRepository comunicationRepository;

    @Mock

    @InjectMocks
    @Autowired
    ComunicationServiceImpl comunicationServiceImpl;


    private ComunicationResquestDTO mockComunicationResquestDTO(){
        ComunicationResquestDTO comunicationResquestDTO = new ComunicationResquestDTO();
        comunicationResquestDTO.setDataEnvio(LocalDateTime.now());
        comunicationResquestDTO.getDestinatario().setNome("teste");
        comunicationResquestDTO.getDestinatario().setEmail("teste@teste.com");
        comunicationResquestDTO.getDestinatario().setTelefone("11123456789");
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
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveComunication() throws BadRequestException {
        ComunicationResquestDTO mockComunication = mockComunicationResquestDTO();
        doNothing().when(comunicationRepository.save(mockComunicationEntity()));

        comunicationServiceImpl.saveComunication(mockComunication);

        Assertions.assertNotNull(mockComunication.getDestinatario());
        verify(comunicationRepository, times(1)).save(any());
    }

}
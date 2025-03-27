package com.luiza.labs.bussiness;


import com.luiza.labs.DTO.ComunicationResponseDTO;
import com.luiza.labs.DTO.ComunicationResquestDTO;
import com.luiza.labs.entity.ComunicationEntity;
import com.luiza.labs.enums.ComunicationTypeEnum;
import com.luiza.labs.mappers.ComunicationMapper;
import com.luiza.labs.repository.ComunicationRepository;
import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.luiza.labs.enums.ComunicationTypeEnum.getComunicationType;

@Service
@Transactional
public class ComunicationServiceImpl implements ComunicationService {

    @Autowired
    private ComunicationRepository comunicationRepository;
    private static final Logger logger = LoggerFactory.getLogger(ComunicationServiceImpl.class);

    public void saveComunication(ComunicationResquestDTO comunication) throws BadRequestException {

        logger.info(String.format("Saving Comunication >> Message: %s", comunication.getMensagem()));



        validateComunicationRequest(comunication);
        comunication.setCreatedAt(LocalDateTime.now());
        ComunicationEntity notificationEntity = ComunicationMapper.toEntity(null, comunication);
        comunicationRepository.save((notificationEntity));
    }

    public void updateComunication(Long notificationId, ComunicationResquestDTO comunication) throws BadRequestException {
        logger.info(String.format("Updating comunication >>  id: %s", notificationId));

        validateComunicationRequest(comunication);
        comunication.setUpdatedAt(LocalDateTime.now());
        ComunicationEntity notificationEntity = ComunicationMapper.toEntity(notificationId, comunication);
        comunicationRepository.save((notificationEntity));
    }

    @Override
    public ComunicationResponseDTO findNotification(Long notificationId) {
        Optional<ComunicationEntity> comunication = comunicationRepository.findById((notificationId));
        return comunication.map(ComunicationMapper::toResponse).orElseGet(ComunicationResponseDTO::new);
    }

    @Override
    public List<ComunicationResponseDTO> findAllComunication() {
        List<ComunicationEntity> comunications = comunicationRepository.findAll();

        return comunications.stream()
                .map(ComunicationMapper::toResponse)
                .collect(Collectors.toList());

    }

    @Override
    public void deleteComunication(Long notificationId) {
        logger.info(String.format("Deleting comunication >> id: %s", notificationId));
        comunicationRepository.deleteById(notificationId);
    }

    private void validateComunicationRequest(ComunicationResquestDTO comunication) throws BadRequestException {
        if( getComunicationType(comunication.getTipoComunicacao()) == null) {
            throw new BadRequestException("tipoComunicacao is mandatory.");
        }

        if(comunication.equals(ComunicationTypeEnum.SMS.description) &&
                comunication.getDestinatario().getTelefone() == null){
            throw new BadRequestException("telefone is mandatory for SMS comunication.");
        }

        if(comunication.equals(ComunicationTypeEnum.WHATSAPP.description) &&
                comunication.getDestinatario().getTelefone() == null){
            throw new BadRequestException("telefone is mandatory for WHATSAPP comunication.");
        }

        if(comunication.equals(ComunicationTypeEnum.EMAIL.description) &&
                (comunication.getDestinatario().getEmail() == null || comunication.getDestinatario().getEmail().isEmpty())){
            throw new BadRequestException("telefone is mandatory for WHATSAPP comunication.");
        }

        if(comunication.getDestinatario().getTelefone().length() < 11){
            throw new BadRequestException("telefone must be 11 characters like 11123456789.");
        }

    }

}

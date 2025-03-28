package com.luiza.labs.controller;

import com.luiza.labs.DTO.ComunicationResponseDTO;
import com.luiza.labs.DTO.ComunicationResquestDTO;
import com.luiza.labs.bussiness.ComunicationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comunication")
@Tag(name = "Comunication API")
public class ComunicationController {

    @Autowired
    private ComunicationServiceImpl comunicationService;

    @Operation(description = "salva uma requisição de comunicação no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "created"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    @PostMapping("/create")
    public ResponseEntity<?> sendNotification(
            @RequestBody ComunicationResquestDTO notification) throws BadRequestException {
        comunicationService.saveComunication(notification);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(description = "atualiza uma requisição de comunicação no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "no content"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNotification(
            @RequestBody ComunicationResquestDTO comunication,
            @PathVariable(name = "id") Long comunicationId) throws BadRequestException {
        comunicationService.updateComunication(comunicationId, comunication);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(description = "busca uma requisição de comunicação no banco de dados por um Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> findNotification(
            @PathVariable(name = "id") Long comunicationId) {
        return ResponseEntity.ok(comunicationService.findNotification(comunicationId));
    }


    @Operation(description = "busca todas as requisições de comunicação no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    @GetMapping("/")
    public ResponseEntity<List<ComunicationResponseDTO>> findAllNotification() {
        return ResponseEntity.ok(comunicationService.findAllComunication());
    }

    @Operation(description = "exclui uma requisição de comunicação no banco de dados por um Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "404", description = "not found"),
            @ApiResponse(responseCode = "500", description = "internal server error")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNotification(
            @PathVariable(name = "id") Long comunicationId
    ) {
        comunicationService.deleteComunication(comunicationId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

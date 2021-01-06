package com.gian.card.controllers;

import com.gian.card.model.entity.CardsInfo;
import com.gian.card.model.response.CardsResponse;
import com.gian.card.service.ICardService;
import io.reactivex.Single;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/core")
@Api(value = "CardController", produces = "application/json", tags = { "Card Controller" })
public class CardController {

    @Autowired
    private ICardService cardService;

    @ApiOperation(value = "Obtener Tarjetas", tags = { "Card Controller" })
    @GetMapping(value = "/cards", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta Éxitosa", response = CardsResponse.class),
            @ApiResponse(code= 500, message = "500 Error Internal.")})
    public Single<CardsResponse> getCards(@RequestParam String documentNumber){

        log.info("Controller: Get Cards with Document Number: " + documentNumber);
        return cardService.getCards(documentNumber);
    }
}

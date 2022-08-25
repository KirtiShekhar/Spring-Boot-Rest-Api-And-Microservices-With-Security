package com.springboot.bankingsecurity.restController;


import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.CardsRequestDto;
import com.springboot.bankingsecurity.entity.Cards;
import com.springboot.bankingsecurity.service.CardsService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsRestController
{
    Logger cardsLogger = LoggerFactory.getLogger(CardsRestController.class);

    @Autowired
    CardsService cardsService;

    @PostMapping(value = "/saveCards",consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "insert new Cards in the database")
    public Cards saveCards(@RequestBody CardsRequestDto cardsRequestDto)
    {
        Cards savedCards = new Cards();
        cardsLogger.info("Inserting new Cards to database");
        try
        {
            cardsLogger.info("invoking cardsService.saveCards(cardsRequestDto) service");
            savedCards = cardsService.saveCards(cardsRequestDto);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            cardsLogger.error("Error in insert Cards : " + errorMessage);
        }

        return savedCards;
    }

    @GetMapping(value = "/getAllCards",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get All Cards Details Stored in database")
    public List<Cards> getAllCards()
    {
        List<Cards> cardsResponseList = new ArrayList<>();
        cardsLogger.info("Get All Account Details Stored in database");
        try
        {
            cardsLogger.info("invoking cardsService.getAllCards() service");
            cardsResponseList = cardsService.getAllCards();
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            cardsLogger.error("Error in get all Cards details : " + errorMessage);
        }

        return cardsResponseList;
    }

    @GetMapping(value = "/getSingleCards/{cardsId}",produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Cards Details For given Id Stored in database")
    public Cards getCardDetails(@PathVariable Long cardsId)
    {
        Cards singleCards = new Cards();
        cardsLogger.info("Get Cards Details For given Id Stored in database");
        try
        {
            cardsLogger.info("invoking cardsService.getCardDetails(cardsId) service");
            singleCards = cardsService.getCardDetails(cardsId);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            cardsLogger.error("Error in get single Cards details : " + errorMessage);
        }

        return singleCards;
    }
}

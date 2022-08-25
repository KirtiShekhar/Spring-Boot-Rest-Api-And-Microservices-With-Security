package com.springboot.bankingsecurity.controller;


import com.springboot.bankingsecurity.Constant.BankingApplicationConstants;
import com.springboot.bankingsecurity.dto.CardsRequestDto;
import com.springboot.bankingsecurity.entity.Cards;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.service.CardsService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardsController
{
    Logger cardsLogger = LoggerFactory.getLogger(CardsController.class);

    @Autowired
    CardsService cardsService;

    @RequestMapping("/cards/getCard")
    public List<Cards> getCards(@RequestBody Customer customer)
    {
        List<Cards> singleCards = new ArrayList<>();
        cardsLogger.info("Get Cards Details For given Id Stored in database");
        try
        {
            cardsLogger.info("invoking cardsService.getCardDetails(cardsId) service");
            singleCards = cardsService.getCards(customer);
        }
        catch(RuntimeException ex)
        {
            final String errorMessage = ex.getMessage() == null ? BankingApplicationConstants.ERROR_MSG : ex.getMessage();
            cardsLogger.error("Error in get single Cards details : " + errorMessage);
        }

        return singleCards;
    }
}

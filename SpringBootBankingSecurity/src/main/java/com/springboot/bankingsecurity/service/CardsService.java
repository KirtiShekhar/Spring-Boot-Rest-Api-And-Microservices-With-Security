package com.springboot.bankingsecurity.service;

import com.springboot.bankingsecurity.dto.CardsRequestDto;
import com.springboot.bankingsecurity.entity.Cards;
import com.springboot.bankingsecurity.entity.Customer;

import java.util.List;

public interface CardsService
{
    Cards saveCards(CardsRequestDto cardsRequestDto);
    Cards getCardDetails(Long cardsId);
    List<Cards> getAllCards();
    List<Cards> getCards(Customer customer);
}

package com.springboot.bankingsecurity.serviceImplementation;

import com.springboot.bankingsecurity.dto.CardsRequestDto;
import com.springboot.bankingsecurity.entity.Cards;
import com.springboot.bankingsecurity.entity.Customer;
import com.springboot.bankingsecurity.repository.CardsRepository;
import com.springboot.bankingsecurity.service.CardsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardsServiceImplementation implements CardsService
{
    @Autowired
    CardsRepository cardsRepository;

    @Override
    public Cards saveCards(CardsRequestDto cardsRequestDto)
    {
        Cards cards = new Cards();
        cardsRequestDto.setCreateDt(LocalDateTime.now().toString());
        BeanUtils.copyProperties(cardsRequestDto,cards);
        Cards savedCards = cardsRepository.saveAndFlush(cards);
        return savedCards;
    }

    @Override
    public Cards getCardDetails(Long cardsId)
    {
        Cards singleCards;
        Optional<Cards> existCards = cardsRepository.findById(cardsId);
        if(existCards.isPresent())
        {
            singleCards = existCards.get();
        }
        else
        {
            throw new RuntimeException("Card with given id not exist");
        }
        return singleCards;
    }

    @Override
    public List<Cards> getAllCards()
    {
        List<Cards> cardsList = new ArrayList<>();
        cardsList = cardsRepository.findAll();
        return cardsList;
    }

    @Override
    public List<Cards> getCards(Customer customer)
    {
        List<Cards> cardsListByCustomerId = new ArrayList<>();
        cardsListByCustomerId = cardsRepository.findByCustomerId(customer.getCustomerId());
        return cardsListByCustomerId;
    }
}

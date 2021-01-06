package com.gian.card.service;


import com.gian.card.model.response.CardsResponse;
import io.reactivex.Single;

public interface ICardService {
    Single<CardsResponse> getCards(String s);
}

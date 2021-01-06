package com.gian.card.service.impl;

import com.gian.card.model.entity.CardsInfo;
import com.gian.card.model.response.CardsResponse;
import com.gian.card.service.ICardService;
import io.reactivex.Single;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Override
    public Single<CardsResponse> getCards(String s) {
        List<CardsInfo> cardsInfo = Arrays.asList(
                new CardsInfo("1111222233334441", true),
                new CardsInfo("1111222233334442", true),
                new CardsInfo("1111222233334443", true),
                new CardsInfo("1111222233334444", false),
                new CardsInfo("1111222233334445", false),
                new CardsInfo("1111222233334446", false)
        );

        CardsResponse response = new CardsResponse();
        response.setCards(cardsInfo);

        return Single.just(response);
    }
}

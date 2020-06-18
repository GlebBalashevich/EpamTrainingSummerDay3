package by.balashevich.basketapp.service;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.entity.ItemColor;

import java.util.List;

public class BasketService {

    public double countBallsWeight(Basket basket) {
        double weight = 0;

        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                if (ball != null) {
                    weight += ball.getWeight();
                }
            }
        } else{
            weight = -1;
        }

        return weight;
    }

    public int countSameColorBalls(Basket basket, ItemColor ballColor) {
        int count = 0;

        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                if (ball != null) {
                    if (ball.getColor() == ballColor) {
                        count++;
                    }
                }
            }
        } else{
            count = -1;
        }

        return count;
    }

    public void loadBasket(Basket basket, List<Ball> ballsArray) {
        double filledPayload = 0;
        double filledVolume = 0;
        double availablePayload = basket.getPayload();
        double availableVolume = basket.getVolume();

        for (Ball lyingBall : basket.getBalls()) {
            if (lyingBall != null) {
                filledPayload += lyingBall.getWeight();
                filledVolume += lyingBall.getSize().getVolume();
            }
        }

        availablePayload -= filledPayload;
        availableVolume -= filledVolume;

        for (Ball ball : ballsArray) {
            if (ball != null) {
                if (ball.getWeight() <= availablePayload) {
                    if (ball.getSize().getVolume() <= availableVolume) {
                        basket.addBall(ball);
                        availablePayload -= ball.getWeight();
                        availableVolume -= ball.getSize().getVolume();
                    }
                }
            }
        }
    }
}

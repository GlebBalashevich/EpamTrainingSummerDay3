package by.balashevich.basketapp.service;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.entity.ItemColor;

import java.util.List;

public class BasketService {

    public double calculateBallsWeight(Basket basket) {
        double weight = 0;

        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                if (ball != null) {
                    weight += ball.getWeight();
                }
            }
        } else {
            weight = -1;
        }

        return weight;
    }

    public int calculateSameColorBalls(Basket basket, ItemColor ballColor) {
        int count = 0;

        if (basket != null) {
            for (Ball ball : basket.getBalls()) {
                if (ball != null) {
                    if (ball.getColor() == ballColor) {
                        count++;
                    }
                }
            }
        } else {
            count = -1;
        }

        return count;
    }

    public double calculateBasketFreeVolume(Basket basket) {
        double availableVolume = 0;

        if (basket != null) {
            availableVolume = basket.getVolume();
            List<Ball> balls = basket.getBalls();

            if (balls != null) {
                for (Ball lyingBall : balls) {
                    if (lyingBall != null) {
                        availableVolume -= lyingBall.getSize().getVolume();
                    }
                }
            }
        }

        return availableVolume;
    }

    public double calculateBasketFreePayload(Basket basket) {
        double availablePayload = 0;

        if (basket != null) {
            availablePayload = basket.getPayload();
            List<Ball> balls = basket.getBalls();

            if (balls != null) {
                for (Ball lyingBall : balls) {
                    if (lyingBall != null) {
                        availablePayload -= lyingBall.getWeight();
                    }
                }
            }
        }

        return availablePayload;
    }

    public int loadBasket(Basket basket, List<Ball> ballsArray) {
        int numberPlacedBalls = 0;
        double availableVolume = 0;
        double availablePayload = 0;

        if (basket != null) {
            availableVolume = calculateBasketFreeVolume(basket);
            availablePayload = calculateBasketFreePayload(basket);

            for (Ball ball : ballsArray) {
                if (ball != null) {
                    if (ball.getWeight() <= availablePayload) {
                        if (ball.getSize().getVolume() <= availableVolume) {
                            basket.addBall(ball);
                            availablePayload -= ball.getWeight();
                            availableVolume -= ball.getSize().getVolume();
                            numberPlacedBalls++;
                        }
                    }
                }
            }
        }

        return numberPlacedBalls;
    }
}

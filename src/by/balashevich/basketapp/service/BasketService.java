package by.balashevich.basketapp.service;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.entity.ItemColor;

public class BasketService {

    public double countBallsWeight(Basket basket) {
        double weight = 0;

        for (Ball ball : basket.getBalls()) {
            weight += ball.getWeight();
        }

        return weight;
    }

    public int countSameColorBalls(Basket basket, ItemColor ballColor) {
        int count = 0;

        for (Ball ball : basket.getBalls()) {
            if (ball.getColor() == ballColor) {
                count++;
            }
        }

        return count;
    }

//    public void loadingBasket(Basket basket, List<Ball> ballsArray) {
//        double filledPayload = 0;
//        double filledVolume = 0;
//        double availablePayload = basket.getPayload();
//        double availableVolume = basket.getVolume();
//
//        for (Ball lyingBall : basket.getBalls()) {
//            filledPayload += lyingBall.getWeight();
//            filledVolume += lyingBall.getVolume();
//        }
//
//        availablePayload -= filledPayload;
//        availableVolume -= filledVolume;
//
//        for (Ball ball : ballsArray) {
//            if (ball.getWeight() <= availablePayload) {
//                if (ball.getVolume() <= availableVolume) {
//                    basket.addBall(ball);
//                    availablePayload -= ball.getWeight();
//                    availableVolume -= ball.getVolume();
//                }
//            }
//        }
//
//    }
}

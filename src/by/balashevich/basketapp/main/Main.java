package by.balashevich.basketapp.main;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.BallSize;
import by.balashevich.basketapp.entity.ItemColor;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Ball(ItemColor.RED, BallSize.XL, 40).hashCode());
    }
}

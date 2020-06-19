package by.balashevich.basketapp.main;

import by.balashevich.basketapp.creator.BasketCreator;
import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import by.balashevich.basketapp.parser.EntityParser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ProjectInvalidDataException {
        List<String> dataLines1 = new ArrayList<>();
        dataLines1.add("basket, 300, 25");
        dataLines1.add("basket, 300, 4");
        dataLines1.add("basket, 700, 50");
        List<Basket> expectedBaskets1 = new ArrayList<>();
        expectedBaskets1.add(new Basket(300, 25));
        expectedBaskets1.add(new Basket(50, 4));
        expectedBaskets1.add(new Basket(700, 50));
        BasketCreator basketCreator = new BasketCreator();
        List<Basket> expectedBaskets2 = basketCreator.createBasketsList(dataLines1);
        for(Basket basket : expectedBaskets2){
            System.out.println(basket);
        }
    }
}

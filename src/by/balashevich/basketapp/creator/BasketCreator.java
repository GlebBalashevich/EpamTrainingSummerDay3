package by.balashevich.basketapp.creator;

import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.parser.EntityParser;

import java.util.ArrayList;
import java.util.List;

public class BasketCreator {
    private final String REGEX_BASKET = "basket,\\s\\d+\\.?\\d+,\\s\\d+\\.?\\d+";

    public List<Basket> parseBasketsList(List<String> basketsLinesData) {
        EntityParser entityParser = new EntityParser();
        List<Basket> basketList = new ArrayList<>();

        for (String dataLine : basketsLinesData) {
            if (dataLine.matches(REGEX_BASKET)) {
                basketList.add(entityParser.parseBasket(dataLine));
            }
        }

        return basketList;
    }
}

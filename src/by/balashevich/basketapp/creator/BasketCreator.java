package by.balashevich.basketapp.creator;

import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import by.balashevich.basketapp.parser.EntityParser;
import by.balashevich.basketapp.validator.EntityValidator;

import java.util.ArrayList;
import java.util.List;

public class BasketCreator {
    private static final String REGEX_BASKET = "basket,\\s\\d+\\.?\\d+,\\s\\d+\\.?\\d*";

    public List<Basket> createBasketsList(List<String> basketsLinesData) throws ProjectInvalidDataException {
        EntityParser entityParser = new EntityParser();
        EntityValidator entityValidator = new EntityValidator();
        List<Basket> basketList = new ArrayList<>();

        for (String dataLine : basketsLinesData) {
            if (dataLine.matches(REGEX_BASKET)) {
                Basket basket = entityParser.parseBasket(dataLine);

                if (entityValidator.validateBasket(basket)) {
                    basketList.add(basket);
                } else {
                    throw new ProjectInvalidDataException("Invalid data for creating basket");
                }
            }
        }

        return basketList;
    }
}

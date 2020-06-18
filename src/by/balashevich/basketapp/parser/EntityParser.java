package by.balashevich.basketapp.parser;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.BallSize;
import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.entity.ItemColor;

public class EntityParser {
    private final String REGEX_SPLITTER = ",";
    private final int BALL_COLOR_INDEX = 1;
    private final int BALL_SIZE_INDEX = 2;
    private final int BALL_WEIGHT_INDEX = 3;
    private final int BASKET_VOLUME_INDEX = 1;
    private final int BASKET_PAYLOAD_INDEX = 2;

    public Ball parseBall(String ballData) {
        String[] elements = ballData.split(REGEX_SPLITTER);

        ItemColor ballColor = ItemColor.valueOf(elements[BALL_COLOR_INDEX].trim());
        BallSize ballSize = BallSize.valueOf(elements[BALL_SIZE_INDEX].trim());
        double ballWeight = Double.parseDouble(elements[BALL_WEIGHT_INDEX].trim());

        return new Ball(ballColor, ballSize, ballWeight);
    }

    public Basket parseBasket(String basketData) {
        String[] elements = basketData.split(REGEX_SPLITTER);

        double basketVolume = Double.parseDouble(elements[BASKET_VOLUME_INDEX]);
        double basketPayload = Double.parseDouble(elements[BASKET_PAYLOAD_INDEX]);

        return new Basket(basketVolume, basketPayload);
    }
}

package by.balashevich.basketapp.validator;

public class EntityFilter {
    private final String REGEX_BASKET = "basket,\\s\\d+\\.?\\d+,\\s\\d+\\.?\\d+";
    private final String REGEX_BALL = "ball,\\s[a-zA-Z]+,\\s[a-zA-Z]{1,2},\\s\\d+\\.?\\d+";


    public boolean filterBasket(String basketData) {
        return basketData.matches(REGEX_BASKET);
    }

    public boolean filterBall(String basketData) {
        return basketData.matches(REGEX_BALL);
    }
}

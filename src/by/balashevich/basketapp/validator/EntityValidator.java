package by.balashevich.basketapp.validator;

public class EntityValidator {
    private final double MAXIMUM_BALL_WEIGHT = 100;
    private final double MAXIMUM_BASKET_VOLUME = 900;
    private final double MAXIMUM_BASKET_PAYLOAD = 500;

    public boolean validateBall(double weight) {
        return (0 < weight && weight <= MAXIMUM_BALL_WEIGHT);
    }

    public boolean validateBasket(double volume, double payload) {
        boolean result = true;

        if (0 >= volume || volume >= MAXIMUM_BASKET_VOLUME) {
            result = false;
        }

        if (0 >= payload || payload >= MAXIMUM_BASKET_PAYLOAD) {
            result = false;
        }

        return result;
    }
}

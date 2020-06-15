package by.balashevich.basketapp.creator;

import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import by.balashevich.basketapp.validator.EntityValidator;

public class BasketCreator {

    public Basket createBasket(double basketVolume, double basketPayload) throws ProjectInvalidDataException {
        EntityValidator entityValidator = new EntityValidator();
        if (!entityValidator.validateBasket(basketVolume, basketPayload)) {
            throw new ProjectInvalidDataException("Invalid data while creating Basket");
        }

        return new Basket(basketVolume, basketPayload);
    }
}

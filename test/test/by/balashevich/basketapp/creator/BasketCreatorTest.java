package test.by.balashevich.basketapp.creator;

import by.balashevich.basketapp.creator.BasketCreator;
import by.balashevich.basketapp.entity.Basket;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BasketCreatorTest {
    BasketCreator basketCreator;

    @BeforeTest
    public void setUp() {
        basketCreator = new BasketCreator();
    }

    @Test(dataProvider = "basketPositiveData", dataProviderClass = CreatorDataProvider.class)
    public void createBasketsListTestPositive(List<String> basketsData, List<Basket> expectedBaskets) {
        try {
            List<Basket> actualBaskets = basketCreator.createBasketsList(basketsData);
            assertEquals(actualBaskets, expectedBaskets);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(dataProvider = "basketNegativeData", dataProviderClass = CreatorDataProvider.class)
    public void createBasketsListTestNegative(List<String> basketsData, List<Basket> expectedBaskets) {
        try {
            List<Basket> actualBaskets = basketCreator.createBasketsList(basketsData);
            assertNotEquals(actualBaskets, expectedBaskets);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "basketExceptionData",
            dataProviderClass = CreatorDataProvider.class)
    public void createBasketsListTestException(List<String> basketData) throws ProjectInvalidDataException {
        basketCreator.createBasketsList(basketData);
    }
}
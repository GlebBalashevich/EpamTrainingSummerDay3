package test.by.balashevich.basketapp.creator;

import by.balashevich.basketapp.creator.BallCreator;
import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class BallCreatorTest {
    BallCreator ballCreator;

    @BeforeTest
    public void setUp() {
        ballCreator = new BallCreator();
    }

    @Test(dataProvider = "ballPositiveData", dataProviderClass = CreatorDataProvider.class)
    public void createBallsListTestPositive(List<String> ballsData, List<Ball> expectedBalls) {
        try {
            List<Ball> actualBalls = ballCreator.createBallsList(ballsData);
            assertEquals(actualBalls, expectedBalls);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(dataProvider = "ballNegativeData", dataProviderClass = CreatorDataProvider.class)
    public void createBallsListTestNegative(List<String> ballsData, List<Ball> expectedBalls) {
        try {
            List<Ball> actualBalls = ballCreator.createBallsList(ballsData);
            assertNotEquals(actualBalls, expectedBalls);
        } catch (ProjectInvalidDataException e) {
            fail("exception occurred");
        }
    }

    @Test(expectedExceptions = ProjectInvalidDataException.class, dataProvider = "ballExceptionData",
            dataProviderClass = CreatorDataProvider.class)
    public void createBallsListTestException(List<String> ballsData) throws ProjectInvalidDataException {
        ballCreator.createBallsList(ballsData);
    }
}
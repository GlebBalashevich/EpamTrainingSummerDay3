package test.balashevich.basketapp.reader;

import by.balashevich.basketapp.reader.ItemDataReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class ItemDataReaderTest {
    ItemDataReader itemDataReader;

    @BeforeTest
    public void setUp() {
        itemDataReader = new ItemDataReader();
    }

    @DataProvider(name = "readerDataPositive")
    public Object[][] createReaderDataPositive() {
        List<String> expectedLines1 = new ArrayList<>();
        expectedLines1.add("basket, 600, 47");
        expectedLines1.add("basket, 350, 14");
        expectedLines1.add("ball, RED, XL, 2.9");
        expectedLines1.add("ball, GREEN, L, 2.3");
        expectedLines1.add("ball, BLUE, M, 1.7");
        expectedLines1.add("ball, BLUE, S, 0.6");
        expectedLines1.add("ball, BROWN, XL, 2.6");
        expectedLines1.add("ball, BLUE, XL, 3.0");
        return new Object[][]{
                {"input/inputData.txt", expectedLines1},
                {"wrongFilePath.txt", expectedLines1},
                {null, expectedLines1},
        };
    }

    @Test(dataProvider = "readerDataPositive")
    public void readAllDataTestPositive(String filename, List<String> expected) {
        List<String> actualLines = itemDataReader.readAllData(filename);
        assertEquals(actualLines, expected);
    }

    @DataProvider(name = "readerDataNegative")
    public Object[][] createReaderDataNegative() {
        List<String> expectedLines1 = new ArrayList<>();
        expectedLines1.add("ball, BLUE, XL, 3.0");
        expectedLines1.add("ball, BROWN, XL, 2.6");
        expectedLines1.add("ball, BLUE, S, 0.6");
        expectedLines1.add("ball, BLUE, M, 1.7");
        expectedLines1.add("ball, GREEN, L, 2.3");
        expectedLines1.add("ball, RED, XL, 2.9");
        expectedLines1.add("basket, 350, 14");
        expectedLines1.add("basket, 600, 47");
        return new Object[][]{
                {"input/inputData.txt", expectedLines1},
                {"wrongFilePath.txt", expectedLines1},
        };
    }

    @Test(dataProvider = "readerDataNegative")
    public void readAllDataTestNegative(String filename, List<String> expected) {
        List<String> actualLines = itemDataReader.readAllData(filename);
        assertNotEquals(actualLines, expected);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void readAllDataTestException() {
        itemDataReader.readAllData("out/production/BasketApp/by/" +
                "balashevich/basketapp/creator/BallCreator.class");
    }
}
package by.balashevich.basketapp.parser;

import by.balashevich.basketapp.entity.BallSize;
import by.balashevich.basketapp.entity.ItemColor;
import by.balashevich.basketapp.validator.EntityFilter;

import java.util.ArrayList;
import java.util.List;

public class EntityParser {

    public List<List> parseBaskets(List<String> inputData) {
        EntityFilter entityFilter = new EntityFilter();
        List<List> basketDataList = new ArrayList<List>();

        for (String dataLine : inputData) {
            if (entityFilter.filterBasket(dataLine)) {
                String[] basketDataElements = dataLine.split(",");
                List basketElements = new ArrayList();
                basketElements.add(Double.parseDouble(basketDataElements[1].trim()));
                basketElements.add(Double.parseDouble(basketDataElements[2].trim()));
                basketDataList.add(basketElements);
            }
        }

        return basketDataList;
    }

    public List<List> parseBalls(List<String> inputData) {
        EntityFilter entityFilter = new EntityFilter();
        List<List> ballDataList = new ArrayList<List>();

        for (String dataLine : inputData) {
            if (entityFilter.filterBall(dataLine)) {
                String[] ballsDataElements = dataLine.split(",");
                List ballElements = new ArrayList();
                ballElements.add(ItemColor.valueOf(ballsDataElements[1].trim()));
                ballElements.add(BallSize.valueOf(ballsDataElements[2].trim()));
                ballElements.add(Double.parseDouble(ballsDataElements[3].trim()));
                ballDataList.add(ballElements);
            }
        }

        return ballDataList;
    }
}

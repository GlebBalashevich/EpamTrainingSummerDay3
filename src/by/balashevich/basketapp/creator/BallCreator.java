package by.balashevich.basketapp.creator;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.parser.EntityParser;

import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    private final String REGEX_BALL = "ball,\\s[a-zA-Z]+,\\s[a-zA-Z]{1,2},\\s\\d+\\.?\\d+";

    public List<Ball> parseBallsList(List<String> ballsLinesData) {
        EntityParser entityParser = new EntityParser();
        List<Ball> ballList = new ArrayList<>();

        for (String dataLine : ballsLinesData) {
            if (dataLine.matches(REGEX_BALL)) {
                ballList.add(entityParser.parseBall(dataLine));
            }
        }

        return ballList;
    }
}

package by.balashevich.basketapp.creator;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import by.balashevich.basketapp.parser.EntityParser;
import by.balashevich.basketapp.validator.EntityValidator;

import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    private static final String REGEX_BALL = "ball,\\s[a-zA-Z]+,\\s[a-zA-Z]{1,2},\\s\\d+\\.?\\d*";

    public List<Ball> createBallsList(List<String> ballsLinesData) throws ProjectInvalidDataException {
        EntityParser entityParser = new EntityParser();
        EntityValidator entityValidator = new EntityValidator();
        List<Ball> ballList = new ArrayList<>();

        for (String dataLine : ballsLinesData) {
            if (dataLine.matches(REGEX_BALL)) {
                Ball ball = entityParser.parseBall(dataLine);

                if (entityValidator.validateBall(ball)) {
                    ballList.add(ball);
                } else {
                    throw new ProjectInvalidDataException("Invalid data for creating ball");
                }
            }
        }

        return ballList;
    }
}

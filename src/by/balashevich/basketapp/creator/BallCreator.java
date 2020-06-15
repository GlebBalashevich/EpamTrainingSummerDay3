package by.balashevich.basketapp.creator;

import by.balashevich.basketapp.entity.Ball;
import by.balashevich.basketapp.entity.BallSize;
import by.balashevich.basketapp.entity.ItemColor;
import by.balashevich.basketapp.exception.ProjectInvalidDataException;
import by.balashevich.basketapp.validator.EntityValidator;

import java.util.ArrayList;
import java.util.List;

public class BallCreator {
    private final int BALL_COLOR_INDEX = 0;
    private final int BALL_SIZE_INDEX = 1;
    private final int BALL_WEIGHT_INDEX = 2;

    public Ball createBall(ItemColor ballColor, BallSize ballSize, double ballWeight) throws ProjectInvalidDataException {
        EntityValidator entityValidator = new EntityValidator();
        if (!entityValidator.validateBall(ballWeight)) {
            throw new ProjectInvalidDataException("Invalid data while creating Ball");
        }

        return new Ball(ballColor, ballSize, ballWeight);
    }

    public List<Ball> createBallList(List<List> ballsDataList) throws ProjectInvalidDataException {
        EntityValidator entityValidator = new EntityValidator();
        List<Ball> ballsList = new ArrayList<>();

        for(List ballElements : ballsDataList){
            if (!entityValidator.validateBall((double) ballElements.get(BALL_WEIGHT_INDEX))) {
                throw new ProjectInvalidDataException("Invalid data while creating Ball");
            }

            ItemColor ballColor = (ItemColor) ballElements.get(BALL_COLOR_INDEX);
            BallSize ballSize = (BallSize) ballElements.get(BALL_SIZE_INDEX);
            double ballWeight = (double) ballElements.get(BALL_WEIGHT_INDEX);
            ballsList.add(new Ball(ballColor, ballSize, ballWeight));
        }

        return ballsList;
    }

}

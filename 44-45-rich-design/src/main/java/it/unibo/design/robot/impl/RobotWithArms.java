package it.unibo.design.robot.environment.impl;

import it.unibo.design.robot.api.Robot;

public interface RobotWithArms extends Robot {
    boolean pickUp();
    boolean dropDown();
    int getCarriedItemsCount();
}

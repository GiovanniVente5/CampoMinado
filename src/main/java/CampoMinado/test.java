package CampoMinado;

import java.awt.*;
import java.util.Random;

public class test {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        int x = 227;
        int y = 409;
        robot.mouseMove(x, y - 20);
        System.out.println(robot.getPixelColor(x, y - 20));

    }
}

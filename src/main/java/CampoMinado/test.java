package CampoMinado;

import java.awt.*;

public class test {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        int y = 310;
        int x = 259;
        robot.mouseMove(x, y);
        System.out.println(robot.getPixelColor(x, y));

//        Quadrado{y=377, x=259, statusQuadrado=FECHADO, cor=java.awt.Color[r=205,g=205,b=205]}
//        ABERTO


//        FECHADO

        System.out.println(robot.getPixelColor(x, y));
    }
}

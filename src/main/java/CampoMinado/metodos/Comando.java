package CampoMinado.metodos;

import java.awt.*;
import java.awt.event.InputEvent;

public class Comando {
    //    usado para identifica numeros do campo | tamaho do  campo
    public static Color corDoPixel(int x, int y) {
        try {
            Robot robot = new Robot();
//           cria o objeto que indica uma cor e detecta qual cor está nas cordenadas
            //            System.out.println(corDetectada);
//           caso é a cor esperada volta true, caso contrario false
            return robot.getPixelColor(x, y);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //    Usar para selecionar e clicar em um dos quadrados
    public static void clicar(Quadrado quadrado) {
        try {
            Robot robot = new Robot();
            robot.mouseMove(quadrado.getX(), quadrado.getY());
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(2000);
            System.out.println("Click");
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bandeira(Quadrado quadrado) {
        try {
            Robot robot = new Robot();
            robot.delay(50);
            robot.mouseMove(quadrado.getX(), quadrado.getY());
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            Thread.sleep(500);
            quadrado.setStatusQuadrado(StatusQuadrado.BANDEIRA);
            System.out.println("Colocou bandeira");

        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

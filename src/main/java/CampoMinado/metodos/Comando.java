package CampoMinado.metodos;

import java.awt.*;
import java.awt.event.InputEvent;

public class Comando {
    //    usado para identifica numeros do campo | tamaho do  campo
    public static Color corDoPixel(int x, int y) {
        try {
            Robot robot = new Robot();
//           cria o objeto que indica uma cor e detecta qual cor está nas cordenadas
            Color corDetectada = robot.getPixelColor(x, y);
//            System.out.println(corDetectada);
//           caso é a cor esperada volta true, caso contrario false
            return corDetectada;

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    //    Usar para selecionar e clicar em um dos quadrados
    public static void clicar(Quadrado quadrado) {
        try {
            Robot robot = new Robot();
            robot.delay(50);
            robot.mouseMove(quadrado.x, quadrado.y);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);

            System.out.println("Click - " + quadrado.toString());

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void marcar(Quadrado quadrado) {
        try {
            Robot robot = new Robot();
            robot.delay(50);
            robot.mouseMove(quadrado.x, quadrado.y);
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.delay(50);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            Thread.sleep(500);
            System.out.println("Click - " + quadrado.toString());

        } catch (AWTException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

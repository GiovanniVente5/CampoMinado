package CampoMinado.metodos;

import java.awt.*;
import java.util.HashMap;

public class Quadrado {
//    0 - aberto
//    -1 - fechado
//    -2 - com bandeira
//    1 - 8 = numero de minas
    int status;
    int y;
    int x;

    public void setStatus() {
//        fechado - 1 = java.awt.Color[r=255,g=255,b=255] tendo que -24 no y
//        aberto 0 = java.awt.Color[r=189,g=189,b=189]
//        numero 1 = java.awt.Color[r=95,g=0,b=255]
//        numero 2 = java.awt.Color[r=37,g=133,b=0]
//        numero 3 = java.awt.Color[r=230,g=35,b=29]
        Color numIdentificado = Identificar.corDoPixel(x, y);
        Color seAberto = Identificar.corDoPixel(x, y - 24);

        HashMap<Color, Integer> colorHashMap = new HashMap<>();
        colorHashMap.put(new Color(189, 189, 189), 0);
        colorHashMap.put(new Color(95, 0, 255), 1);
        colorHashMap.put(new Color(37, 133, 0), 2);
        colorHashMap.put(new Color(230, 35, 29), 3);

        if (seAberto.equals(new Color(255, 255, 255))) {
            status = -1;
            System.out.println("Fechado");
        } else if (colorHashMap.containsKey(numIdentificado)) {
            status = colorHashMap.get(numIdentificado);
            System.out.println("Identificado: " + status);
        } else {
            System.out.println(numIdentificado);
            status = 9;
        }
    }

    @Override
    public String toString() {
        return "Quadrado{" +
               "status=" + status +
               ", x=" + x +
               ", y=" + y +
               '}';
    }

    public Quadrado(int status, int y, int x) {
        this.status = status;
        this.y = y;
        this.x = x;
    }

    public int getStatus() {
        return status;
    }


    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

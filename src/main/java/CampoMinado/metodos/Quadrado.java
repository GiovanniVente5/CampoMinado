package CampoMinado.metodos;

import java.awt.*;

import static CampoMinado.metodos.StatusQuadrado.*;

public class Quadrado {
    //     0 - aberto
//    -1 - fechado
//    -2 - com bandeira
//    1 - 8 = numero de minas
    int status = setStatus();
    int y;
    int x;

    public static int statusNum(Color cor) {
        if (ABERTO.getCor().getRGB() == cor.getRGB()) return ABERTO.getStatus();
        if (FECHADO.getCor().equals(cor)) return FECHADO.getStatus();
        if (UM.getCor().equals(cor)) return UM.getStatus();
        if (DOIS.getCor().equals(cor)) return DOIS.getStatus();
        if (TRES.getCor().equals(cor)) return TRES.getStatus();
        if (QUATRO.getCor().equals(cor)) return QUATRO.getStatus();

        return StatusQuadrado.DESCONHECIDO.getStatus();
    }

    public int setStatus() {
        int numIdentificado;
//        fechado - 1 = java.awt.Color[r=255,g=255,b=255] tendo que -24 no y
//        aberto 0 = java.awt.Color[r=189,g=189,b=189]
//        numero 1 = java.awt.Color[r=95,g=0,b=255]
//        numero 2 = java.awt.Color[r=37,g=133,b=0]
//        numero 3 = java.awt.Color[r=230,g=35,b=29]
//        numero 4 = java.awt.Color[r=42,g=0,b=125]
        if (Comando.corDoPixel(x, y - 20).equals(FECHADO.getCor())) {
            numIdentificado = -1;
        } else {
            numIdentificado = statusNum(Comando.corDoPixel(x, y));
        }
        this.status = numIdentificado;
        return numIdentificado;
    }


    @Override
    public String toString() {
        return "Quadrado{" +
               "statusNum=" + status +
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

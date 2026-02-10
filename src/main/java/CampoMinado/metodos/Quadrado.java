package CampoMinado.metodos;

import java.awt.*;

import static CampoMinado.metodos.StatusQuadrado.*;

public class Quadrado {
    final int y;
    final int x;
    final int[] coordenada;
    private int chanceBomba = 0;
    private StatusQuadrado statusQuadrado;

    public Quadrado(StatusQuadrado statusQuadrado, int y, int x, int[] coordenada) {
        this.statusQuadrado = statusQuadrado;
        this.y = y;
        this.x = x;
        this.coordenada = coordenada;
    }

    public static StatusQuadrado statusNum(Color cor) {
        if (BANDEIRA.getCor().getRGB() == cor.getRGB()) return BANDEIRA;
        if (ABERTO.getCor().getRGB() == cor.getRGB()) return ABERTO;
        if (FECHADO.getCor().getRGB() == cor.getRGB()) return FECHADO;
        if (UM.getCor().getRGB() == cor.getRGB()) return UM;
        if (DOIS.getCor().getRGB() == cor.getRGB()) return DOIS;
        if (TRES.getCor().getRGB() == cor.getRGB()) return TRES;
        if (QUATRO.getCor().getRGB() == cor.getRGB()) return QUATRO;

        return StatusQuadrado.DESCONHECIDO;
    }

    public void setStatus() {
        if (Comando.corDoPixel(x, y - 20).getRGB() == new Color(205, 205, 205).getRGB()) {
            this.statusQuadrado = FECHADO;
        } else {
            this.statusQuadrado = statusNum(Comando.corDoPixel(x, y));
            setChanceBomba(0);
        }
    }

    @Override
    public String toString() {
        return "Quadrado{" +
               "y=" + y +
               ", x=" + x +
               ", chanceBomba=" + chanceBomba +
               ", statusQuadrado=" + statusQuadrado +
               '}';
    }

    public StatusQuadrado getStatusQuadrado() {
        return statusQuadrado;
    }

    public void setStatusQuadrado(StatusQuadrado statusQuadrado) {
        this.statusQuadrado = statusQuadrado;
    }

    public int[] getCoordenada() {
        return coordenada;
    }

    public int getChanceBomba() {
        return chanceBomba;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setChanceBomba(int chanceBomba) {
        if (this.statusQuadrado == FECHADO) {
            this.chanceBomba = chanceBomba;
        } else {
            this.chanceBomba = 0;
        }

    }
}

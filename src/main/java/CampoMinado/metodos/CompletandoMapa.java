package CampoMinado.metodos;


import java.awt.*;

public class CompletandoMapa {
    public static boolean jogoStatus() {
        return Comando.corDoPixel(259, 310).equals(new Color(242, 255, 0));
    }

    public static void outracoisa(Quadrado[][] mapa) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j].statusQuadrado != StatusQuadrado.ABERTO && mapa[i][j].statusQuadrado == StatusQuadrado.FECHADO) {
                    chanceBombas(mapa, mapa[i][j]);
                }
            }
        }
    }

    public static void resolv(Quadrado[][] mapa) {
        Quadrado quadradoBomba = new Quadrado(StatusQuadrado.FECHADO, 1, 1, new int[]{0, 0});
        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {
                if (quadrado.getChanceBomba() >= quadradoBomba.getChanceBomba()) {
                    quadradoBomba = quadrado;
                }
            }
        }
        Comando.bandeira(quadradoBomba);
    }

    public static void chanceBombas(Quadrado[][] mapa, Quadrado quadrado) {
        int x = quadrado.getCoordenada()[0] - 1;
        if (quadrado.getCoordenada()[0] <= 0) x = 0;

        int x2 = quadrado.getCoordenada()[0] + 2;
        if (quadrado.getCoordenada()[0] >= mapa[0].length) x = mapa[0].length;

        int y = quadrado.getCoordenada()[1] - 1;
        if (quadrado.getCoordenada()[1] <= 0) y = 0;

        int y2 = quadrado.getCoordenada()[1] + 2;
        if (quadrado.getCoordenada()[1] >= mapa.length) y = mapa.length;

        System.out.println(x + " x " + x2);
        System.out.println(y + " y " + y2);

        for (int i = x; i < x2; i++) {
            for (int j = y; j < y2; j++) {
                if (mapa[i][j].getStatusQuadrado() == StatusQuadrado.FECHADO) mapa[i][j].chanceBomba += 1;
            }
        }
    }
}


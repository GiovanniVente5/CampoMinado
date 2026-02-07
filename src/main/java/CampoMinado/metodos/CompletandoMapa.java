package CampoMinado.metodos;


import java.awt.*;

import static CampoMinado.metodos.StatusQuadrado.*;

public class CompletandoMapa {
    public static boolean jogoStatus() {
        return Comando.corDoPixel(259, 310).equals(new Color(242, 255, 0));
    }

    //    clicar chance de bomba maior
    public static void resolv(Quadrado[][] mapa) {
        Quadrado quadradoBomba = new Quadrado(FECHADO, 1, 1, new int[]{0, 0});
        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {

            }
        }

    }

    public static void chanceBombas(Quadrado[][] mapa) {
        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {
//          checa os arredores de um quadrado com numero, caso seja um quadrado fechado aumenta a chance de bomba em 1
                if (quadrado.getStatusQuadrado() != ABERTO && quadrado.getStatusQuadrado() != FECHADO && quadrado.getStatusQuadrado() != BANDEIRA) {
                    for (int i = quadrado.getCoordenada()[0] - 1; i < quadrado.getCoordenada()[0] + 2; i++) {
                        for (int j = quadrado.getCoordenada()[1] - 1; j < quadrado.getCoordenada()[1] + 2; j++) {
                            if (i >= 0 && i < mapa.length && j >= 0 && j < mapa[0].length) {
                                if (!mapa[i][j].equals(quadrado) && mapa[i][j].getStatusQuadrado() == FECHADO) {
                                    mapa[i][j].setChanceBomba();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

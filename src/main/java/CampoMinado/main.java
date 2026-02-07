package CampoMinado;


import CampoMinado.metodos.*;

import java.util.Arrays;

import static CampoMinado.metodos.Comando.*;
import static CampoMinado.metodos.CriarMapa.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
//        Quadrado[][] mapa = mapa();
//        clicar(mapa[2][3]);
//        atualizarMapa(mapa);

        Quadrado[][] mapa = mapaTESTE();
        mapa[0][0].setStatusQuadrado(StatusQuadrado.UM);
        mapa[1][1].setStatusQuadrado(StatusQuadrado.UM);
        CompletandoMapa.chanceBombas(mapa);
        CompletandoMapa.resolv(mapa);


        for (Quadrado[] quadrados : mapa) {
            System.out.println("--------------------------------------");
            for (Quadrado quadrado : quadrados) {
                System.out.println(quadrado.toString());
            }
        }
    }
}
// 1xx
// x1x
// xxx
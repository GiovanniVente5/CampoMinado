package CampoMinado;


import CampoMinado.metodos.*;

import java.util.Arrays;
import java.util.List;

import static CampoMinado.metodos.Comando.*;
import static CampoMinado.metodos.CriarMapa.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Quadrado[][] mapa = mapa();
        clicar(mapa[2][3]);
        atualizarMapa(mapa);

//        Quadrado[][] mapa = mapaTESTE();
//        mapa[0][0].setStatusQuadrado(StatusQuadrado.UM);
        CompletandoMapa.chanceBombas(mapa);
        CompletandoMapa.bandeiras(mapa);
        atualizarMapa(mapa);




        for (Quadrado[] quadrados : mapa) {
            System.out.println("--------------------------------------");
            for (Quadrado quadrado : quadrados) {
                System.out.println(quadrado.toString());
            }
        }
    }
}
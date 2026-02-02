package CampoMinado;


import CampoMinado.metodos.Comando;
import CampoMinado.metodos.CompletandoMapa;
import CampoMinado.metodos.Quadrado;
import CampoMinado.metodos.StatusQuadrado;

import static CampoMinado.metodos.Comando.*;
import static CampoMinado.metodos.CriarMapa.*;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Quadrado[][] mapa = mapa();

        clicar(mapa[2][3]);
        atualizarMapa(mapa);
        int[] a = coordenada(mapa, StatusQuadrado.UM);
        CompletandoMapa.chanceBombas(mapa, mapa[a[0]][a[1]]);


        for (Quadrado[] quadrados : mapa) {
            System.out.println("--------------------------------------");
            for (Quadrado quadrado : quadrados) {
                if (quadrado.getChanceBomba() != 0) Comando.bandeira(quadrado);
                System.out.println(quadrado.toString());
            }
        }
    }
}

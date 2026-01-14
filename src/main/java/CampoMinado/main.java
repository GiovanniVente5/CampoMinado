package CampoMinado;


import CampoMinado.metodos.CriarMapa;
import CampoMinado.metodos.Comando;
import CampoMinado.metodos.Quadrado;

import java.awt.*;

import static CampoMinado.metodos.CompletandoMapa.randomQuadrado;

public class main {
    public static void main(String[] args) throws InterruptedException {
//       System.out.println(CriarMapa.tamanhoCampo());
//       mapa com todos os quadrados -1
        Quadrado[][] mapa = CriarMapa.mapa();
        Comando.clicar(mapa[0][0]);
        CriarMapa.aoRedor(mapa, CriarMapa.coordenada(mapa, 1));

//      [0][0],[0][1],[0][2]
//      [1][0],[1][1],[1][2]
//      [2][0],[2][1],[2][2]

    }
}

package CampoMinado;



import CampoMinado.metodos.CriarMapa;
import CampoMinado.metodos.Quadrados;

import java.awt.*;

public class main {
    public static void main(String[] args) {
        System.out.println(CriarMapa.tamanhoCampo());
//       mapa com todos os quadrados -1
        Quadrados[][] mapa = CriarMapa.mapa();

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.println(mapa[i][j].toString());
            }
            System.out.println();
        }
    }
}

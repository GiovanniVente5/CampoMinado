package CampoMinado.metodos;

import java.awt.*;

public class CriarMapa {
    public static int[] tamanhoCampo() {
        Color cor = new Color(205, 205, 205);
        boolean z = true;
        boolean c = true;

        int[] tamanho = {0, 0};
        int x = 114;
        int y = 373;

        while (z) {
            if (Comando.corDoPixel(x, y).equals(cor)) {
                tamanho[0]++;
                x += 32;
            } else {
                z = false;
            }
        }
        x = 114;
        while (c) {
            if (Comando.corDoPixel(x, y).equals(cor)) {
                tamanho[1]++;
                y = y + 32;
            } else {
                c = false;
            }
        }

        System.out.println("Tamanho x: " + tamanho[0] + " Y: " + tamanho[1]);
        return tamanho;
    }

    //    criando um array bidemensional que cria Objetos para cada quadrado do campo, assim criando o mapa
    public static Quadrado[][] mapa() {
        int[] tamanho = tamanhoCampo();
        int x = 131;
        int y = 377;
        Quadrado[][] mapa = new Quadrado[tamanho[0]][tamanho[1]];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = new Quadrado(-1, y, x);
                x += 32;
            }
            y += 32;
        x = 131;
        }
        return mapa;
    }

    public static void atualizarMapa(Quadrado[][] mapa) {
        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {
                quadrado.setStatus();
            }
        }
    }

    public static int[] coordenada(Quadrado[][] mapa, int statusQuadrado) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (mapa[i][j].status == statusQuadrado) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    public static void aoRedor(Quadrado[][] mapa, int[] coordenada) {
        for (int i = coordenada[0] - 1; i < coordenada[0] + 1; i++) {
            for (int j = coordenada[1] - 1; j < coordenada[1] + 1; j++) {
                if (mapa[i][j].equals(mapa[coordenada[0]][coordenada[1]])) {
                } else {
                    Comando.clicar(mapa[i][j]);
                }
            }
        }
        atualizarMapa(mapa);
    }
}
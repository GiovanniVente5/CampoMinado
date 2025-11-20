package CampoMinado.metodos;

import java.awt.*;

public class CriarMapa {
//    o campo sempre será um quadrado perfeito, retorna apenas a linha superior para depois ser feita ao qudrado
    public static int tamanhoCampo(){
        Color cor = new Color(205, 205, 205);
        boolean y = true;
        int tamanho = 0;
        int x = 114;
        while (y){
            if (Identificar.corDoPixel(x, 373).equals(cor)) {
                tamanho++;
                System.out.println(tamanho);
                x = x + 32;
            } else {
                y = false;
            }
        }
        return tamanho;
    }

//    criando um array bidemensional que cria Objetos para cada quadrado do campo, assim criando um mapa
public static Quadrado[][] mapa() {
        int tamanho = tamanhoCampo();
    int x = 131;
    int y = 373;
    Quadrado[][] mapa = new Quadrado[tamanho][tamanho];
    for (int i = 0; i < mapa.length; i++) {
        for (int j = 0; j < mapa[i].length; j++) {
            mapa[i][j] = new Quadrado(-1, y, x);
                x = x + 32;
            }
            y = y + 32;
        x = 131;
        }
    return mapa;
    }

    public static void atualizarMapa(Quadrado[][] mapa) {
        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {
                quadrado.setStatus();
                System.out.println(quadrado.toString());
            }
        }
    }
}
package CampoMinado.metodos;


import java.util.Random;

public class CompletandoMapa {
    public static Quadrado randomQuadrado(Quadrado[][] mapa) {
        Random rand = new Random();
        return mapa[rand.nextInt(mapa.length)][rand.nextInt(mapa[0].length)];
    }

    enum situacao {
        PERDIDO,
        EM_ANDAMENTO,
        GANHO
    }

    public static situacao statusJogo() {

        return situacao.GANHO;
    }

    public static void resolva(Quadrado[][] mapa) {

    }
}

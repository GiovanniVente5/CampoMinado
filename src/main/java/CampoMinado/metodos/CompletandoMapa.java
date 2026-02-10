package CampoMinado.metodos;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CompletandoMapa {
    public static boolean jogoStatus() {
        return Comando.corDoPixel(259, 310).equals(new Color(242, 255, 0));
    }

    //checa os arredores de um quadrado com numero, caso seja um quadrado fechado aumenta a chance de bomba em 1
    public static List<Quadrado> aoRedor(Quadrado[][] mapa, Quadrado quadrado) {
        List<Quadrado> result = new ArrayList<>();
        for (int i = quadrado.getCoordenada()[0] - 1; i < quadrado.getCoordenada()[0] + 2; i++) {
            for (int j = quadrado.getCoordenada()[1] - 1; j < quadrado.getCoordenada()[1] + 2; j++) {
                if (i >= 0 && i < mapa.length && j >= 0 && j < mapa[0].length) {
                    if (!mapa[i][j].equals(quadrado)) {
                        result.add(mapa[i][j]);
                    }
                }
            }
        }
        return result;
    }

    public static void chanceBombas(Quadrado[][] mapa) {
        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {
                if (quadrado.getStatusQuadrado() != StatusQuadrado.FECHADO && quadrado.getStatusQuadrado() != StatusQuadrado.ABERTO && quadrado.getStatusQuadrado() != StatusQuadrado.BANDEIRA) {
                    List<Quadrado> list = aoRedor(mapa, quadrado);
                    list.removeIf(quadrado1 -> quadrado1.getStatusQuadrado() != StatusQuadrado.FECHADO);
                    AtomicInteger bandeiras = new AtomicInteger();

                    list.forEach(quadrado1 -> {
                        if (quadrado1.getStatusQuadrado() == StatusQuadrado.BANDEIRA) bandeiras.getAndIncrement();
                    });
                    list.forEach(quadrado1 -> quadrado1.setChanceBomba(quadrado.getStatusQuadrado().getStatus() + quadrado1.getChanceBomba() - bandeiras.get()));
                }
            }
        }
    }

    public static void bandeiras(Quadrado[][] mapa) {
        List<Quadrado> quadradosBomba = new ArrayList<>(Arrays.stream(mapa).flatMap(Arrays::stream).toList());
        quadradosBomba.removeIf(quadrado -> quadrado.getChanceBomba() == 0);
        quadradosBomba.sort(Comparator.comparing(Quadrado::getChanceBomba));
        quadradosBomba.forEach(quadrado -> System.out.println(quadrado.toString()));
    }
}

package CampoMinado;



import CampoMinado.metodos.CriarMapa;
import CampoMinado.metodos.Identificar;
import CampoMinado.metodos.Quadrado;

public class main {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(CriarMapa.tamanhoCampo());
//       mapa com todos os quadrados -1
        Quadrado[][] mapa = CriarMapa.mapa();

        Identificar.clicar(mapa[8][8]);
        Thread.sleep(1000);
        CriarMapa.atualizarMapa(mapa);

        for (Quadrado[] quadrados : mapa) {
            for (Quadrado quadrado : quadrados) {
                System.out.println(quadrado.toString());
            }
            System.out.println();
        }
    }
}

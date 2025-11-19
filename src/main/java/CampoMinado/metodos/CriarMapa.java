package CampoMinado.metodos;

import java.awt.*;

public class CriarMapa {
//    usado para identifica numeros do campo | tamaho do  campo
    public static boolean corDoPixel(int x, int y, Color corEsperada) {
        try {
            Robot robot = new Robot();
//           cria o objeto que indica uma cor e detecta qual cor está nas cordenadas
            Color corDetectada = robot.getPixelColor(x, y);
//           caso é a cor esperada volta true, caso contrario false
            return corDetectada.equals(corEsperada);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

//    o campo sempre será um quadrado perfeito, retorna apenas a linha superior para depois ser feita ao qudrado
    public static int tamanhoCampo(){
        Color cor = new Color(255,255,255);
        boolean y = true;
        int tamanho = -1;
        int x = 112;
        while (y){
            if (corDoPixel(x,352,cor)){
                tamanho++;
                x = x + 32;
            } else {
                y = false;
            }
        }
        return tamanho;
    }

//    criando um array bidemensional que cria Objetos para cada quadrado do campo, assim criando um mapa
    public static Quadrados[][] mapa (){
        int tamanho = tamanhoCampo();
        int x = 112;
        int y = 352;
        Quadrados[][] array = new Quadrados[tamanho][tamanho];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Quadrados(-1,y,x);
                x = x + 32;
            }
            y = y + 32;
            x = 112;
        }
        return array;
    }
}
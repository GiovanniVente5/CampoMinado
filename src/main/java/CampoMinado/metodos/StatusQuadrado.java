package CampoMinado.metodos;

import java.awt.*;

public enum StatusQuadrado {
    DESCONHECIDO(404, new Color(255, 0, 0)),
    BANDEIRA(-2, new Color(0, 0, 0)),
    FECHADO(-1, new Color(205, 205, 205)),
    ABERTO(0, new Color(189, 189, 189)),
    UM(1, new Color(95, 0, 255)),
    DOIS(2, new Color(37, 133, 0)),
    TRES(3, new Color(230, 35, 29)),
    QUATRO(4, new Color(42, 0, 125));

    final int status;
    final Color cor;

    StatusQuadrado(int status, Color cor) {
        this.status = status;
        this.cor = cor;
    }

    public int getStatus() {
        return status;
    }

    public Color getCor() {
        return cor;
    }
}

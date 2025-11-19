package CampoMinado.metodos;

public class Quadrados {
//    0 - aberto
//    -1 - fechado
//    -2 - com bandeira
//    1 - 8 = numero de minas
    int status;
    int y;
    int x;

    @Override
    public String toString() {
        return "Quadrados{" +
               "status=" + status +
               ", y=" + y +
               ", x=" + x +
               '}';
    }

    public Quadrados(int status, int y, int x) {
        this.status = status;
        this.y = y;
        this.x = x;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

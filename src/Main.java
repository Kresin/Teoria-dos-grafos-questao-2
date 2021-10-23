import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        int[][] mapa = {
        { 0, 0, 0, 0, 0, 0, 0},
        { 0, 0, 0, 0,-1,-1, 0},
        { 0,-1,-1, 0,-1, 1, 0},
        { 0, 0, 0, 0,-1, 0, 0},
        { 0,-1,-1, 0,-1,-1, 0},
        { 0, 0, 0, 0, 0, 0, 0},
        { 0,-1,-1, 0, 0, 0, 0},
    };

    AEstrela ae = new AEstrela(1,2,2,5,mapa);
    System.out.println(ae.abertos.toString());
    System.out.println(ae.fechados.toString());

    No no = new No(null, 0,11,1,2);
    ae.adicionaNosVizinhos(no);

    System.out.println(ae.abertos.toString());
    System.out.println(ae.fechados.toString());

    }

}

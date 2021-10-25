//Integrantes: Gabriel Kresin e Iago G. Tambosi

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] mapa = {
            { 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0,-1,-1, 0},
            { 0,-1,-1, 0,-1, 0, 0},
            { 0, 0, 0, 0,-1, 0, 0},
            { 0,-1,-1, 0,-1,-1, 0},
            { 0, 0, 0, 0, 0, 0, 0},
            { 0,-1,-1, 0, 0, 0, 0}
        };
        //Fornecer na construção do objeto AEstrela as coordenadas do ponto de início, do ponto de destino e fornecer o mapa
        //Obs.: coordenadas no mapa seguem o seguinte padrão: mapa[x][y]
        AEstrela ae = new AEstrela(6,0,2,5,mapa);

        List<No> backtrack =  ae.procuraCaminho();

        if (backtrack.size() != 0) {
            String caminho = "";
            for (int i = backtrack.size() -1; i >= 0; i--) {
                caminho += "[" + backtrack.get(i).x + "," + backtrack.get(i).y + "]" + ", ";
            }
            System.out.println("O caminho encontrado foi:\n" + caminho.substring(0, caminho.length()-2) + "\nO custo (g) foi:\n" + backtrack.get(0).g);
        } else {
            System.out.println("Não foi encontrado um caminho possível");
        }
    }
}

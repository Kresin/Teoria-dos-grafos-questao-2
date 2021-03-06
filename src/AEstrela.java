//Integrantes: Gabriel Kresin e Iago G. Tambosi

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AEstrela {

    private int xInicio, yInicio;
    private int xFinal, yFinal;
    private List<No> abertos;
    private List<No> fechados;
    private int[][] mapa;


    private int calculaHeuristica(int xNo, int yNo, int xFim, int yFim) {
        //Calcula a distancia 'Manhattan' (G) de um No até o objetivo final

        int xResultado = Math.abs(xNo - xFim);
        int yResultado = Math.abs(yNo - yFim);
        return xResultado + yResultado;
    }

    private static boolean encontraNoEmLista (No no, List<No> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if ((lista.get(i).x == no.x) && (lista.get(i).y == no.y)) {
                return true; //No de mesma posição encontrado na lista
            }
        }
        return false; //No não encontrado
    }

    public void  adicionaNosVizinhos(No no) {

        //Começa série de validações quanto aos nós vizinhos
        //Acima -> -1 no eixo x da matriz
        if (!(no.x -1 < 0)) {
            int xVizinho = no.x -1;
            int yVizinho = no.y;
            if (mapa[xVizinho][yVizinho] != -1) {
                No vizinho = new No(no, no.g + 1, calculaHeuristica(xVizinho, yVizinho, xFinal, yFinal), xVizinho, yVizinho);
                if (!encontraNoEmLista(vizinho, fechados) && !encontraNoEmLista(vizinho, abertos)) {
                    abertos.add(vizinho);
                }
            }
        }

        //Abaixo -> +1 no eixo x da matriz
        if (!(no.x +1 >= mapa.length)) {
            int xVizinho = no.x +1;
            int yVizinho = no.y;
            if (mapa[xVizinho][yVizinho] != -1) {
                No vizinho = new No(no, no.g + 1, calculaHeuristica(xVizinho, yVizinho, xFinal, yFinal), xVizinho, yVizinho);
                if (!encontraNoEmLista(vizinho, fechados) && !encontraNoEmLista(vizinho, abertos)) {
                    abertos.add(vizinho);
                }
            }
        }

        //Esquerda -> -1 no eixo y da matriz
        if (!(no.y -1 < 0)) {
            int xVizinho = no.x;
            int yVizinho = no.y -1;
            if (mapa[xVizinho][yVizinho] != -1) {
                No vizinho = new No(no, no.g + 1, calculaHeuristica(xVizinho, yVizinho, xFinal, yFinal), xVizinho, yVizinho);
                if (!encontraNoEmLista(vizinho, fechados) && !encontraNoEmLista(vizinho, abertos)) {
                    abertos.add(vizinho);
                }
            }
        }

        //Direita -> +1 no eixo y da matriz
        if (!(no.y +1 >= mapa[0].length)) {
            int xVizinho = no.x;
            int yVizinho = no.y +1;
            if (mapa[xVizinho][yVizinho] != -1) {
                No vizinho = new No(no, no.g + 1, calculaHeuristica(xVizinho, yVizinho, xFinal, yFinal), xVizinho, yVizinho);
                if (!encontraNoEmLista(vizinho, fechados) && !encontraNoEmLista(vizinho, abertos)) {
                    abertos.add(vizinho);
                }
            }
        }

        Collections.sort(abertos);
    }

    private boolean verificaSeEhFinal (No no) {
        if ((no.x == xFinal) && (no.y == yFinal)) {
            return true;
        }
        return false;
    }

    public List<No> procuraCaminho() {
        List<No> caminho = new ArrayList<No>();

        No comeco = new No(null, 0, calculaHeuristica(xInicio, yInicio, xFinal, yFinal), xInicio, yInicio);
        abertos.add(comeco);

        while (!abertos.isEmpty()) {
            No atual = abertos.get(0);

            if (verificaSeEhFinal(atual)) {
                //É nó final, então joga pra lista todos os nós pais
                No aux = atual;

                while (aux != null) {
                    caminho.add(aux);
                    aux = aux.pai;
                }
                return caminho;
            }

            //Não é Nó final, então prossegue com a busca
            adicionaNosVizinhos(atual);
            abertos.remove(atual);
            fechados.add(atual);
        }
        return caminho;
    }

    public AEstrela (int xInicio, int yInicio, int xFim, int yFim, int[][] mapa) {
        this.xInicio = xInicio;
        this.yInicio = yInicio;
        this.xFinal = xFim;
        this.yFinal = yFim;
        this.abertos = new ArrayList<No>();
        this.fechados = new ArrayList<No>();
        this.mapa = mapa;
    }



}

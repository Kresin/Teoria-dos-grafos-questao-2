//Integrantes: Gabriel Kresin e Iago G. Tambosi

public class No implements Comparable {
    //Atributos
    public No pai;
    public int g;
    public int h;
    public final int x, y; //Posicao

    //Construtor
    public No(No pai, int g, int h, int posx, int posy) {
        this.pai = pai;
        this.g = g;
        this.h = h;
        this.x = posx;
        this.y = posy;
    }

    @Override
    public int compareTo(Object o) {
        No comparado = (No) o;

        int fNo = this.g + this.h;
        int fNoComparado = comparado.g + comparado.h;

        return fNo - fNoComparado;
    }
}

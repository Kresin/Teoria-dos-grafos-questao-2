public class No {
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
}

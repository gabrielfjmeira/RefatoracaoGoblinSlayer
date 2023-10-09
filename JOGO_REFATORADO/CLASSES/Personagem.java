package JOGO_REFATORADO.CLASSES;


public abstract class Personagem {
    private int vida;
    private int ataque;
    private int defesa;


    public Personagem(int vida, int ataque, int defesa) {
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public  String falaPersonagem(){
        return "Fala do Personagem:";
    }

    public abstract String atacar(Personagem personagem);

}

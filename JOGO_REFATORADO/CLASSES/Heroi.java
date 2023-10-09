package JOGO_REFATORADO.CLASSES;
import java.util.Random;

public class Heroi extends Personagem {
    // Definindo atributos
    private String nome;
    private String classe;
    private int ouro;
    private int qtdPocao;
    private Arma arma;
    private Random rd =new Random();
    // metodo construtor
    public Heroi(String nome, String classe){
        super(0,0,0);
        this.nome = nome;
        this.classe = classe;
        this.qtdPocao = 1;
        this.ouro = 20;
        this.arma = new Arma("Mão",0);
        switch (classe){
            case "Guerreiro":
                super.setVida(60);
                super.setAtaque(10);
                super.setDefesa(10);
                break;
            case "Arqueiro":
                super.setVida(50);
                super.setAtaque(15);
                super.setDefesa(8);
                break;
            case "Mago":
                super.setVida(45);
                super.setAtaque(35);
                super.setDefesa(6);
                break;
        }
    }
    // metodos get
    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public int getOuro() {
        return ouro;
    }

    public int getQtdPocao() {
        return qtdPocao;
    }

    public Arma getArma() {
        return arma;
    }
    // metodos set
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void setOuro(int ouro) {
        this.ouro = ouro;
    }

    public void setQtdPocao(int qtdPocao) {
        this.qtdPocao = qtdPocao;
    }

    @Override
    public String falaPersonagem(){
        switch (classe){
            case "Guerreiro":
                return super.falaPersonagem() + " Pelos poderes de Grayscou";
            case "Arqueiro":
                return super.falaPersonagem() + " Das sombras, so a morte o espera";
            case "Mago":
                return super.falaPersonagem() + " Pelos ensinamentos de Merlin";
        }
        return "";
    }

    @Override
    public String atacar(Personagem personagem){
        int dadoHeroi = rd.nextInt(20) + 1;
        int defesaInimigo = personagem.getDefesa();
        if (dadoHeroi > defesaInimigo) {
            personagem.setVida(personagem.getVida() - this.getAtaque() - arma.getDano());
            return  this.getNome()+ " atacou o inimigo usando "+ arma.getNome() +" "+ (this.getAtaque()+arma.getDano()) + " de dano!";
        } else {
            return this.getNome() + " errou o ataque!";
        }
    }

}

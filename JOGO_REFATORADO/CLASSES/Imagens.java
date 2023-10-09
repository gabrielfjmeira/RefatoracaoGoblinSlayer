package JOGO_REFATORADO.CLASSES;

import javax.swing.*;

public class Imagens {
    private ImageIcon imagePocao;
    private ImageIcon imageArmaG;
    private ImageIcon imageArmaM;
    private ImageIcon imageArmaA;
    private ImageIcon imageCoin;
    private ImageIcon backgroundButton;

    public Imagens(){
        this.imagePocao = new ImageIcon("C:\\Users\\meira.gabriel\\Documents\\JOGO-REFATATORADO\\src\\JOGO_REFATORADO\\ARQUIVOS\\Imagem\\pocaoVida.png");
        this.imageArmaG = new ImageIcon("C:\\Users\\PC GAMER\\IdeaProjects\\Java\\PooCertonho\\src\\Imagem\\espada1.png");
        this.imageArmaM = new ImageIcon("C:\\Users\\PC GAMER\\IdeaProjects\\Java\\PooCertonho\\src\\Imagem\\cajado1.png");
        this.imageArmaA = new ImageIcon("C:\\Users\\PC GAMER\\IdeaProjects\\Java\\PooCertonho\\src\\Imagem\\/arco2.png");
        this.imageCoin  = new ImageIcon("C:\\Users\\PC GAMER\\IdeaProjects\\Java\\PooCertonho\\src\\Imagem\\Coin.png");
        this.backgroundButton = new ImageIcon("C:\\Users\\PC GAMER\\IdeaProjects\\Java\\PooCertonho\\src\\Imagem\\Button.png");
    }

}

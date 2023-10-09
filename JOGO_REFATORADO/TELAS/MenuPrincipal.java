package JOGO_REFATORADO.TELAS;
import JOGO_REFATORADO.CLASSES.BackgroundImage;
import JOGO_REFATORADO.FACADES.MenuPrincipal_Facade;

import javax.lang.model.element.NestingKind;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    MenuPrincipal_Facade menuPrincipal_facade = new MenuPrincipal_Facade();

    //Leitura do Arquivo txt
    Scanner scan;
    private File file = new File("savePersonagem.txt");
    private ArrayList heroiDados = new ArrayList<>();

    //Som
    public static Clip backgroundClip;
    public static Clip NextPageClip;
    private File backgroundMusicFile = new File("C:\\Users\\meira.gabriel\\Documents\\JOGO-REFATATORADO\\src\\JOGO_REFATORADO\\ARQUIVOS\\Som\\BackGround.WAV");
    private File soundNextPage =new File("C:\\Users\\meira.gabriel\\Documents\\JOGO-REFATATORADO\\src\\JOGO_REFATORADO\\ARQUIVOS\\Som\\NextPage.WAV");

    //Fonte das Letras
    private Font font = new Font("Arial",Font.BOLD,20);
    private Font title = new Font("Arial",Font.BOLD,40);
    private Color black = new Color(0,0,0);

    //Componentes para Tela
    private JFrame menu = new JFrame();
    private BackgroundImage background = new BackgroundImage("src/JOGO_REFATORADO/ARQUIVOS/Imagem/MenuImage.jpg");
    private BackgroundImage painel = new BackgroundImage("src/JOGO_REFATORADO/ARQUIVOS/Imagem/Painel.jpg");
    private ImageIcon backgroundButton = new ImageIcon("src/JOGO_REFATORADO/ARQUIVOS/Imagem/Button.png");

    //Construtor do Menu Principal
    public MenuPrincipal(){
        //Configuração da Tela
        menu.setTitle("Menu Principal");
        menu.setSize(1080,720);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menu.add(background);
        background.setLayout(null);
        background.add(painel);

        // Titulo
        JLabel titulo= new JLabel();
        titulo.setText("Goblin Slayer");
        titulo.setFont(title);
        titulo.setForeground(black);
        titulo.setBounds(50,50, 300, 60);


        //Botão de Criar Personagem
        JButton criarPersonagem = new JButton();
        criarPersonagem.setBounds(50,150,250,60);
        criarPersonagem.setLayout(null);
        // estilizacao do botao
        criarPersonagem.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();
        nomeBotao1.setText("Criar Personagem");
        nomeBotao1.setFont(font);
        criarPersonagem.add(nomeBotao1);
        nomeBotao1.setBounds(40,-6,250,70);

        //Botão de Carregar Personagem
        JButton carregarPersonagem = new JButton();
        carregarPersonagem.setBounds(50,250,250,60);
        carregarPersonagem.setLayout(null);
        // estilizacao do botao
        carregarPersonagem.setIcon(backgroundButton);
        JLabel nomeBotao3 = new JLabel();
        nomeBotao3.setText("Carregar Personagem");
        nomeBotao3.setFont(font);
        carregarPersonagem.add(nomeBotao3);
        nomeBotao3.setBounds(20,-6,250,70);

        //Botão de Sair
        JButton sair = new JButton();
        sair.setBounds(50,350,250,60);
        sair.setLayout(null);
        //estilizacao do botao
        sair.setIcon(backgroundButton);
        JLabel nomeBotao2 = new JLabel();
        nomeBotao2.setText("Sair");
        nomeBotao2.setFont(font);
        sair.add(nomeBotao2);
        nomeBotao2.setBounds(100,-6,250,70);


        //Ações dos Botões
        criarPersonagem.addActionListener(this::criarPersonagem);
        carregarPersonagem.addActionListener(this::carregarPersonagem);
        sair.addActionListener(this::sair);


        // Organizando os elementos da tela
        painel.setLayout(null);
        painel.setBounds(375,100, 350,450);
        painel.add(titulo);
        painel.add(criarPersonagem);
        painel.add(carregarPersonagem);
        painel.add(sair);

        try {
            AudioInputStream backgroundAudioInputStream = AudioSystem.getAudioInputStream(backgroundMusicFile);
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(backgroundAudioInputStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
            backgroundClip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }

        //Carrega o arquivo da música de Próxima pagina
        try {
            AudioInputStream NextPageClipaudioInputStream = AudioSystem.getAudioInputStream(soundNextPage);
            NextPageClip = AudioSystem.getClip();
            NextPageClip.open(NextPageClipaudioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
            ex.printStackTrace();
        }
        menu.setVisible(true);
    }

    private void criarPersonagem(ActionEvent a) {
        MenuPrincipal_Facade.criarPersonagem(menu, NextPageClip);
    }

    private void carregarPersonagem(ActionEvent a) {
        MenuPrincipal_Facade.carregarPersonagem(menu, file, heroiDados, NextPageClip);
    }

    private void sair(ActionEvent a) {
        menuPrincipal_facade.sair();
    }

    private void parar() {
        menuPrincipal_facade.parar(backgroundClip);
    }

    public void iniciar(){
        menuPrincipal_facade.iniciar(backgroundClip);
    }
}

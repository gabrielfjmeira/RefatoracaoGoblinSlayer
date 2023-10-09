package JOGO_REFATORADO.TELAS;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import JOGO_REFATORADO.CLASSES.BackgroundImage;
import JOGO_REFATORADO.CLASSES.Heroi;
import JOGO_REFATORADO.CLASSES.Arma;
//import JOGO_REFATORADO.TELAS.MenuJogo;

public class MenuCriarHeroi {

    //Fonte das Letras
    private Font font = new Font("Arial", Font.BOLD, 20);
    private Font title = new Font("Arial", Font.BOLD, 50);
    private Color black = new Color(0, 0, 0);
    private Color input = new Color(73, 64, 54);

    //Componente para Tela
    private JComboBox classeHeroiInput;
    private JTextField nomeHeroiInput;
    private JFrame menu = new JFrame();
    private BackgroundImage background = new BackgroundImage("src/JOGO_REFATORADO/ARQUIVOS/Imagem/MenuImage.jpg");
    private BackgroundImage painel = new BackgroundImage("src/JOGO_REFATORADO/ARQUIVOS/Imagem/Painel.jpg");
    private ImageIcon backgroundButton = new ImageIcon("src/JOGO_REFATORADO/ARQUIVOS/Imagem/Button.png");

    public static Heroi heroi;

    public MenuCriarHeroi(){
        menu.setTitle("Menu - Criar Heroi");
        menu.setSize(1080,720);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);

        menu.add(background);
        background.setLayout(null);
        background.add(painel);

        // Titulo
        JLabel titulo = new JLabel("Criar Herói");
        titulo.setBounds(70, 70, 400, 70);
        titulo.setFont(title);
        titulo.setForeground(black);

        //Campo de inserção de nome do herói
        JLabel titleNomeHeroi = new JLabel();
        titleNomeHeroi.setBounds(30, 150, 250, 70);
        titleNomeHeroi.setFont(font);
        titleNomeHeroi.setText("Nome:");
        titleNomeHeroi.setForeground(black);
        JTextField nomeHeroi = new JTextField();
        nomeHeroi.setBounds(110, 150, 250, 70);
        nomeHeroi.setBorder(BorderFactory.createLineBorder(new Color(47, 42, 34)));
        nomeHeroi.setBackground(input);
        nomeHeroi.setForeground(black);
        nomeHeroi.setFont(font);
        nomeHeroiInput = nomeHeroi;

        //Seleção do tipo de herói
        JLabel titleHeroisList = new JLabel();
        titleHeroisList.setBounds(30, 250, 250, 70);
        titleHeroisList.setFont(font);
        titleHeroisList.setText("Classe:");
        titleHeroisList.setForeground(black);
        String[] tipoHerois = {"Selecione uma opção", "Mago", "Guerreiro", "Arqueiro"};
        JComboBox heroisList = new JComboBox(tipoHerois);
        heroisList.setSelectedIndex(0);
        heroisList.setFont(font);
        heroisList.setForeground(black);
        heroisList.setBackground(input);
//        heroisList.setBorder(BorderFactory.createLineBorder(new Color(47, 42, 34)));
        heroisList.setBounds(110, 250, 250, 70);
        classeHeroiInput = heroisList;

        //Botão para criar herói
        JButton btnAddHeroi = new JButton();
        btnAddHeroi.setBounds(83, 370, 250, 70);
        btnAddHeroi.setLayout(null);
        btnAddHeroi.setIcon(backgroundButton);
        JLabel nomeBotao = new JLabel();
        nomeBotao.setText("Criar Herói");
        nomeBotao.setFont(font);
        btnAddHeroi.add(nomeBotao);
        nomeBotao.setBounds(70,-3,250,70);

        //Botão para voltar para o menu
        JButton voltar = new JButton();
        voltar.setBounds(50, 25, 100, 50);
        voltar.setLayout(null);
        //estilizacao do botao
        voltar.setIcon(backgroundButton);
        JLabel nomeBotao1 = new JLabel();
        nomeBotao1.setText("Voltar");
        nomeBotao1.setFont(font);
        voltar.add(nomeBotao1);
        nomeBotao1.setBounds(20,-10,250,70);
        background.add(voltar);

        // Organizando os elementos da tela
        painel.setLayout(null);
        painel.setBounds(375,100, 400,500);
        painel.add(titulo);
        painel.add(titleNomeHeroi);
        painel.add(nomeHeroi);
        painel.add(titleHeroisList);
        painel.add(heroisList);
        painel.add(btnAddHeroi);

        //Ações dos botões

        btnAddHeroi.addActionListener(this::addHeroi);
        voltar.addActionListener(this::voltar);

        menu.setVisible(true);


    }

    public static void iniciarMenuCriarHeroi(){
        MenuCriarHeroi menuCriarHeroi = new MenuCriarHeroi();
    };

    private void addHeroi(ActionEvent a) {
        String nome = nomeHeroiInput.getText();
        String classe = (String) classeHeroiInput.getSelectedItem();
        try{
            heroi = new Heroi(nome, classe);
            JOptionPane.showMessageDialog(null, "Personagem Criado!");
            menu.setVisible(false);
            //MenuJogo menuJogo = new MenuJogo();
            //MenuPrincipal.nextPage();
        }catch(RuntimeException f){
            JOptionPane.showMessageDialog(null, f.getMessage());
        }
    }

    public static void carregarHeroi(File file, ArrayList heroiDados){
        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                heroiDados.add(scan.nextLine());
            }
            int dano = Integer.parseInt((String) heroiDados.get(6));
            Arma loadArma = new Arma ((String) heroiDados.get(5), dano);
            MenuCriarHeroi.heroi = new Heroi((String) heroiDados.get(0), (String) heroiDados.get(1), (String) heroiDados.get(2), (String) heroiDados.get(3),(String) heroiDados.get(4), loadArma);
            JOptionPane.showMessageDialog(null, "Personagem Carregado!");
            //MenuJogo menuJogo = new MenuJogo();
        } catch (
                FileNotFoundException event) {
            throw new RuntimeException(event);
        }
    }

    private void voltar(ActionEvent a) {
        menu.setVisible(false);
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        //MenuPrincipal.nextPage();
        //MenuPrincipal.parar();
    }

}

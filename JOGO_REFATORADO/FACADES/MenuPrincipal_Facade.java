package JOGO_REFATORADO.FACADES;

import javax.swing.*;
import javax.sound.sampled.*;
import java.util.ArrayList;
import java.io.File;
import JOGO_REFATORADO.TELAS.MenuCriarHeroi;

public class MenuPrincipal_Facade {
    public static void criarPersonagem(JFrame menuPrincipal, Clip nextPageClip) {
        menuPrincipal.setVisible(false);
        MenuCriarHeroi.iniciarMenuCriarHeroi();
        nextPage(nextPageClip);
    }

    public static void carregarPersonagem(JFrame menuPrincipal, File file, ArrayList heroiDados, Clip nextPageClip) {
        menuPrincipal.setVisible(false);
        nextPage(nextPageClip);
        MenuCriarHeroi.carregarHeroi(file, heroiDados);
    }

    public static void sair() {
        System.exit(0);
    }

    public static void parar(Clip backgroundClip) {
        backgroundClip.stop();
    }

    public static void iniciar(Clip backgroundClip){
        if (!backgroundClip.isActive()) {
            backgroundClip.setFramePosition(0);
            backgroundClip.start();
        }
    }
    public static void nextPage(Clip clip) {
        if (!clip.isActive()) {
            clip.setFramePosition(0);
            clip.start();
        }
    }
}

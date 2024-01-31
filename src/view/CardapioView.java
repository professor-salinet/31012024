package view;
import controller.*;
import model.CardapioModel;

import java.util.*;
import javax.swing.*;

public class CardapioView {
    public static void exibirCardapio() {
        CardapioModel.atualizarCardapio();
        CardapioFrame cardapioFrame = new CardapioFrame();
        cardapioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardapioFrame.setSize(800, 450);
        cardapioFrame.setVisible(true);
    }
}

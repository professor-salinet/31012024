package view;

import controller.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardapioFrame extends JFrame {
    private final JLabel lblReceita;

    public CardapioFrame() {
        super("Padoka -> Cardápio!");
        setLayout(new FlowLayout());

        lblReceita = new JLabel();
        lblReceita.setText("Selecione a(s) receita(s) e clique em Fazer pedido.");
        lblReceita.setHorizontalTextPosition(SwingConstants.CENTER);
        lblReceita.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblReceita.setToolTipText("Clique em uma ou mais opções para escolher seu(s) item(ns) de pedido.");
        add(lblReceita);

        for (int r = 0; r < CardapioInter.idsReceitas.size(); r++) {
            CardapioInter.cbxReceitas.add(new JCheckBox());
            CardapioInter.cbxReceitas.get(CardapioInter.cbxReceitas.size() - 1).setText("[ " + CardapioInter.idsReceitas.get(r) + " ] - " + CardapioInter.nomesReceitas.get(r) + " - " + CardapioInter.disponibilidadesReceitas.get(r));
            add(CardapioInter.cbxReceitas.get(CardapioInter.cbxReceitas.size() - 1));
        }
    }

    // private class ItemHandler implements ActionListener {
    //    @Override
    //    public void actionPerformed(ActionEvent event) {
    //         //displayJLabel.setForeground(colorValues[count]); // ação que eu quero aqui
    //       }
    //    }
    // }

    // private class CardapioHandler implements ItemListener {
    //    @Override
    //    public void itemStateChanged(ItemEvent e)
    //    {
    //       String name = displayJLabel.().getName();
    //       Font font;

    //         // aqui terei de inserir um for pra verificar quais checkbox estão clicados
    //       repaint();
    //    }
    // }
}

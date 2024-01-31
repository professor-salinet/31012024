package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoasVindasFrame extends JFrame {

   private final JLabel label1;

   private final Color[] colorValues = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
   private final JRadioButtonMenuItem[] colorItems;
   private final JRadioButtonMenuItem[] fonts;
   private final JCheckBoxMenuItem[] styleItems;
   private final JLabel displayJLabel;
   private final ButtonGroup fontButtonGroup;
   private final ButtonGroup colorButtonGroup;
   private int style;

   public BoasVindasFrame() {
      super("A Padoka mais gostosa do mundo!");
      setLayout(new FlowLayout());

      Icon logo = new ImageIcon(getClass().getResource("padoka_logo.png"));

      label1 = new JLabel();
      label1.setText("Bem vindo à Padoka mais saborosa do mundo!");
      label1.setIcon(logo);
      label1.setHorizontalTextPosition(SwingConstants.CENTER);
      label1.setVerticalTextPosition(SwingConstants.BOTTOM);
      label1.setToolTipText("Aqui a tristeza pula de alegria.");
      add(label1);

      JMenu cardapioMenu = new JMenu("Cardápio");
      cardapioMenu.setMnemonic('C');

      JMenuItem mniVerCardapio = new JMenuItem("Ver Cardápio");
      mniVerCardapio.setMnemonic('V');
      cardapioMenu.add(mniVerCardapio);
      mniVerCardapio.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               CardapioView.exibirCardapio();
               // JOptionPane.showMessageDialog(BoasVindasFrame.this, "Este é um exemplo\ndo uso de menus", "Sobre", JOptionPane.PLAIN_MESSAGE);
               // Estou adicionando códigos aqui
            }
         }
      );

      JMenuItem mniAboutItem = new JMenuItem("Sobre...");
      mniAboutItem.setMnemonic('S');
      cardapioMenu.add(mniAboutItem);
      mniAboutItem.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               JOptionPane.showMessageDialog(BoasVindasFrame.this, "Este é um exemplo\ndo uso de menus", "Sobre", JOptionPane.PLAIN_MESSAGE);
            }
         }
      );

      JMenuItem exitItem = new JMenuItem("Sair");
      exitItem.setMnemonic('r');
      cardapioMenu.add(exitItem);
      exitItem.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
               System.exit(0);
            }
         }
      );

      JMenuBar bar = new JMenuBar();
      setJMenuBar(bar);
      bar.add(cardapioMenu);

      JMenu formatMenu = new JMenu("Format");
      formatMenu.setMnemonic('r');

      String[] colors = {"Black", "Blue", "Red", "Green"};

      JMenu colorMenu = new JMenu("Color");
      colorMenu.setMnemonic('C');

      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup();
      ItemHandler itemHandler = new ItemHandler();

      for (int count = 0; count < colors.length; count++) {
         colorItems[count] =
            new JRadioButtonMenuItem(colors[count]);
         colorMenu.add(colorItems[count]);
         colorButtonGroup.add(colorItems[count]);
         colorItems[count].addActionListener(itemHandler);
      }

      colorItems[0].setSelected(true);

      formatMenu.add(colorMenu);
      formatMenu.addSeparator();

      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font");
      fontMenu.setMnemonic('n');

      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup();

      for (int count = 0; count < fonts.length; count++) {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]);
         fontMenu.add(fonts[count]);
         fontButtonGroup.add(fonts[count]);
         fonts[count].addActionListener(itemHandler);
      }

      fonts[0].setSelected(true);
      fontMenu.addSeparator();

      String[] styleNames = {"Bold", "Italic"};
      styleItems = new JCheckBoxMenuItem[styleNames.length];
      StyleHandler styleHandler = new StyleHandler();

      for (int count = 0; count < styleNames.length; count++) {
         styleItems[count] =
            new JCheckBoxMenuItem(styleNames[count]);
         fontMenu.add(styleItems[count]);
         styleItems[count].addItemListener(styleHandler);
      }

      formatMenu.add(fontMenu);
      // bar.add(formatMenu); // add Format menu to menu bar

      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER);
      displayJLabel.setForeground(colorValues[0]);
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72));

      getContentPane().setBackground(Color.CYAN);
      add(displayJLabel, BorderLayout.CENTER);
   }

   private class ItemHandler implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent event) {
         for (int count = 0; count < colorItems.length; count++) {
            if (colorItems[count].isSelected()) {
               //displayJLabel.setForeground(colorValues[count]); // ação que eu quero aqui
               break;
            }
         }

         for (int count = 0; count < fonts.length; count++) {
            if (event.getSource() == fonts[count]) {
               //displayJLabel.setFont(new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint();
      }
   }

   private class StyleHandler implements ItemListener {
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName();
         Font font;

         if (styleItems[0].isSelected() &&
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint();
      }
   }
}
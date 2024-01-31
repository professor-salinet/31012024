package view;
import javax.swing.*;

public class BoasVindasView {
    public static void exibirCumprimento() {
        BoasVindasFrame labelFrame = new BoasVindasFrame();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(800, 450); 
        labelFrame.setVisible(true); 
    }
}

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            String arq = "teste.txt";
            Banco bc = new Banco();
            bc.setVisible(true);
        });
    }
}
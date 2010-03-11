package simplex;

import javax.swing.UIManager;
import simplex.ui.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("hola");
            System.out.println("este es otraprueba");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
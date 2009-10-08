/*
 * (#)Main.java 1.11
 * @charset "utf-8";
 */

package simplex;
import javax.swing.UIManager;
import simplex.ui.VentanaPrincipal;

/**
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //new Principal().setVisible(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {}
        new VentanaPrincipal().setVisible(true);
         
    }

    static int sumar(int a, int b) {
        return a + b;
    }
}

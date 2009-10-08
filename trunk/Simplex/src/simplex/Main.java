package simplex;
import javax.swing.UIManager;
import simplex.ui.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {}
        new VentanaPrincipal().setVisible(true);      
    }
}

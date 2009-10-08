package simplex;
import javax.swing.UIManager;
import simplex.ui.VentanaPrincipal;
import simplex.resolvedor.mate.SimplexTable;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {}     
        VentanaPrincipal init = new VentanaPrincipal();

        String variables[] = {"x", "y", "w"};
        String variablesBasicas[] = {"c", "d", "e", "f"};
        SimplexTable prueba = new SimplexTable();
        javax.swing.table.DefaultTableModel model = prueba.SimplexTable(variables, variablesBasicas);
        init.changeTable(model);
        init.setVisible(true);
    }

}

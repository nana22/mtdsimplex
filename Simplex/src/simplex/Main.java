package simplex;
import javax.swing.UIManager;
import simplex.ui.VentanaPrincipal;
import simplex.resolvedor.mate.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception ex) {}     
        VentanaPrincipal init = new VentanaPrincipal();
        init.setVisible(true);

        //Monomios Prueba:
        Monomio res = new Monomio( 1,  'Z');
        Monomio m1 = new Monomio( 3, 'x' );
        Monomio m2 = new Monomio( 5, 'y' );
        Monomio conjunto[] = {m1,m2};
        Ecuacion ecua = new Ecuacion ( conjunto, 0 , res);
        Ecuacion ecua2 = new Ecuacion ( conjunto, 3 , res);
        Ecuacion conecu[] = {ecua, ecua, ecua2};
            
        
        Conversiones conv = new Conversiones();
        /*javax.swing.table.DefaultTableModel prueba = new javax.swing.table.DefaultTableModel();
        conv.tratarFO(ecua);
        conv.tratarRestric(conecu);
        for (int j=0; j<conv.getVar().length; j++){
                System.out.println(conv.getVar()[j]);
        }
        for (int j=0; j<conv.getVarBasic().length; j++){
                System.out.println(conv.getVarBasic()[j]);
        }*/


        init.changeTable( conv.Conversiones( ecua, conecu ) );
        //Fin pruebas


        /*String variables[] = {"x", "y", "w"};
        String variablesBasicas[] = {"c", "d", "e", "f"};
        SimplexTable prueba = new SimplexTable();
        javax.swing.table.DefaultTableModel model = prueba.SimplexTable(variables, variablesBasicas);
        init.changeTable(model);*/
        
    }

}

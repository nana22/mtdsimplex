package simplex.resolvedor.mate;
import javax.swing.JTable;
/**
 *
 * @author Marco
 */
public class SimplexTable {

private String colNames[];
private String rowData[][];
private String varBasic[];
private String var[];
    //FOc = Funcion Objetivo Convertida, restC = Restricciones Convertidas;
    SimplexTable( String var[], String varBasic[], Ecuacion FOc, Ecuacion restC[] ){
    }
    public void setColNames( String var[], String varBasic[] ){
        int tamVar = var.length;
        int tamVarBasic = varBasic.length;
        int vars = tamVar + tamVarBasic;
        int numCol = vars + 4;
    }
}

package simplex.resolvedor.mate;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Marco
 */
public class SimplexTable {

private String colNames[];
private String rowData[][];
private String varBasics[];
private String varNs[];
private String varTOT[];
private DefaultTableModel modelo;

    public SimplexTable( String var[], String varBasic[], Ecuacion FOc, Ecuacion restC[] ){
    }
    
    public DefaultTableModel SimplexTable( String var[], String varBasic[] ){
        setVarNs( var );
        setVarBasics( varBasic );
        setVarTOT();
        setColNames ( varNs, varBasics );
        setRowData();
        modelo = newTable( colNames );
        return modelo;
    }

    public DefaultTableModel newTable( String Colums[] ){
        JTable jTable1 = new JTable();
        DefaultTableModel modNuevo = new DefaultTableModel();
        for (int i=0; i<colNames.length; i++){
            modNuevo.addColumn(colNames[i]);
        }
        return modNuevo;
    }

    public void setColNames( String var[], String varBasic[] ){
        int vars = var.length + varBasic.length;
        int numCol = vars + 4;
        colNames = new String[numCol];
        colNames[0] = "Variables Basicas";
        colNames[1] = "Numero Ecuacion";
        colNames[colNames.length-2] = "b";
        colNames[colNames.length-1] = "div";
        for (int i=2, j=0; i<colNames.length-2; i++, j++){
            colNames[i] = varTOT[j];
        }
    }

    public void setRowData(){
        String rowTemp[][] ={ {"1", "2", "3", "4", "5", "6", "7", "8", "9"},
        {"1", "2", "3", "4", "5", "6", "7", "8", "9"} };
        rowData = rowTemp;
    }

    public void setVarBasics( String varBasic[] ){
        varBasics = varBasic;
    }

    public void setVarNs( String vars[] ){
        varNs = vars;
    }

    public void setVarTOT(){
        varTOT = new String[varBasics.length + varNs.length];
        for (int i=0; i<varNs.length; i++){
            varTOT[i] = varNs[i];
        }
        for (int i=0, j=varNs.length; j<varTOT.length; i++, j++ ){
            varTOT[j] = varBasics[i];
        }
    }
    
}

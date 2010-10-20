package simplex.resolvedor.mate;

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

    public DefaultTableModel simplexTable(Ecuacion FOc, Ecuacion restC[]) {
        setVarTOT();
        setColumnsNames(varNs, varBasics);
        modelo = newTable(colNames);
        setRowData(FOc, restC);
        return modelo;
    }

    public DefaultTableModel simplexTable(String var[], String varBasic[]) {
        setVarNs(var);
        setVarBasics(varBasic);
        setVarTOT();
        setColumnsNames(varNs, varBasics);
        //setRowData();
        modelo = newTable(colNames);
        return modelo;
    }

    private DefaultTableModel newTable(String colums[]) {
        DefaultTableModel modNuevo = new DefaultTableModel();

        for (int i = 0; i < colums.length; i++) {
            modNuevo.addColumn(colums[i]);
        }

        return modNuevo;
    }

    /**
     * Define los encabezados de la tabla
     *
     * @param var
     * @param varBasic
     */
    private void setColumnsNames(String var[], String varBasic[]) {
        int numCol = var.length + varBasic.length + 4;

        colNames = new String[numCol];
        colNames[0] = "Número ecuación";
        colNames[1] = "Variables básicas";
        colNames[colNames.length - 2] = "b";
        colNames[colNames.length - 1] = "div";

        for (int i = 2, j = 0; i < colNames.length - 2; i++, j++) {
            colNames[i] = varTOT[j];
        }
    }

    private void setRowData(Ecuacion fo, Ecuacion[] restriciones) {
        String colVarsB[] = new String[varBasics.length + 1];
        colVarsB[0] = "z";

        for (int i = 1; i < colVarsB.length; i++) {
            colVarsB[i] = varBasics[i - 1];
        }

        Ecuacion nuevaEc[] = new Ecuacion[restriciones.length + 1];
        nuevaEc[0] = fo;

        for (int i = 1; i < restriciones.length + 1; i++) {
            nuevaEc[i] = restriciones[i - 1];
        }

        for (int llen = 0; llen < nuevaEc.length; llen++) {
            
            String RowFO[] = new String[colNames.length];
            Monomio temp[] = nuevaEc[llen].getMonomios();

            RowFO[1] = colVarsB[llen];
            RowFO[0] = String.valueOf(llen);
            RowFO[colNames.length - 2] = String.valueOf(nuevaEc[llen].getResultado());
            
            for (int i = 2; i < colNames.length - 2; i++) {
                for (int j = 0; j < temp.length; j++) {
                    String caract = "" + temp[j].getVariable() + temp[j].getSubindice();
                    if (caract.equalsIgnoreCase(colNames[i])) {
                        RowFO[i] = String.valueOf(temp[j].getCoeficiente());
                    }
                }
            }

            //Llenado de valores null con 0
            for (int i = 0; i < RowFO.length; i++) {
                if (RowFO[i] == null) {
                    RowFO[i] = "0.0";
                }
            }

            RowFO[colNames.length - 1] = null;
            modelo.addRow(RowFO);
        }
        
    }

    public void setVarBasics(String varBasic[]) {
        varBasics = varBasic;
    }

    public String[] getVarBasics() {
        return varBasics;
    }

    public void setVarNs(String vars[]) {
        varNs = vars;
    }

    public String[] getVarNs() {
        return varNs;
    }

    private void setVarTOT() {
        varTOT = new String[(varBasics.length + varNs.length)];
        System.arraycopy(varNs, 0, varTOT, 0, varNs.length);
        for (int i = 0, j = varNs.length; j < varTOT.length; i++, j++) {
            varTOT[j] = varBasics[i];
        }
    }

    public String[] getVarTOT() {
        return varTOT;
    }
}

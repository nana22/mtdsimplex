package mx.uacam.fdi.io.simplex.resolvedor.mate;

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

    /**
     *
     * @param fo una ecuación que representa a la función objetivo
     * @param restricciones un arreglo de ecuaciones que representan las restriciones
     * @return la primera tabla del método
     */
    public DefaultTableModel simplexTable(Ecuacion fo, Ecuacion restricciones[]) {
        setVarTOT();
        setColumnsNames(varNs, varBasics);
        modelo = newTable(colNames);
        setRowData(fo, restricciones);
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

    private void setRowData(Ecuacion fo, Ecuacion[] restricciones) {
        String colVarsB[] = new String[varBasics.length + 1];
        colVarsB[0] = "z";

        for (int i = 1; i < colVarsB.length; i++) {
            colVarsB[i] = varBasics[i - 1];
        }

        Ecuacion nuevaEc[] = new Ecuacion[restricciones.length + 1];
        nuevaEc[0] = fo;

        for (int i = 1; i < restricciones.length + 1; i++) {
            nuevaEc[i] = restricciones[i - 1];
        }

        for (int llen = 0; llen < nuevaEc.length; llen++) {

            String RowFO[] = new String[colNames.length];
            Monomio temp[] = nuevaEc[llen].getMonomios();

            RowFO[0] = String.valueOf(llen);
            RowFO[1] = colVarsB[llen];
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

        rowData = new String[modelo.getRowCount()][modelo.getColumnCount() - 3];

        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            for (int columna = 2; columna < modelo.getColumnCount() - 1; columna++) {
                rowData[fila][columna - 2] = new String();
                rowData[fila][columna - 2] = modelo.getValueAt(fila, columna - 2).toString();
            }
        }
    }

    public String[][] getRowData() {
        return rowData;
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

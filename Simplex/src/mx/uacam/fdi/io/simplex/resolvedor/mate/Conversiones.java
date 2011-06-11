package mx.uacam.fdi.io.simplex.resolvedor.mate;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco
 */
public class Conversiones {

    private String variableBasica[];
    private String tempVB[];
    private String variables[];
    private int numeroVariables;
    private String[][] data;

    public DefaultTableModel conversiones(Ecuacion fo, Ecuacion[] rest) {
        numeroVariables = fo.getMonomios().length;
        tratarFO(fo);
        tratarRestric(rest);
        SimplexTable table = new SimplexTable();
        table.setVarBasics(variableBasica);
        table.setVarNs(variables);
        data = table.getRowData();
        return table.simplexTable(fo, rest);
    }

    private void tratarFO(Ecuacion FO) {
        Monomio monomiosFO[] = FO.getMonomios();
        variables = new String[monomiosFO.length];

        for (int i = 0; i < monomiosFO.length; i++) {
            variables[i] = "" + monomiosFO[i].getVariable() + monomiosFO[i].getSubindice();
        }
        
        Monomio z = FO.getMonomioResultado();
        z.setCoeficiente(1);
        FO.setMonomioResultado(null);
        FO.setResultado(0);
        FO.addMonomio(z);
    }

    //TODO Freddy hacer que todas tengan la misma cantidad de variables
    private void tratarRestric(Ecuacion[] restricciones) {
        int tama = restricciones.length, countHolgura = 1;
        char holgura = 'h';

        tempVB = new String[0];

        for(int i = 0; i < restricciones.length; i++){
            for (int j = 1; j <= tama; j++) {
                restricciones[i].addMonomio(new Monomio(0, holgura, j, 1));
            }
        }

        for (int i = 0; i < tama; i++) {
            //Checando restricciones
            int igualdad = restricciones[i].getTipoIgualdad();
            
            switch (igualdad) {
                case Ecuacion.IGUAL:
                    //Se Conserva igual
                    break;
                case Ecuacion.MAYOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(Ecuacion.IGUAL);

                    if((i + 1) == countHolgura){
                        restricciones[i].getMonomio(i + numeroVariables).setCoeficiente(-1);
                        //restricciones[i].addMononio(new Monomio(-1, holgura, countHolgura));
                    }
                    
                    variableBasica = new String[tempVB.length + 1];
                    System.arraycopy(tempVB, 0, variableBasica, 0, tempVB.length);
                    variableBasica[tempVB.length] = "" + holgura + countHolgura;
                    tempVB = variableBasica;
                    countHolgura++;
                    break;
                case Ecuacion.MENOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(Ecuacion.IGUAL);

                    if((i + 1) == countHolgura){
                        restricciones[i].getMonomio(i + numeroVariables).setCoeficiente(1);
                        //restricciones[i].addMononio(new Monomio(1, holgura, countHolgura));
                    }

                    variableBasica = new String[tempVB.length + 1];
                    System.arraycopy(tempVB, 0, variableBasica, 0, tempVB.length);
                    variableBasica[tempVB.length] = "" + holgura + countHolgura;
                    tempVB = variableBasica;
                    countHolgura++;
                    break;
                default:
                    throw new IllegalArgumentException();                    
            }
        }
    }

    public String[] getVariableBasica() {
        return variableBasica;
    }

    public String[] getVariables() {
        return variables;
    }
    
    public String[][] getData() {
        return data;
    }
}

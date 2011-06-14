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
        tratarRestricciones(rest);
        SimplexTable table = new SimplexTable();
        table.setVarBasics(variableBasica);
        table.setVarNs(variables);
        data = table.getRowData();
        return table.simplexTable(fo, rest);
    }

    private void tratarFO(Ecuacion fo) {
        variables = new String[numeroVariables];
        int i = 0;

        for (Monomio monomio : fo.getMonomios()) {
            variables[i] = monomio.getVariable() + String.valueOf(monomio.getSubindice());
            ++i;
        }

        fo.addMonomio(fo.getMonomioResultado());
        fo.setMonomioResultado(null);
        fo.setResultado(0);
    }

    private void tratarRestricciones(Ecuacion[] restricciones) {
        int numRestricciones = restricciones.length, countHolgura = 1;
        char holgura = 'h';

        tempVB = new String[0];

        for (int i = 0; i < numRestricciones; i++) {
            if (restricciones[i].getMonomios().length < numeroVariables) {
                Monomio[] monomios = new Monomio[numeroVariables];
                for (int j = 0; j < monomios.length; j++) {
                    monomios[j] = new Monomio(variables[j]);
                    monomios[j].setCoeficiente(0);                    
                    for (int k = 0; k < restricciones[i].getMonomios().length; k++) {
                        if(monomios[j].getVariable() == restricciones[i].getMonomio(k).getVariable() && monomios[j].getSubindice() == restricciones[i].getMonomio(k).getSubindice()){
                            monomios[j].setCoeficiente(restricciones[i].getMonomio(k).getCoeficiente());
                        }                        
                    }
                }                
                restricciones[i].setMonomios(monomios);
            }
        }

        for (int i = 0; i < numRestricciones; i++) {
            for (int j = 1; j <= numRestricciones; j++) {
                restricciones[i].addMonomio(new Monomio(0, holgura, j, 1));
            }
        }

        for (int i = 0; i < numRestricciones; i++) {
            //Checando restricciones
            OperadorRelacional igualdad = restricciones[i].getTipoIgualdad();

            switch (igualdad) {
                case IGUAL:
                    //Se Conserva igual
                    break;
                case MAYOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(OperadorRelacional.IGUAL);

                    if ((i + 1) == countHolgura) {
                        restricciones[i].getMonomio(i + numeroVariables).setCoeficiente(-1);
                        //restricciones[i].addMononio(new Monomio(-1, holgura, countHolgura));
                    }

                    variableBasica = new String[tempVB.length + 1];
                    System.arraycopy(tempVB, 0, variableBasica, 0, tempVB.length);
                    variableBasica[tempVB.length] = "" + holgura + countHolgura;
                    tempVB = variableBasica;
                    countHolgura++;
                    break;
                case MENOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(OperadorRelacional.IGUAL);

                    if ((i + 1) == countHolgura) {
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
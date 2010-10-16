package simplex.resolvedor.mate;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marco
 */
public class Conversiones {

    private String varBasic[];
    private String tempVB[];
    private String var[];

    public DefaultTableModel conversiones(Ecuacion FO, Ecuacion[] rest) {
        tratarFO(FO);
        tratarRestric(rest);
        SimplexTable table = new SimplexTable();
        table.setVarBasics(varBasic);
        table.setVarNs(var);
        return table.simplexTable(FO, rest);
    }

    private void tratarFO(Ecuacion FO) {
        Monomio monomiosFO[] = FO.getMonomios();
        var = new String[monomiosFO.length];

        for (int i = 0; i < monomiosFO.length; i++) {
            var[i] = "" + monomiosFO[i].getVariable()
                    + monomiosFO[i].getSubindice();
            monomiosFO[i].setCoeciente(-1 * monomiosFO[i].getCoeficiente());
        }
        
        Monomio z = FO.getMonomioResultado();
        z.setCoeciente(1);
        FO.setMonomioResultado(null);
        FO.setResultado(0);
        FO.addMononio(z);

    }

    //TODO Freddy hacer que todas tengan la misma cantidad de variables
    private void tratarRestric(Ecuacion[] restricciones) {
        int tama = restricciones.length;
        tempVB = new String[0];
        char holgura = 'h';
        char artificial = 'a';
        int countHolgura = 1;
        int countArtificial = 1;
        for (int i = 0; i < tama; i++) {
            //Checando restricciones
            int igualdad = restricciones[i].getTipoIgualdad();
            switch (igualdad) {
                case Ecuacion.IGUAL:
                    //Se Conserva igual
                    break;
                case Ecuacion.MAYOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(Ecuacion.IGUAL);
                    restricciones[i].addMononio(new Monomio(-1, holgura, countHolgura));
                    varBasic = new String[tempVB.length + 1];
                    System.arraycopy(tempVB, 0, varBasic, 0, tempVB.length);
                    varBasic[tempVB.length] = "" + holgura + countHolgura;
                    tempVB = varBasic;
                    countHolgura++;
                    break;
                case Ecuacion.MENOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(Ecuacion.IGUAL);
                    restricciones[i].addMononio(new Monomio(1, holgura, countHolgura));
                    varBasic = new String[tempVB.length + 1];
                    System.arraycopy(tempVB, 0, varBasic, 0, tempVB.length);
                    varBasic[tempVB.length] = "" + holgura + countHolgura;
                    tempVB = varBasic;
                    countHolgura++;
                    break;
                default:
                    break;//TODO No hay variables de error para cachar
            }
        }
    }

    public String[] getVarBasic() {
        return varBasic;
    }

    public String[] getVar() {
        return var;
    }
}

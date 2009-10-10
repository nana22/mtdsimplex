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
            var[i] = Character.toString(monomiosFO[i].getVariable());
        }
        Monomio z = FO.getMonomioResultado();
        z.setCoeciente(-1);
        FO.setMonomioResultado(null);
        FO.setResultado(0);
        FO.addMononio(z);
    }

    private void tratarRestric(Ecuacion[] restricciones) {
        int tama = restricciones.length;
        tempVB = new String[0];
        char holgura = 'c';
        for (int i = 0; i < tama; i++) {
            //Checando restricciones
            int igualdad = restricciones[i].getTipoIgualdad();
            switch (igualdad) {
                case Ecuacion.IGUAL:
                    //Se Conserva igual
                    break;
                case Ecuacion.MAYOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(Ecuacion.IGUAL);
                    restricciones[i].addMononio(new Monomio(-1, holgura));
                    varBasic = new String[tempVB.length + 1];
                    for (int j = 0; j < tempVB.length; j++) {
                        varBasic[j] = tempVB[j];
                    }
                    varBasic[tempVB.length] = Character.toString(holgura);
                    tempVB = varBasic;
                    holgura++;
                    break;
                case Ecuacion.MENOR_IGUAL_QUE:
                    restricciones[i].setTipoIgualdad(Ecuacion.IGUAL);
                    restricciones[i].addMononio(new Monomio(1, holgura));
                    varBasic = new String[tempVB.length + 1];
                    for (int j = 0; j < tempVB.length; j++) {
                        varBasic[j] = tempVB[j];
                    }
                    varBasic[tempVB.length] = Character.toString(holgura);
                    tempVB = varBasic;
                    holgura++;
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
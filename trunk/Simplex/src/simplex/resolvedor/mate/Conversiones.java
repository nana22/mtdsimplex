package simplex.resolvedor.mate;
/**
 *
 * @author Marco
 */


public class Conversiones {

private String varBasic[];
private String tempVB[];
private String var[];

    public Conversiones( Ecuacion FO, Ecuacion [] rest ){
        tratarFO(FO);
        tratarRestric(rest);
    }
    public void tratarFO( Ecuacion FO ){
        Monomio monomiosFO[] = FO.getMonomios();
        var = new String[monomiosFO.length];
        for (int i=0; i<monomiosFO.length; i++){
            var[i] = Character.toString(monomiosFO[i].getVariable());
        }
        Monomio z = FO.getMonomioResultado();
        z.setCoeciente(-1);
        FO.setMonomioResultado(null);
        FO.setResultado(0);
        FO.addMononio(z);
    }
    
    public void tratarRestric( Ecuacion [] restricciones){
        int tama = restricciones.length;
        for (int i=0; i<tama; i++){
            //Checando restricciones
            int igualdad = restricciones[i].getTipoIgualdad();
            char holgura = 99;
            switch (igualdad){
                case 0: 
                    //Se Conserva igual
                    break;
                case 3:
                    restricciones[i].setTipoIgualdad(0);
                    restricciones[i].addMononio( new Monomio( -1 , holgura ));
                    varBasic = new String[tempVB.length+1];
                    for (int j=0; j<tempVB.length; j++){
                        varBasic[j] = tempVB[j];
                    }
                    varBasic[tempVB.length] = Character.toString(holgura);
                    tempVB = varBasic;
                    holgura++;
                    break;
                case 4:
                    restricciones[i].setTipoIgualdad(0);
                    restricciones[i].addMononio( new Monomio( 1 , holgura ));
                    varBasic = new String[tempVB.length+1];
                    for (int j=0; j<tempVB.length; j++){
                        varBasic[j] = tempVB[j];
                    }
                    varBasic[tempVB.length] = Character.toString(holgura);
                    tempVB = varBasic;
                    holgura++;
                    break;
                default: ;//TODO No hay variables de error para cachar
            }
        }
    }
    public String[] getVarBasic(){
        return varBasic;
    }
    public String[] getVar(){
        return var;
    }
}

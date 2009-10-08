package simplex.resolvedor.mate;



public class Conversiones {

    public Conversiones( Ecuacion FO ){
        tratarFO(FO);
    }
    public void tratarFO( Ecuacion FO ){
        Monomio funcion[] = FO.getMonomios();
        Monomio z = FO.getMonomioResultado();
        z.setCoeciente(-1);
        FO.setMonomioResultado(null);
        FO.setResultado(0);
        FO.addMononio(z);
    }
    public void tratarRestric( Ecuacion restricciones[]){
        
    }
}

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
        int tama = restricciones.length;
        for (int i=0; i<tama; i++){
            //Checando restricciones
            int igualdad = restricciones[i].getTipoIgualdad();
            switch (igualdad){
                case 0:  break;
                case 3:  break;
                case 4:  break;
            }
        }
    }
}

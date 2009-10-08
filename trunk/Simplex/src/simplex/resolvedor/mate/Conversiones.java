package simplex.resolvedor.mate;



public class Conversiones {

    public Conversiones( Ecuacion FO, Ecuacion rest[] ){
        tratarFO(FO);
        tratarRestric( rest[] );
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
            char holgura = 64;
            switch (igualdad){
                case 0: 
                    //Se Conserva igual
                    break;
                case 3:
                    restricciones[i].setTipoIgualdad(0);
                    restricciones[i].addMononio( new Monomio( holgura ));
                    holgura++;
                    break;
                case 4:
                    restricciones[i].setTipoIgualdad(0);
                    restricciones[i].addMononio( new Monomio( holgura ));
                    holgura++;
                    break;
                default: ;
            }
        }
    }
}

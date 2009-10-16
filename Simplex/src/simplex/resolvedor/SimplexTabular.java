/*
 * @(#)SimplexTabular.java 1.0 12/10/2009
 * @charset "utf-8";
 * Copyright (c) pendiente.
 * 
 */

package simplex.resolvedor;

import simplex.resolvedor.mate.Ecuacion;

/**
 *
 * @author Neo Cs
 * @version 1.0, 12/10/2009
 */
public class SimplexTabular {
    Ecuacion funcionObjetivo, restriciones[];
    
    public SimplexTabular(Ecuacion funcionObjetivo, Ecuacion rest[]){
        this.funcionObjetivo = funcionObjetivo;
        
    }
    public void maximizar(){
        igualarCero();


    }

    private void igualarCero(){
        for(int i = 0; i< funcionObjetivo.getMonomios().length; i++){
            funcionObjetivo.getMonomios()[i].setCoeciente(-funcionObjetivo.getMonomios()[i].getCoeficiente());
        }
        funcionObjetivo.addMononio(funcionObjetivo.getMonomioResultado());
        funcionObjetivo.setMonomioResultado(null);
        funcionObjetivo.setResultado(0);
    }

}
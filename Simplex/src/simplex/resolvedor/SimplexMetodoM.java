/*
 *  @(#)SimplexMetodoM.java  05/10/2010
 *  @charset "UTF-8";
 * 
 *  Copyright (c) 2010 Freddy. All Rights Reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 * 
 *  -Redistribution of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 *  -Redistribution in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 *  Neither the name of Freddy or the names of contributors may
 *  be used to endorse or promote products derived from this software without
 *  specific prior written permission.
 * 
 *  This software is provided "AS IS," without a warranty of any kind. ALL
 *  EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND WARRANTIES, INCLUDING
 *  ANY IMPLIED WARRANTY OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE
 *  OR NON-INFRINGEMENT, ARE HEREBY EXCLUDED. Freddy
 *  AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE
 *  AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 *  DERIVATIVES. IN NO EVENT WILL Freddy OR ITS LICENSORS BE LIABLE FOR ANY LOST
 *  REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT, SPECIAL, CONSEQUENTIAL,
 *  INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER CAUSED AND REGARDLESS OF THE THEORY
 *  OF LIABILITY, ARISING OUT OF THE USE OF OR INABILITY TO USE THIS SOFTWARE,
 *  EVEN IF Freddy HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 *  You acknowledge that this software is not designed, licensed or intended
 *  for use in the design, construction, operation or maintenance of any
 *  nuclear facility.
 */

package simplex.resolvedor;

import java.util.ArrayList;
import java.util.List;
import simplex.resolvedor.mate.Ecuacion;
import simplex.resolvedor.mate.Monomio;

/**
 *
 * @author Freddy
 */
public class SimplexMetodoM implements Simplex{

    private static char VARIABLE_HOLGURA = 'h';
    private static char VARIABLE_ARTIFICIAL = 'a';
    private static int M = 1000;
    private int countVariableHolgura = 1;
    private int countVariableArtificial = 1;

    private void modificarRestricciones(Ecuacion[] restricciones){
        for (int i = 0; i < restricciones.length; i++) {
            switch(restricciones[i].getTipoIgualdad()){
                case Ecuacion.IGUAL:
                    restricciones[i].addMonomio(new Monomio(VARIABLE_ARTIFICIAL, countVariableArtificial));
                    countVariableArtificial++;
                    break;
                case Ecuacion.MAYOR_IGUAL_QUE:
                    restricciones[i].addMonomio(new Monomio(-1,VARIABLE_HOLGURA, countVariableHolgura));
                    restricciones[i].addMonomio(new Monomio(VARIABLE_ARTIFICIAL,countVariableArtificial));
                    countVariableArtificial++;
                    countVariableHolgura++;
                    break;
                case Ecuacion.MENOR_IGUAL_QUE:
                    restricciones[i].addMonomio(new Monomio(VARIABLE_HOLGURA, countVariableHolgura));
                    countVariableHolgura++;
                    break;
            }
        }
    }

    private void agregarM(Ecuacion funcionObjetivo, boolean esMaximizar){
        if(esMaximizar){
            for(int i = 1; i <= countVariableArtificial; i++){
                funcionObjetivo.addMonomio(new Monomio(-M, VARIABLE_ARTIFICIAL, i));
            }
        } else {
            for(int i = 1; i <= countVariableArtificial; i++){
                funcionObjetivo.addMonomio(new Monomio(M, VARIABLE_ARTIFICIAL, i));
            }
        }
    }

    private void igualarACero(Ecuacion funcionObjetivo, Ecuacion[] restricciones, boolean esMaximizar){
        if(esMaximizar){
        } else {
            for (int i = 0; i < funcionObjetivo.getMonomios().length; i++){
                double nuevoCoeficiente = funcionObjetivo.getMonomio(i).getCoeficiente() * -1;
                funcionObjetivo.getMonomio(i).setCoeficiente(nuevoCoeficiente);
            }
            List lista = new ArrayList();
            for (int i = 0; i  < restricciones.length; i++){
                for (int j = 0; j < restricciones[i].getMonomios().length; j++){
                    if (restricciones[i].getMonomio(j).getVariable() == VARIABLE_ARTIFICIAL){
                        lista.add(restricciones[i]);
                        break;
                    }
                }
            }
            //TODO Multiplicar po M cada Ecuacion
            for(int i = 0; i < lista.size(); i++){
                Ecuacion ec = (Ecuacion) lista.get(i);
                for (int j = 0; j < ec.getMonomios().length; j++){

                }
            }
        }
    }

    private void buscarSaliente(){

    }

    private void buscarEntrante(){

    }

    public double[] maximizar(Ecuacion funcionObjetivo, Ecuacion[] restricciones) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double[] minimizar(Ecuacion funcionObjetivo, Ecuacion[] restricciones) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

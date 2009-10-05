/*
 * (#)Ecuacion.java 1.2
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */

package simplex.resolvedor.mate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Esta clase es la que realiza las operaciones y devuelve los resultados para
 * que sean graficados.
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.3
 */

public class Ecuacion {

   public static final int IGUAL = 0;
   public static final int MENOR_QUE = 1;
   public static final int MAYOR_QUE = 2;
   public static final int MAYOR_IGUAL_QUE = 3;
   public static final int MENOR_IGUAL_QUE = 4;
   private int tipoIgualdad;
   private Monomio [] monomios;
   private int resultado;

   /**
    *
    * @param monomios
    * @param tipoIgudad
    * @param resultado
    */
    public Ecuacion(Monomio [] monomios, int tipoIgualdad, int resultado){
       setMonomios(monomios);
       setResultado(resultado);
       setTipoIgualdad(tipoIgualdad);
   }

    /**
     * @return the tipoIgualdad
     */
    public int getTipoIgualdad() {
        return tipoIgualdad;
    }

    /**
     * @param tipoIgualdad the tipoIgualdad to set
     */
    public void setTipoIgualdad(int tipoIgualdad) {
        switch(tipoIgualdad){
            case IGUAL:
            case MAYOR_QUE:
            case MENOR_QUE:
            case MAYOR_IGUAL_QUE:
            case MENOR_IGUAL_QUE:
                this.tipoIgualdad = tipoIgualdad;
            break;
            default:
                try {
                    throw new Exception("Error tipo desigualdad o igualdad invalida");
                } catch (Exception ex) {
                    Logger.getLogger(Ecuacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
        }
    }

    /**
     * @return the monomios
     */
    public Monomio[] getMonomios() {
        return monomios;
    }

    /**
     * @param monomios the monomios to set
     */
    public void setMonomios(Monomio[] monomios) {
        this.monomios = monomios;
    }

    /**
     * @return the resultado
     */
    public int getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public void agregarMononio(Monomio monomio){
        int a = this.monomios.length + 1;
        Monomio [] monomiosAntiguos = this.monomios;
        Monomio [] monomiosNuevo = new Monomio[a];

        try{
        for (int i= 0; i < a-1; i++){
            monomiosNuevo[i] = monomiosAntiguos [i];
        }
        monomiosNuevo[a] = monomio;
        this.monomios = monomiosNuevo;
        }catch(Exception e){
            this.monomios = monomiosAntiguos;
            e.printStackTrace();
        }


    }

}

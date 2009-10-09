/*
 * (#)Ecuacion.java 1.2
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */

package simplex.resolvedor.mate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
   private List <Monomio> monomios;  
   private Monomio monomioResultado;
   private int resultado;

   /**
    *
    * @param monomios
    * @param tipoIgualdad
    * @param resultado
    */
   public Ecuacion(Monomio [] monomios, int tipoIgualdad, int resultado){
       setMonomios(monomios);
       setResultado(resultado);
       setTipoIgualdad(tipoIgualdad);
   }

    /**
     *
     * @param monomios
     * @param tipoIgualdad
     * @param monomioResultado
     */
    public Ecuacion (Monomio [] monomios, int tipoIgualdad, Monomio monomioResultado){
        setMonomioResultado(monomioResultado);
        setMonomios(monomios);
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
        Monomio [] monomiosC = new Monomio[this.monomios.size()];
        int temp=0;
        for(Iterator<Monomio> i = this.monomios.iterator(); i.hasNext(); ){
            monomiosC[temp] = i.next();
            temp++;
        }
        return monomiosC;
    }

    /**
     * @param monomios the monomios to set
     */
    public void setMonomios(Monomio[] monomios) {
        this.monomios = new ArrayList<Monomio>();
        for(Monomio i: monomios){
            addMononio(i);
        }
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

    public void addMononio(Monomio monomio){
        monomios.add(monomio);
    }

    /**
     * @return the monomioResultado
     */
    public Monomio getMonomioResultado() {
        return monomioResultado;
    }

    /**
     * @param monomioResultado the monomioResultado to set
     */
    public void setMonomioResultado(Monomio monomioResultado) {
        this.monomioResultado = monomioResultado;
    }
}

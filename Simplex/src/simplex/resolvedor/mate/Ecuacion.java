/*
 * @(#)Ecuacion.java 1.7.1 10/10/09
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */
package simplex.resolvedor.mate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Esta clase es la que realiza las operaciones y devuelve los resultados para
 * que sean graficados.
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.7.1, 10/10/09
 */
public class Ecuacion {

    public static final int IGUAL = 0;
    public static final int MENOR_QUE = 1;
    public static final int MAYOR_QUE = 2;
    public static final int MAYOR_IGUAL_QUE = 3;
    public static final int MENOR_IGUAL_QUE = 4;
    private int tipoIgualdad;
    private List<Monomio> monomios;
    private Monomio monomioResultado;
    private int resultado;

    /**
     *
     * @param monomios
     * @param tipoIgualdad
     * @param resultado
     */
    public Ecuacion(Monomio[] monomios, int tipoIgualdad, int resultado) {
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
    public Ecuacion(Monomio[] monomios, int tipoIgualdad, Monomio monomioResultado) {
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
        switch (tipoIgualdad) {
            case IGUAL:
            case MAYOR_QUE:
            case MENOR_QUE:
            case MAYOR_IGUAL_QUE:
            case MENOR_IGUAL_QUE:
                this.tipoIgualdad = tipoIgualdad;
                break;
            default:
                throw new IllegalArgumentException("Error tipo desigualdad o igualdad invalida");
        }
    }

    /**
     * @return the monomios
     */
    public Monomio[] getMonomios() {
        return monomios.toArray(new Monomio[0]);
    }

    /**
     * @param monomios the monomios to set
     */
    public void setMonomios(Monomio[] monomios) {
        this.monomios = new ArrayList<Monomio>();
        if (monomios != null) {
            for (Monomio i : monomios) {
                addMonomio(i);
            }
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

    /**
     * Añade un <tt>Monomio</tt> al objeto <tt>Ecuacion</tt>
     * 
     * @param monomio {@code Monomio}
     */
    public void addMonomio(Monomio monomio) {
        monomios.add(monomio);
    }

    /**
     *
     * @param index
     * @return the Monomio
     */
    public Monomio getMonomio(int index) {
        return monomios.get(index);
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

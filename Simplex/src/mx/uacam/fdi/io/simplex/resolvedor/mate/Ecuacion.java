/*
 * @(#)Ecuacion.java 1.7.1 10/10/09
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */
package mx.uacam.fdi.io.simplex.resolvedor.mate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Esta clase es la que realiza las operaciones y devuelve los resultados para
 * que sean graficados.
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.7.1, 10/10/09
 */
public class Ecuacion implements Serializable{
    
    private static final long serialVersionUID = 5601572475251277384L;
    private OperadorRelacional tipoIgualdad;
    private List<Monomio> monomios;
    private Monomio monomioResultado;
    private int resultado;

    /**
     * 
     * @param unaEcuacion 
     */
    public Ecuacion(String unaEcuacion) {
        unaEcuacion = unaEcuacion.trim();
        unaEcuacion = unaEcuacion.toLowerCase();

        String[] cadenaNueva = unaEcuacion.split("<=");
        if (cadenaNueva.length == 2) {
            tipoIgualdad = OperadorRelacional.MENOR_IGUAL_QUE;
        } else if ((cadenaNueva = unaEcuacion.split(">=")).length == 2) {
            tipoIgualdad = OperadorRelacional.MAYOR_IGUAL_QUE;
        } else if ((cadenaNueva = unaEcuacion.split("=")).length == 2) {
            tipoIgualdad = OperadorRelacional.IGUAL;
        } else if ((cadenaNueva = unaEcuacion.split(">")).length == 2) {
            tipoIgualdad = OperadorRelacional.MAYOR_QUE;
        } else if ((cadenaNueva = unaEcuacion.split("<")).length == 2) {
            tipoIgualdad = OperadorRelacional.MENOR_QUE;
        } else {
            throw new IllegalArgumentException("Ecuación no valida: " + unaEcuacion);
        }

        String regexMonomio = "([-\\+]*\\d*[a-y]\\d+)";
        Pattern p = Pattern.compile(regexMonomio);
        Matcher m = p.matcher(unaEcuacion);

        List<Monomio> monomios = new ArrayList<Monomio>();
        while (m.find()) {
            String group = m.group();            
            monomios.add(new Monomio(group));
        }

        this.monomios = monomios;

        if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
            try {                
                resultado = Integer.parseInt(cadenaNueva[0]);
            } catch (NumberFormatException ex) {                
                monomioResultado = new Monomio(cadenaNueva[0]);
            }            
        } else {
            try {                
                resultado = Integer.parseInt(cadenaNueva[1]);
            } catch (NumberFormatException ex) {                
                monomioResultado = new Monomio(cadenaNueva[1]);
            }
        }
    }

    /**
     *
     * @param monomios
     * @param tipoIgualdad
     * @param resultado
     */
    public Ecuacion(Monomio[] monomios, OperadorRelacional tipoIgualdad, int resultado) {
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
    public Ecuacion(Monomio[] monomios, OperadorRelacional tipoIgualdad, Monomio monomioResultado) {
        setMonomioResultado(monomioResultado);
        setMonomios(monomios);
        setTipoIgualdad(tipoIgualdad);
    }

    /**
     * @return the tipoIgualdad
     */
    public OperadorRelacional getTipoIgualdad() {
        return tipoIgualdad;
    }

    /**
     * @param tipoIgualdad the tipoIgualdad to set
     */
    public void setTipoIgualdad(OperadorRelacional tipoIgualdad) {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ecuacion other = (Ecuacion) obj;
        if (this.tipoIgualdad != other.tipoIgualdad) {
            return false;
        }
        if (this.monomios != other.monomios && (this.monomios == null || !this.monomios.equals(other.monomios))) {
            return false;
        }
        if (this.monomioResultado != other.monomioResultado && (this.monomioResultado == null || !this.monomioResultado.equals(other.monomioResultado))) {
            return false;
        }
        if (this.resultado != other.resultado) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.tipoIgualdad != null ? this.tipoIgualdad.hashCode() : 0);
        hash = 67 * hash + (this.monomios != null ? this.monomios.hashCode() : 0);
        hash = 67 * hash + (this.monomioResultado != null ? this.monomioResultado.hashCode() : 0);
        hash = 67 * hash + this.resultado;
        return hash;
    }

    @Override
    public String toString() {
        return "Ecuacion{ monomios=" + monomios + ", tipoIgualdad=" + tipoIgualdad + ", monomioResultado=" + monomioResultado + ", resultado=" + resultado + '}';
    }
}
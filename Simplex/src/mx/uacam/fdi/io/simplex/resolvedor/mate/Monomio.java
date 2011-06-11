/*
 * @(#)Monomio.java 1.2.3 10/10/09
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */
package mx.uacam.fdi.io.simplex.resolvedor.mate;

import java.io.Serializable;

/**
 * <p>La clase <code>Monomio</code> describe a un monomio matemático con cada una 
 * de sus partes como lo son el coeficiente, la variable y el exponente.</p>
 * 
 * <p>Se considero que los exponestes de esta clase podian ser fracionario y 
 * negativos.</p>
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.2.3, 10/10/09
 */
public class Monomio implements Comparable<Monomio>, Serializable {

    private static final long serialVersionUID = 4616250324575701847L;
    private double coeficiente;
    private double exponente;
    private char variable;
    private int subindice;

    public Monomio(double coeficiente, char variable, int subindice, double exponente) {
        setCoeficiente(coeficiente);
        setVariable(variable);
        setSubindice(subindice);
        setExponente(exponente);
    }

    /**
     *
     * @param coeficiente
     * @param variable
     * @param exponente
     */
    public Monomio(double coeficiente, char variable, double exponente) {
        this(coeficiente, variable, 1, exponente);
    }

    /**
     *
     * @param coeficiente
     * @param variable
     */
    public Monomio(double coeficiente, char variable) {
        this(coeficiente, variable, 1.0);
    }

    /**
     *
     * @param variable
     * @param exponente
     */
    public Monomio(char variable, double exponente) {
        this(1, variable, exponente);
    }

    /**
     *
     * @param variable
     */
    public Monomio(char variable, int subindice) {
        this(1, variable, subindice, 1);
    }

    /**
     *
     * @param variable
     */
    public Monomio(char variable) {
        this(1, variable);
    }

    /**
     * @return the constante
     */
    public double getCoeficiente() {
        return coeficiente;
    }

    /**
     * @param constanate the constante to set
     */
    public void setCoeficiente(double constanate) {
        this.coeficiente = constanate;
    }

    /**
     * @return the variable
     */
    public char getVariable() {
        return variable;
    }

    /**
     * @param variable the variable to set
     */
    public void setVariable(char variable) {
        this.variable = variable;
    }

    /**
     * Get the value of subindice
     *
     * @return the value of subindice
     */
    public int getSubindice() {
        return subindice;
    }

    /**
     * Set the value of subindice
     *
     * @param subindice new value of subindice
     */
    public void setSubindice(int subindice) {
        this.subindice = subindice;
    }

    /**
     * @return the exponente
     */
    public double getExponente() {
        return exponente;
    }

    /**
     * @param exponente the exponente to set
     */
    public void setExponente(double exponente) {
        this.exponente = exponente;
    }

//TODO Implementar metodo compareTo(Monomio monomio)
    @Override
    public int compareTo(Monomio monomio) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Monomio) {
            return object.hashCode() == hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.coeficiente) ^ (Double.doubleToLongBits(this.coeficiente) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.exponente) ^ (Double.doubleToLongBits(this.exponente) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.subindice) ^ (Double.doubleToLongBits(this.subindice) >>> 32));
        hash = 37 * hash + this.variable;
        return hash;
    }

    @Override
    public String toString() {
        return String.valueOf(coeficiente) + String.valueOf(variable) + String.valueOf(subindice) + '^' + String.valueOf(exponente);
    }
}

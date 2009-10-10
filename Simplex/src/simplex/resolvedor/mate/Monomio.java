/*
 * @(#)Monomio.java 1.2.3 10/10/09
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */

package simplex.resolvedor.mate;

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
public class Monomio {

    //TODO Cambiar la definicion de coeficiente a double pues un coefieciente puede ser fraccionario
    private int coeficiente;
    private double exponente;
    private char variable;

    /**
     *
     * @param coeficiente
     * @param variable
     * @param exponente
     */
    public Monomio(int coeficiente, char variable, double exponente){
        setCoeciente(coeficiente);
        setExponente(exponente);
        setVariable(variable);
    }

    /**
     *
     * @param coeficiente
     * @param variable
     */
    public Monomio(int coeficiente, char variable){
        this(coeficiente, variable, 1.0);
    }

    /**
     *
     * @param variable
     */
    public Monomio(char variable){
        this(1, variable);
    }

    /**
     *
     * @param variable
     * @param exponente
     */
    public Monomio(char variable, double exponente) {
        this(1,variable,exponente);
    }

    /**
     * @return the constante
     */
    public int getCoeficiente() {
        return coeficiente;
    }

    /**
     * @param constanate the constante to set
     */
    public void setCoeciente(int constanate) {
        this.coeficiente = constanate;
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

}

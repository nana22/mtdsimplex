/*
 * @(#)ValidarEcuacion.java 2.0.2 10/10/09
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */
package mx.uacam.fdi.io.simplex.ui.recursos;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import org.neocs.mate.fracciones.Fraccion;
import mx.uacam.fdi.io.simplex.resolvedor.mate.Ecuacion;
import mx.uacam.fdi.io.simplex.resolvedor.mate.Monomio;

/**
 *
 * Esta clase prepara los datos que el usuario ingresa sin formato, dandole un
 * un formato que permita la operacion de una manera más sencilla.
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 2.0.2 10/10/09
 */
public class ValidadorEcuacion {

    /** Ecuacion que será devuelta por {@link #validar(java.lang.String)} */
    private Ecuacion ecuacion;

    /**
     * Crea una <tt>Ecuacion</tt> a partir de un <tt>String</tt>.
     *
     * @param un string {@code String} por ejemplo: "3x + 8y = 12"
     * @return {@code Ecuacion}
     */
    public Ecuacion validar(String string) {
        //TODO: la creacion de la ecuacion tiene un monomio adicional incorrecto
        ecuacion = new Ecuacion(null, Ecuacion.IGUAL, null);
        string = string.trim();
        string = string.toLowerCase();

        String[] cadenaNueva = string.split("<=");
        if (cadenaNueva.length == 2) {
            ecuacion.setTipoIgualdad(Ecuacion.MENOR_IGUAL_QUE);
        } else if ((cadenaNueva = string.split(">=")).length == 2) {
            ecuacion.setTipoIgualdad(Ecuacion.MAYOR_IGUAL_QUE);
        } else if ((cadenaNueva = string.split("=")).length == 2) {
            ecuacion.setTipoIgualdad(Ecuacion.IGUAL);
        } else if ((cadenaNueva = string.split(">")).length == 2) {
            ecuacion.setTipoIgualdad(Ecuacion.MAYOR_QUE);
        } else if ((cadenaNueva = string.split("<")).length == 2) {
            ecuacion.setTipoIgualdad(Ecuacion.MENOR_QUE);
        } else {
            throw new IllegalArgumentException("Ecuación no valida: " + string);
        }

        //TODO Apoyandose en expresiones regulares se pueden localizar los monomios, solo se necesitaria que monomio se construya apartir de un String
        /*
        String regexMonomio = "([-\\+]*\\d*[a-y]\\d+)";
        Pattern p = Pattern.compile(regexMonomio);
        Matcher m = p.matcher("6x3+7y1-x1=12");
        while (m.find()) {
        String group = m.group();
        int start = m.start();
        int end = m.end();
        System.out.println(group);            
        }
         */
        
        if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
            buscarResultado(cadenaNueva[0]);
            buscarMonomios(cadenaNueva[1]);
        } else {
            buscarResultado(cadenaNueva[1]);
            buscarMonomios(cadenaNueva[0]);
        }

        return ecuacion;
    }

    /**
     * 
     * @param string
     */
    private void buscarResultado(String string) {
        try {
            ecuacion.setResultado(Integer.parseInt(string));
        } catch (NumberFormatException ex) {
            if (string.length() != 1) {
                Deque cola = new ArrayDeque<Character>();
                Stack pila = new Stack();

                for (Character c : string.toCharArray()) {
                    cola.add(c);
                }

                do {
                    Character c = (Character) cola.poll();
                    if (c == '-') {
                        do {
                            pila.add(c);
                            c = (Character) cola.poll();
                        } while (Character.isDigit(c) || c == '/');
                        cola.addFirst(c);
                    } else if (esLetra(c)) {
                        if (!pila.isEmpty()) {
                            Monomio monomio = new Monomio(c);
                            String s = "";

                            for (int i = 0; i < pila.size(); i++) {
                                s += (Character) pila.get(i);
                            }

                            pila.clear();

                            if (s.contains("/")) {
                                Fraccion f = new Fraccion(s);
                                double d = (double) f.getNumerador() / (double) f.getDenominador();
                                monomio.setCoeficiente(d);
                            } else {
                                double value = Double.valueOf(s);
                                monomio.setCoeficiente(value);
                            }
                            c = (Character) cola.poll();

                            if (Character.isDigit(c)) {
                                s = "" + c;
                                int subindice = Integer.parseInt(s);
                                monomio.setSubindice(subindice);
                            } else {
                                cola.addFirst(c);
                            }

                            ecuacion.setMonomioResultado(monomio);
                            ecuacion.setResultado(0);
                        }
                    }
                } while (!cola.isEmpty());

            } else {
                ecuacion.setMonomioResultado(new Monomio(string.charAt(0)));
                ecuacion.setResultado(0);
            }
        }
    }

    /**
     *
     * @param string
     */
    private void buscarMonomios(String string) {
        Deque cola = new ArrayDeque<Character>();
        Stack pila = new Stack();

        for (Character c : string.toCharArray()) {
            cola.add(c);
        }

        do {
            Character c = (Character) cola.poll();
            if (c == '-') {
                do {
                    pila.add(c);
                    c = (Character) cola.poll();
                } while (Character.isDigit(c) || c == '/');
                cola.addFirst(c);
            } else if (Character.isDigit(c)) {
                do {
                    pila.add(c);
                    c = (Character) cola.poll();
                } while (Character.isDigit(c) || c == '/');
                cola.addFirst(c);
            } else if (esLetra(c)) {
                if (!pila.isEmpty()) {
                    Monomio monomio = new Monomio(c);
                    String s = "";

                    for (int i = 0; i < pila.size(); i++) {
                        s += (Character) pila.get(i);
                    }

                    pila.clear();

                    if (s.contains("/")) {
                        Fraccion f = new Fraccion(s);
                        double d = (double) f.getNumerador() / (double) f.getDenominador();
                        monomio.setCoeficiente(d);
                    } else {
                        double value = Double.valueOf(s);
                        monomio.setCoeficiente(value);
                    }
                    c = (Character) cola.poll();

                    if (Character.isDigit(c)) {
                        s = "" + c;
                        int subindice = Integer.parseInt(s);
                        monomio.setSubindice(subindice);
                    } else {
                        cola.addFirst(c);
                    }

                    ecuacion.addMonomio(monomio);
                } else {
                    Monomio monomio = new Monomio(c);
                    c = (Character) cola.poll();

                    if (Character.isDigit(c)) {
                        String s = "" + c;
                        int subindice = Integer.parseInt(s);
                        monomio.setSubindice(subindice);
                    } else {
                        cola.addFirst(c);
                    }

                    ecuacion.addMonomio(monomio);
                }
            }
        } while (!cola.isEmpty());
    }

    private boolean esLetra(char c) {
        return ((c >= 'a') && (c <= 'z'));
    }
}

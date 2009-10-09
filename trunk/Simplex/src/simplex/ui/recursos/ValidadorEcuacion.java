/*
 * (#)ValidarEcuacion.java 1.15
 * @charset "utf-8";
 * Copyright (c) pendiente.
 */
package simplex.ui.recursos;

import java.util.Stack;
import simplex.resolvedor.mate.Ecuacion;
import simplex.resolvedor.mate.Monomio;

/**
 *
 * Esta clase prepara los datos que el usuario ingresa sin formato, dandole un
 * un formato que permita la operacion de una manera más sencilla.
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.17
 */
public class ValidadorEcuacion {

    private Monomio[] monomios;
    private Ecuacion ecuacion;

    public Ecuacion validar(String string) {
        ecuacion = new Ecuacion(new Monomio[]{new Monomio('x')}, Ecuacion.IGUAL, null);
        string = string.trim();
        string = string.toLowerCase();

        String[] cadenaNueva = string.split("<=");
        if (cadenaNueva.length == 2) {
            ecuacion.setResultado(Ecuacion.MENOR_IGUAL_QUE);
            if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                buscarResultado(cadenaNueva[0]);
                buscarMonomios(cadenaNueva[1]);
            } else {
                buscarResultado(cadenaNueva[1]);
                buscarMonomios(cadenaNueva[0]);
            }
        } else {
            cadenaNueva = string.split(">=");
            if (cadenaNueva.length == 2) {
                ecuacion.setResultado(Ecuacion.MAYOR_IGUAL_QUE);
                if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                    buscarResultado(cadenaNueva[0]);
                    buscarMonomios(cadenaNueva[1]);
                } else {
                    buscarResultado(cadenaNueva[1]);
                    buscarMonomios(cadenaNueva[0]);
                }
            } else {
                cadenaNueva = string.split("=");
                if (cadenaNueva.length == 2) {
                    ecuacion.setResultado(Ecuacion.IGUAL);
                    if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                        buscarResultado(cadenaNueva[0]);
                        buscarMonomios(cadenaNueva[1]);
                    } else {
                        buscarResultado(cadenaNueva[1]);
                        buscarMonomios(cadenaNueva[0]);
                    }
                } else {
                    cadenaNueva = string.split(">");
                    if (cadenaNueva.length == 2) {
                        ecuacion.setResultado(Ecuacion.MAYOR_QUE);
                        if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                            buscarResultado(cadenaNueva[0]);
                            buscarMonomios(cadenaNueva[1]);
                        } else {
                            buscarResultado(cadenaNueva[1]);
                            buscarMonomios(cadenaNueva[0]);
                        }
                    } else {
                        ecuacion.setResultado(Ecuacion.MENOR_QUE);
                        if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                            buscarResultado(cadenaNueva[0]);
                            buscarMonomios(cadenaNueva[1]);
                        } else {
                            buscarResultado(cadenaNueva[1]);
                            buscarMonomios(cadenaNueva[0]);
                        }
                    }
                }
            }
        }
        return ecuacion;
    }

    private void buscarResultado(String string) {
        try {
            ecuacion.setResultado(Integer.parseInt(string));
        } catch (NumberFormatException ex) {

            Stack<Character> stVariable = new Stack<Character>();
            Stack<Character> stConstantes = new Stack<Character>();

            for (int i = 0; i < string.length(); i++) {
                if ((string.charAt(i) >= 'a') && (string.charAt(i) >= 'z')) {
                    stVariable.push(string.charAt(i));
                } else {
                    stConstantes.push(string.charAt(i));
                }
            }

            String t = "";
            int lenConstantes = stConstantes.size();
            for (int i = 0; i < lenConstantes; i++) {
                t += stConstantes.pop();
            }
            t = volter(t);
            int a = Integer.parseInt(t);
            ecuacion.setMonomioResultado(new Monomio(a, stVariable.pop()));
            ecuacion.setResultado(0);
        }
    }

    /**
     *
     * @param string
     */
    private void buscarMonomios(String string) {
        Stack<Character> stVariables = new Stack<Character>();
        Stack<Character> stCoeficientesTmp = new Stack<Character>();
        Stack<Integer> stCoeficientes = new Stack<Integer>();
        Stack<Integer> coeficientes = new Stack<Integer>();
        int numCoeficientes, lengthString = string.length() -1;
        String tmp = "";

        do {
            if ((string.charAt(lengthString) >= 'a') && (string.charAt(lengthString) <= 'z')) {
                stVariables.push(string.charAt(lengthString));
            } else {
                stCoeficientesTmp.push(string.charAt(lengthString));
            }
            lengthString--;
        } while (lengthString != -1);

        do {
            if ((stCoeficientesTmp.peek() == '-') || (stCoeficientesTmp.peek() == '+')) {
                if (tmp.length() != 0) {
                    coeficientes.push(Integer.parseInt(tmp));
                    tmp = "";
                } else if (stCoeficientesTmp.peek() == '+') {
                    stCoeficientesTmp.pop();
                } else {
                    tmp += stCoeficientesTmp.pop();
                }
            } else {
                tmp += stCoeficientesTmp.pop();
            }
        } while (!stCoeficientesTmp.isEmpty());

        if (!tmp.isEmpty()) {
            coeficientes.push(Integer.parseInt(tmp));
            tmp = "";
        }

        numCoeficientes = coeficientes.size();
        for (int i = 0; i < numCoeficientes; i++) {
            stCoeficientes.push(coeficientes.pop());
        }

        if (stCoeficientes.size() == stVariables.size()) {
            monomios = new Monomio[stCoeficientes.size()];
            for (int i = 0; i < numCoeficientes; i++) {
                monomios[i] = new Monomio(stCoeficientes.pop(), stVariables.pop());
            }
            ecuacion.setMonomios(monomios);
        }else{
            throw new UnsupportedOperationException("Aun no se ha implementado una forma de tratar ecuaciones que coniene monomios son uno");
        }
    }

    private String volter(String cadena) {
        String nuevaCadena = "";
        int tamanyoCadena = cadena.length();
        do {
            nuevaCadena += cadena.charAt(tamanyoCadena - 1);
            tamanyoCadena--;
        } while (tamanyoCadena > 0);
        return nuevaCadena;
    }

    public static void main(String[] args) {
        new ValidadorEcuacion().validar("20>=3X+5Y-8D-9g+r");
    }
}

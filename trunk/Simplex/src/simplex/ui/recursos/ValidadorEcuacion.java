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

    /**
     *
     * @param string
     * @return Ecuacion
     */
    public Ecuacion validar(String string) {
        ecuacion = new Ecuacion(new Monomio[]{new Monomio('x')}, Ecuacion.IGUAL, null);
        string = string.trim();
        string = string.toLowerCase();
        String[] cadenaNueva = string.split("=");

        if (cadenaNueva.length == 2) {
            if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                buscarResultado(cadenaNueva);
                buscarMonomios(cadenaNueva[1]);
                ecuacion.setMonomios(monomios);
            } else {
                buscarResultado(new String[]{cadenaNueva[1], cadenaNueva[0]});
                buscarMonomios(cadenaNueva[0]);
                ecuacion.setMonomios(monomios);
            }
        } else {
            cadenaNueva = string.split(">");
            if (cadenaNueva.length == 2) {
                if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                    if ((cadenaNueva[0].charAt(0) >= 'a') && (cadenaNueva[0].charAt(0) <= 'z')) {
                        ecuacion.setMonomioResultado(new Monomio(string.charAt(0)));
                    } else {
                        ecuacion.setResultado(string.charAt(0) - 48);
                    }
                    ecuacion.setTipoIgualdad(Ecuacion.MAYOR_QUE);
                } else {
                    buscarResultado(new String[]{cadenaNueva[1], cadenaNueva[0]});
                    buscarMonomios(cadenaNueva[0]);
                    ecuacion.setMonomios(monomios);
                }
            }
            cadenaNueva = string.split("<");
            if (cadenaNueva.length == 2) {
                if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                    if ((cadenaNueva[0].charAt(0) >= 'a') && (cadenaNueva[0].charAt(0) <= 'z')) {
                        ecuacion.setMonomioResultado(new Monomio(string.charAt(0)));
                    } else {
                        ecuacion.setResultado(string.charAt(0) - 48);
                    }
                    ecuacion.setTipoIgualdad(Ecuacion.MENOR_QUE);
                } else {
                    buscarResultado(new String[]{cadenaNueva[1], cadenaNueva[0]});
                    buscarMonomios(cadenaNueva[0]);
                    ecuacion.setMonomios(monomios);
                }
            }
        }
        return ecuacion;
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
        int lengthString = string.length() - 1, numCoeficientes;
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
        }
    }

    private void buscarResultado(String[] cadenaNueva) {
        if ((cadenaNueva[0].charAt(0) >= 'a') && (cadenaNueva[0].charAt(0) <= 'z')) {
            ecuacion.setMonomioResultado(new Monomio(cadenaNueva[0].charAt(0)));
        } else {
            ecuacion.setResultado(cadenaNueva[0].charAt(0) - 48);
        }
        if (cadenaNueva[0].length() == 2) {
            switch (cadenaNueva[0].charAt(1)) {
                case '<':
                    ecuacion.setTipoIgualdad(Ecuacion.MENOR_IGUAL_QUE);
                    break;
                case '>':
                    ecuacion.setTipoIgualdad(Ecuacion.MAYOR_IGUAL_QUE);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        //new ValidadorEcuacion().validar("f<=-3x-5y+6z+10w");
        //new ValidadorEcuacion().validar("3X+5Y=z");
        //dividir("3X+5Y-8D-9g+rq");//TODO ERROR: no se logra meter el 1 de r
        //dividir("3X+5Y-D-9g+r");//TODO ERROR: similar al anterior pero en -1 de D
    }
}

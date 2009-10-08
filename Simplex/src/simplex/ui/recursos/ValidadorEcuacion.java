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
 * @version 1.15
 */
public class ValidadorEcuacion {

    private Monomio[] monomios;
    private Ecuacion ecuacion;

    public ValidadorEcuacion() {
        Ecuacion t = validar("3X+5Y=z");
        //dividir("-3x-5y+6z+10w");
        //dividir("3X+5Y-8D-9g+r");//TODO ERROR: no se logra meter el 1 de r
        //dividir("3X+5Y-D-9g+r");//TODO ERROR: similar al anterior pero en -1 de D
    }

    /**
     *
     * @param string
     * @return Ecuacion
     */
    public Ecuacion validar(String string) {
        this.ecuacion = new Ecuacion(new Monomio[]{new Monomio('x')}, Ecuacion.IGUAL, 0);
        string = string.trim();
        string = string.toLowerCase();
        String[] cadenaNueva = string.split("=");
        String[] cadenaMonomios;

        if (cadenaNueva.length == 2) {
            if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                buscarResultado(cadenaNueva);
                dividir(cadenaNueva[1]);
                ecuacion.setMonomios(monomios);
            }else{
                buscarResultado(new String[]{cadenaNueva[1],cadenaNueva[0]});
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
                }
            }
        }
        return ecuacion;
    }

    /**
     *
     * @param string
     */
    private void dividir(String string) {
        Stack<Character> stVariables = new Stack<Character>();
        Stack<Character> stCoeficientes = new Stack<Character>();
        int j = string.length() - 1;
        do {
            if ((string.charAt(j) >= 'a') && (string.charAt(j) <= 'z')) {
                stVariables.push(string.charAt(j));
            } else {
                stCoeficientes.push(string.charAt(j));
            }
            j--;
        } while (j != -1);

        String tmp = "";
        Stack<Integer> coeficientes = new Stack<Integer>();
        do {
            if ((stCoeficientes.peek() == '-') || (stCoeficientes.peek() == '+')) {
                if (tmp.length() != 0) {
                    coeficientes.push(Integer.parseInt(tmp));
                    tmp = "";
                } else if (stCoeficientes.peek() == '+') {
                    stCoeficientes.pop();
                } else {
                    tmp += stCoeficientes.pop();
                }
            } else {
                tmp += stCoeficientes.pop();
            }
        } while (!stCoeficientes.isEmpty());
        if (!tmp.isEmpty()) {
            coeficientes.push(Integer.parseInt(tmp));
        }
        if (coeficientes.size() == stVariables.size()) {
            monomios = new Monomio[coeficientes.size()];
            int tam = coeficientes.size();
            for (int i = 0; i < tam; i++) {
                monomios[i] = new Monomio(coeficientes.pop(), stVariables.pop());
            }
        }
    }

    private void buscarResultado(String [] cadenaNueva){
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
        new ValidadorEcuacion();
    }
}

/*
 * @(#)ValidarEcuacion.java 2.0.2 10/10/09
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
 * @version 2.0.2 10/10/09
 */
public class ValidadorEcuacion {

    /** Arreglo de monomios que será añadido a {@link #ecuacion} */
    private Monomio[] monomios;
    /** Ecuacion que será devuelta por {@link #validar(java.lang.String)} */
    private Ecuacion ecuacion;

    /**
     * Crea una <tt>Ecuacion</tt> a partir de una <tt>String</tt>.
     *
     * @param string {@code String} "3x + 8y = 12"
     * @return {@code Ecuacion}
     */
    public Ecuacion validar(String string) {
        ecuacion = new Ecuacion(new Monomio[]{new Monomio('x')}, Ecuacion.IGUAL, null);
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
                Stack<Character> stVariable = new Stack<Character>();
                Stack<Character> stConstantes = new Stack<Character>();

                for (char c : string.toCharArray()) {
                    if (esLetra(c)) {
                        stVariable.push(c);
                    } else {
                        stConstantes.push(c);
                    }
                }

                String t = "";

                for (int i = 0; i < stConstantes.size(); i++) {
                    t += stConstantes.pop();
                }

                ecuacion.setMonomioResultado(new Monomio(
                        Integer.parseInt(volter(t)), stVariable.pop()));
                ecuacion.setResultado(0);
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
        if (string.length() == 1) {
            monomios = new Monomio[1];
            monomios[0] = new Monomio(string.charAt(0));
            ecuacion.setMonomios(monomios);
        } else {
            Stack<Character> stVariables = new Stack<Character>();
            Stack<Character> stCoeficientesTmp = new Stack<Character>();
            Stack<Double> stCoeficientes = new Stack<Double>();
            Stack<Double> coeficientes = new Stack<Double>();
            int numCoeficientes = 0, lengthString = string.length() - 1, numVariables = 0;
            String tmp = "";

            do {
                if (esLetra(string.charAt(lengthString))) {
                    stVariables.push(string.charAt(lengthString));
                } else {
                    stCoeficientesTmp.push(string.charAt(lengthString));
                }
                lengthString--;
            } while (lengthString != -1);

            do {
                if ((stCoeficientesTmp.peek() == '-') || (stCoeficientesTmp.peek() == '+')) {
                    if (tmp.length() != 0) {
                        //TODO Aquí ocurre un error al convertir, pues se añade el subindice de la variable
                        try {
                            coeficientes.push(Double.parseDouble(tmp));
                            tmp = "";
                        } catch (NumberFormatException ex) {
                            String[] stTmp = tmp.split("/");
                            if (stTmp.length > 0) {
                                double uno = Double.parseDouble(stTmp[0]);
                                double dos = Double.parseDouble(stTmp[1]);
                                double tres = uno / dos;
                                coeficientes.push(tres);
                            }
                        }
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
                //TODO Aquí ocurre un error al convertir, pues se añade el subindice de la variable
                try {
                    coeficientes.push(Double.parseDouble(tmp));
                    tmp = "";
                } catch (NumberFormatException ex) {
                    String[] stTmp = tmp.split("/");
                    if (stTmp.length > 0) {
                        double uno = Double.parseDouble(stTmp[0]);
                        double dos = Double.parseDouble(stTmp[1]);
                        double tres = uno / dos;

                        coeficientes.push(tres);
                    }
                }
                tmp = "";
            }

            numCoeficientes = coeficientes.size();
            numVariables = stVariables.size();

            for (int i = 0; i < numCoeficientes; i++) {
                stCoeficientes.push(coeficientes.pop());
            }

            if (numCoeficientes == numVariables) {
                monomios = new Monomio[numCoeficientes];
                for (int i = 0; i < numCoeficientes; i++) {
                    monomios[i] = new Monomio(stCoeficientes.pop(), stVariables.pop());
                }
                ecuacion.setMonomios(monomios);
            } else {
                monomios = new Monomio[numVariables];
                for (int i = 0; i < numVariables; i++) {
                    if (!stCoeficientes.isEmpty()) {
                        double cons = stCoeficientes.pop();
                        char ch = stVariables.pop();
                        tmp = cons + "" + ch;
                        if (string.indexOf(tmp) != -1) {
                            monomios[i] = new Monomio(cons, ch);
                        } else if (string.indexOf(tmp = ((int) cons) + "" + ch) != -1) {
                            monomios[i] = new Monomio(cons, ch);
                        } else if (string.indexOf(tmp = decimalAFraccion(cons) + "" + ch) != -1) {
                            monomios[i] = new Monomio(cons, ch);
                        } else {
                            monomios[i] = new Monomio(ch);
                            stCoeficientes.push(cons);
                        }
                        tmp = "";
                    } else {
                        monomios[i] = new Monomio(stVariables.pop());
                    }
                }
                ecuacion.setMonomios(monomios);
            }
        }
    }

    /**
     * <p>Invierte la cadena que recibe.</p>
     * <p>Recibe "Animal" y devuele "laminA"</p>
     *
     * @param cadena
     * @return {@code String}
     */
    private String volter(String cadena) {
        String nuevaCadena = "";
        int tamanyoCadena = cadena.length();
        do {
            nuevaCadena += cadena.charAt(tamanyoCadena - 1);
            tamanyoCadena--;
        } while (tamanyoCadena > 0);
        return nuevaCadena;
    }

    private boolean esLetra(char c) {
        return ((c >= 'a') && (c <= 'z'));
    }

    private String decimalAFraccion(double aDouble) {
        double tmp;
        int b = 0, a;
        do {
            b++;
            tmp = b * aDouble;
            a = (int) tmp;
            tmp = tmp - a;
        } while (tmp > 0);
        return a + "/" + b;
    }
}

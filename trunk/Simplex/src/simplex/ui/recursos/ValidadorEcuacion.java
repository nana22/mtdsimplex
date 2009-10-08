/*
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplex.ui.recursos;

import simplex.resolvedor.mate.Ecuacion;
import simplex.resolvedor.mate.Monomio;

/**
 *
 * @author Neo Cs
 */
public class ValidadorEcuacion {

    public void main(String[] args) {
        Ecuacion t = validar("3=3X+5Y");
    }
    
    public Ecuacion validar(String cadena) {
        Ecuacion ecuacion = new Ecuacion(new Monomio[]{new Monomio('x')}, Ecuacion.IGUAL, 0);
        cadena = cadena.trim();
        cadena = cadena.toLowerCase();
        String[] cadenaNueva = cadena.split("=");
        String[] cadenaMonomios;

        if (cadenaNueva.length == 2) {
            if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                if ((cadenaNueva[0].charAt(0) >= 'a') && (cadenaNueva[0].charAt(0) <= 'z')) {
                    ecuacion.setMonomioResultado(new Monomio(cadena.charAt(0)));
                } else {
                    ecuacion.setResultado(cadena.charAt(0) - 48);
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
            cadenaMonomios = separar(cadenaNueva[1], '+');
        } else {
            cadenaNueva = cadena.split(">");
            if (cadenaNueva.length == 2) {
                if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                    if ((cadenaNueva[0].charAt(0) >= 'a') && (cadenaNueva[0].charAt(0) <= 'z')) {
                        ecuacion.setMonomioResultado(new Monomio(cadena.charAt(0)));
                    } else {
                        ecuacion.setResultado(cadena.charAt(0) - 48);
                    }
                    ecuacion.setTipoIgualdad(Ecuacion.MAYOR_QUE);
                }

            }
            cadenaNueva = cadena.split("<");
            if (cadenaNueva.length == 2) {
                if (cadenaNueva[1].length() > cadenaNueva[0].length()) {
                    if ((cadenaNueva[0].charAt(0) >= 'a') && (cadenaNueva[0].charAt(0) <= 'z')) {
                        ecuacion.setMonomioResultado(new Monomio(cadena.charAt(0)));
                    } else {
                        ecuacion.setResultado(cadena.charAt(0) - 48);
                    }
                    ecuacion.setTipoIgualdad(Ecuacion.MENOR_QUE);
                }

            }
        }
        return ecuacion;
    }

    private String[] separar(String cadena, char buscar) {
        String entero="", decimal="";
        boolean encontrado = false;
        for (int i = 0; i < cadena.length(); i++){
            if (cadena.charAt(i) == buscar)
                encontrado = true;
            if (!encontrado)
                entero += cadena.charAt(i);
            else
                decimal += cadena.charAt(i);
        }
        return new String [] {entero,decimal};
    }
}

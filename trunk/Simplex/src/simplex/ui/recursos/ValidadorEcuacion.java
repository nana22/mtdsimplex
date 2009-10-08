package simplex.ui.recursos;

import java.util.Stack;
import simplex.resolvedor.mate.Ecuacion;
import simplex.resolvedor.mate.Monomio;

public class ValidadorEcuacion {

    public static void main(String[] args) {
        //Ecuacion t = validar("3=3X+5Y-8D-9g+r");
        dividir("-3x-5y+6z+10w");
    }
    
    public static Ecuacion validar(String cadena) {
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
            //Todo implementar dividir;
            //cadenaMonomios = dividir(cadenaNueva[1]);
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

    private static String[] dividir(String string) {
        Stack<Character> stVariables = new Stack<Character>();
        Stack<Character> stCoeficientes = new Stack<Character>();
        for (int i = 0; i < string.length(); i++){
            if((string.charAt(i) >= 'a') && (string.charAt(i) <= 'z')){
                stVariables.push(string.charAt(i));
            }else{
                stCoeficientes.push(string.charAt(i));
            }
        }

        String tmp = "";
        Stack<Integer> coeficientes = new Stack<Integer>();
        if((stCoeficientes.peek()== '-') || (stCoeficientes.peek() == '+')){
            if(tmp.length() != 0){
                coeficientes.push(Integer.parseInt(tmp));
                tmp = "";
            }else{
                tmp += stCoeficientes.pop();
            }
        }
        return new String []{"",""};
    }
}


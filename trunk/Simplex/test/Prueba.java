
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import mate.Ecuacion;
import mate.Monomio;

/**
 *
 * @author Neo Cs
 */
public class Prueba {
    public static void main(String[] args) {
        new Ecuacion(new Monomio[]{new Monomio('x'), new Monomio(2, 'y'), new Monomio(-3, 'w')}, Ecuacion.MAYOR_IGUAL_QUE, 3);
        new Ecuacion(new Monomio[]{new Monomio('x'), new Monomio(2, 'y'), new Monomio(-3, 'w')}, Ecuacion.MAYOR_IGUAL_QUE, new Monomio(2, 'g', 1/2));
    }
}

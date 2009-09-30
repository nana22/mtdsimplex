package simplex;

import simplex.ui.Principal;

/**
 *
 * @author Neo Cs || [El Ángel Blanco]
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Perro");
        } else {
            System.out.println(args);
        }
        System.out.println("La suma de 3 y 4 es:" + sumar(3, 4));
        new Principal().setVisible(true);
    }

    static int sumar(int a, int b) {
        return a + b;
    }
}

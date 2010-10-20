/*
 * @(#)SimplexTabular.java 1.0 12/10/2009
 * @charset "utf-8";
 * Copyright (c) pendiente.
 * 
 */
package simplex.resolvedor;

import java.util.ArrayList;
import java.util.List;
import org.neocs.mate.fracciones.Fraccion;
import simplex.resolvedor.mate.Ecuacion;
import simplex.resolvedor.mate.Monomio;
import simplex.resolvedor.mate.RationalNumber;

/**
 *
 * @author Neo Cs
 * @version 1.0, 12/10/2009
 */
public class SimplexTabular implements Simplex {

    private int step, cycle;
    /**define cantidad de restricciones*/
    private int m;
    /**define numero de variables basicas*/
    private int n;
    private int r;
    private int s;
    private RationalNumber[][] a = new RationalNumber[10][20];
    private List f = new ArrayList<ArrayList<RationalNumber>>();
    int[] base = new int[10];

    @Override
    public double[] maximizar(Ecuacion funcionObjetivo, Ecuacion[] restricciones) {

        for (int i = 0; i < restricciones.length; i++) {
            Ecuacion ecuacion = restricciones[i];
            Monomio[] monomios = ecuacion.getMonomios();
            List array = new ArrayList<RationalNumber>();

            for (int j = 0; j < monomios.length; j++) {
                Monomio monomio = monomios[j];
                array.add(new RationalNumber(
                        Fraccion.valueOf(
                        monomio.getCoeficiente()).toString()));
            }
            f.add(array);
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double[] minimizar(Ecuacion funcionObjetivo, Ecuacion[] restricciones) {
        boolean isOptimal = false;
        boolean isUnbounded = false;

        do {
            switch (step) {
                case 0:
                    isOptimal = step1();
                    break;
                case 1:
                    isUnbounded = step2();
                    break;
                case 2:
                    step3();
                    break;
                case 3:
                    step4();
                    cycle++;
                    break;
                default:
                    break;
            }
            step++;

            step %= 4;
        } while ((!isOptimal) || (!isUnbounded));
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private boolean step1() {		/* search pivot s of (r, s) */
        RationalNumber c = new RationalNumber();

        s = 0;
        r = -1;
        c.set(a[m][s]);
        for (int j = 1; j < n; j++) {
            if (c.gt(a[m][j])) {
                s = j;
                c.set(a[m][s]);
            }
        }
        if (c.numerator >= 0) {
            s = -1;
            return true;
        } else {
            return false;
        }
    }

    private boolean step2() {		/* search pivot r of (r, s) */
        RationalNumber t = new RationalNumber();
        RationalNumber c = new RationalNumber();

        for (int i = 0; i < m; i++) {
            if (a[i][s].numerator <= 0) {
                continue;
            }
            t.set(a[i][n]);
            t.div(a[i][s]);
            if (r < 0 || t.lt(c)) {
                r = i;
                c.set(t);
            }
        }
        if (r < 0) {
            return true;
        } else {
            return false;
        }
    }

    private void step3() {		/* pivot operation 1 */
        RationalNumber c = new RationalNumber();

        base[r] = s;
        c.set(a[r][s]);
        for (int j = 0; j <= n; j++) {
            a[r][j].div(c);
        }
    }

    private void step4() {
        RationalNumber c = new RationalNumber();
        RationalNumber t = new RationalNumber();

        for (int i = 0; i <= m; i++) {
            if (i == r) {
                continue;
            }
            c.set(a[i][s]);
            for (int j = 0; j <= n; j++) {
                t.set(c);
                t.mul(a[r][j]);
                a[i][j].minus(t);
            }
        }
        r = s = -1;
    }
}

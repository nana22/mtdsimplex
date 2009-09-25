/*
 * @(#)Main.java
 * @charset "utf-8";
 *
 * Copyright (C) 2009  Marco Maldonado, Freddy Barrera.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

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
            System.out.println("hOLA");
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

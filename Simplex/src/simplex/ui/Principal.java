/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package simplex.ui;

import javax.swing.JFrame;

/**
 *
 * @author Neo Cs
 */
public class Principal extends JFrame{

    public Principal(){
        init();
    }

    void init(){
        setTitle("Ventana");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

/*
 * (#)Principal.java 1.0
 * @charset "utf-8";
 */

package simplex.ui;

import javax.swing.JFrame;

/**
 *
 * @author Neo Cs
 */
public class Principal extends JFrame{
    private static final long serialVersionUID = -7099333179481246597L;

    public Principal(){
        init();
    }

    void init(){
        setTitle("Ventana");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}

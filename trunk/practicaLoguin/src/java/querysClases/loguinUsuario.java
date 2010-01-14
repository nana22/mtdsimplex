/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package querysClases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import setYgetClases.datos;

/**
 *
 * @author medina
 */
public class loguinUsuario {

    Connection conex;

    loguinUsuario() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {

                conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuariosCalidad", "andres", "andres");

            } catch (SQLException ex) {
                Logger.getLogger(loguinUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loguinUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
public void busca(String usuario, String pass){
        ArrayList lista=new ArrayList();
        try {
            Statement st = conex.createStatement();
         
            ResultSet rs=st.executeQuery("select nombreUsuario, password from usuario where nombreUsuario like'%"+usuario+"%' and password like'%"+pass+"%'");

            if(rs.next()){
//                  datos dat = new datos();
//                String clave=rs.getString("claveEmpleado");
//                dat.setPass(rs.getString("nombreUsuario"));
//                dat.setUsuario(rs.getString("password"));
//                lista.add(dat);

            System.out.println("usuario valido");
            }else{
                System.out.println("el usuario no se encuentra");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loguinUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }



//    return lista;
}
    


}

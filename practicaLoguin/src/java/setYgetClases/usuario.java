/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package setYgetClases;

/**
 *
 * @author medina
 */
public class usuario {
private String nombreUsuario;
private String password;
private int claveEmpleado;

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the claveEmpleado
     */
    public int getClaveEmpleado() {
        return claveEmpleado;
    }

    /**
     * @param claveEmpleado the claveEmpleado to set
     */
    public void setClaveEmpleado(int claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }
}
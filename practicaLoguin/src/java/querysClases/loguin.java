/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package querysClases;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import querysClases.loguinUsuario;
import setYgetClases.usuario;

/**
 *
 * @author medina
 */
public class loguin extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            usuario usr = new usuario();

            usr.setNombreUsuario(request.getParameter("usuario"));
            usr.setPassword(request.getParameter("pass"));
            String usuario = usr.getNombreUsuario();
            String pass = usr.getPassword();
            loguinUsuario log = new loguinUsuario();

            log.busca(usuario, pass);

//            ArrayList x = new ArrayList();
//            Iterator<String> itr = x.iterator();
//            while (itr.hasNext()) {
//                String cad = itr.next();
//                System.out.println(cad);
//            getServletContext().getRequestDispatcher("/logueado.jsp").forward(request, response);
                request.setAttribute("usuario", "user");
                request.setAttribute("pass", "password");
                request.getRequestDispatcher("logueado.jsp").forward(request, response);
//            }



        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

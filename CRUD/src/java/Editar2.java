/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class Editar2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String eseid,nombre,password,email,pais;
            eseid = request.getParameter("id2");
            int id = Integer.parseInt(eseid);
            Emp e = EmpData.getEmpleadoByID(id);
            nombre = request.getParameter("nombre2");
            password = request.getParameter("pass2");
            email = request.getParameter("mail2");
            pais = request.getParameter("pais2");
            Emp emp = new Emp();
            emp.setNombre(nombre);
            emp.setPass(password);
            emp.setMail(email);
            emp.setPais(pais);
            int status = EmpData.Actualizar(emp);
            if(status > 0){
                out.println("Se Actualizo con exito");
                /*Get request Dispacher redirecciona un evento establecido por
                back-end de modo que el usuario nunca vera el proceso de dicha 
                accion.
                */
                response.sendRedirect("Consulta");
            }else{
                out.println("SE ROMPIO LA MATRIX");
            }
            out.close();
            
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

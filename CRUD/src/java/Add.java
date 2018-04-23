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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class Add extends HttpServlet {

    /**
     * 
     */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

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
            String nom, pass,em, pa;
            nom = request.getParameter("nombre");
            pass = request.getParameter("pass");
            em = request.getParameter("mail");
            pa = request.getParameter("pais");
            
            Emp e = new Emp();
            e.setNombre(nom);
            e.setPass(pass);
            e.setMail(em);
            e.setPais(pa);
            int status = EmpData.Guardar(e);
            HttpSession ses = request.getSession();
            
            if(status > 0){
                out.println("Se guardo con exito");
                /*Get request Dispacher redirecciona un evento establecido por
                back-end de modo que el usuario nunca vera el proceso de dicha 
                accion.
                */
                request.getRequestDispatcher("index.html");
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

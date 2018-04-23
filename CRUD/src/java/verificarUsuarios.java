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
public class verificarUsuarios extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom, pass;
            nom = request.getParameter("usuario");
            pass = request.getParameter("pass");
            
            Emp e = new Emp();
            e = EmpData.verificarUsuario(nom, pass);
            if(e != null){
                /*CREAR SESION DEL USUARIO EXISTENTE Y COMPRARARLA CON LA SESION
                DE LA BASE DE DEATOS
                */
                //sesion de BD
                HttpSession sesion = request.getSession(true);
                sesion.setAttribute("usuario", e);
                //sesion por formulario
                HttpSession sesionOK = request.getSession();
                sesionOK.setAttribute("usuario", nom);
                if (e.getId_rol() == 1) {
                    response.sendRedirect("Administrador.html");
                }else{
                    response.sendRedirect("infrausuario.html");
                }
            }else{
                response.sendRedirect("Error.html");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

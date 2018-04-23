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
public class Editar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Editar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edicion de empleado</h1>");
            String eseid;
            eseid = request.getParameter("id");
            int id = Integer.parseInt(eseid);
            Emp e = EmpData.getEmpleadoByID(id);
            out.println("<form action='Editar2' method='post' name='edit'>"
                    + "<table border =1>"
                    + "<tr>"
                    + "<td></td>"
                    + "<td><input type='hidden' name='id2' value='"+e.getId()+"'></td>"
                    + "</tr>"
                    +   "<tr>"
                    + "<td>NOMBRE</td>"
                    + "<td><input type='text' name='nombre2' value='"+e.getNombre()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>PASWWORD</td>"
                    + "<td><input type='password' name='pass2' value='"+e.getPass()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>EMAIL</td>"
                    + "<td><input type='email' name='mail2' value='"+e.getMail()+"'></td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>PAIS"
                            + "<select name='pais2'>"
                            + "<option>India</option>"
                            + "<option>Mexico</option>"
                            + "<option>Spaña</option>"
                            + "<option>Algun lugar del mundo</option>"
                            + "</select>"
                    + "</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td>EMAIL</td>"
                    + "<td><input type='submit' name='mail' value='Editar'/></td>"
                    + "</tr>"        
                    + "</table> "
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
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

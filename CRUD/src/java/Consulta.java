import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Consulta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta de empleados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>MIS EMPLEADOS</h1>");
            List<Emp>  l = EmpData.getAllEmpleados();
            out.println("<table border = 1>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>Nombre</th>"
                    + "<th>Pass</th>"
                    + "<th>E-mail</th>"
                    + "<th>Pais</th>"
                    + "</tr>");
            for (Emp e : l) {
                out.println("<tr>"
                        + "<td>"+e.getId()+"</td>"
                        + "<td>"+e.getNombre()+"</td>"
                        + "<td>"+e.getPass()+"</td>"
                        + "<td>"+e.getMail()+"</td>"
                        + "<td>"+e.getPais()+"</td>"
                        + "<td><a href='Editar?id="+e.getId()+"'>Editar</a></td>"
                        + "<td><a href='Borrar?id="+e.getId()+"'>Borrar</a></td>"
                        + "</tr>");
            }
            out.println("</table>");
            out.println("<a href=índex.html'</a><br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

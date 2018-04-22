import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Registrar extends HttpServlet {
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("<link rel='stylesheet' href='CSS/w3.css/'>");
        try (PrintWriter out = response.getWriter()) {
            
            Sec e = new Sec();
            
            String usu,pas;
            
            usu = request.getParameter("usuarioR");
            pas = request.getParameter("contrasenaR");
            
            e.setUsuario(usu);
            e.setPassword(pas);
            
            int status = EAUDao.Registrar(e);
            
            HttpSession sesion = request.getSession();
            
            if (status > 0) {
                
                out.println("Se agrego el secretario");
                
                request.getRequestDispatcher("index.html");
                
            } else {
                out.println("No se guardo");
            }
            
            out.close();
            
            
            /*String nom = request.getParameter("usuarioR");
            String cont = request.getParameter("contrasenaR");
            
            try{
                
                String q;
                
                q = "INSERT INTO usuarios(usuario,contrasena) VALUES('"+nom+"','"+cont+"');";
                
                set.executeUpdate(q);
                System.out.println("Usuario agregado como Secretario");
                
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registrar Secretario</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 class='w3-center w3-opacity'>Secretario agregado</h1>"
                        + "#NoHayBD XDXDXDXDXD");
                out.println("<a href='index.html'>Regresar a la pagina principal</a>");
                out.println("</body>");
                out.println("</html>");
            } catch(Exception e){
                
                System.out.println("Error con la conexion a EAU"+ e.getMessage());
                System.out.println(e.getStackTrace()); //sirve para saber en que hilo está el error 
                
            }*/
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void destroy(){
        
        try{
            
            con.close();
        
        }catch(Exception e){
            super.destroy();
        }
    }

}

import java.util.*;
import java.sql.*;

public class EAUDao {

    public static Connection getConnection(){
        
        String url, UserName, password;
        url="jdbc:mysql:3306/localhost/eau";
        UserName="root";
        password="n0m3l0";
        
        Connection con=null;   //objeto para la conexion
        
        try{
            Class.forName("com.mysql.jdbc.driver");
            con= DriverManager.getConnection(url, UserName, password);
           
            System.out.println("Conexion a EAU establecida");
            
        }catch(Exception e){
            
            System.out.println("Error con la conexion a EAU");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return con;
    }
    
    public static int Registrar(Sec e){
        int status=0;
        
            try{

                Connection con = EAUDao.getConnection();

                String q;

                q = "INSERT INTO usuarios (usuario,contrasena) VALUES (?,?);";

                PreparedStatement ps = con.prepareStatement(q);

                ps.setString(1, e.getUsuario());
                ps.setString(2, e.getPassword());

                status = ps.executeUpdate();
                con.close();

            } catch (Exception d) {
                System.out.println("Error con la conexion a EAU");
                System.out.println(d.getMessage());
                System.out.println(d.getStackTrace());
            }
        
        return status;

    }
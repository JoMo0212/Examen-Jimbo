/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Esta Clase se encargara de la conexion con la base de datos y se encarga de re-
alizar las acciones por parte del usuario: guardar empleado, consultar datos,
actualizar datos, dar de baja a los empleados y buscar un solo empleado.
*/
public class EmpData {
    //PRIMER METO
    public static Connection getConnection(/**/){
        String URL, USER, PASSWORD;
        URL = "jdbc:mysql://localhost/empleados";
        USER = "root";
        PASSWORD = "n0m3l0";
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("CONEXION ESTABLECIDA..."+ URL);
        }catch(Exception e){
            System.out.println("CONEXION FALLIDA");
            System.out.println("DATOS: "+e.toString());
            System.out.println("POWER: "+e.getStackTrace());
        }
        return con;
    }
    /*PRIMER METODO*/
    public static int Guardar(Emp e){
         int status = 0;/*Es necesario contar con un estado de la tabla de BD para saber
            si el empleado es nuevo o no */
        try {
           
            Connection con = EmpData.getConnection();
            String q;
            q = "INSERT INTO Datos(nombre, password, mail, pais)"
                    + "VALUES(?,?,?,?);";
            PreparedStatement set = con.prepareStatement(q);
            set.setString(1, e.getNombre());
            set.setString(2, e.getPass());
            set.setString(3, e.getMail());
            set.setString(4, e.getPais());
            
            status = set.executeUpdate();
            con.close();
         
            
        } catch (SQLException ex) {
           System.out.println("CONEXION FALLIDA");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return status;
    }
    
    public static int Actualizar(Emp e){
         int status = 0;/*Es necesario contar con un estado de la tabla de BD para saber
            si el empleado es nuevo o no */
        try {
           
            Connection con = EmpData.getConnection();
            String q;
            q = "UPDATE Datos "
              + "SET nombre = ?, password = ?, mail = ?, pais = ?, id = ?;";
            PreparedStatement set = con.prepareStatement(q);
            set.setString(1, e.getNombre());
            set.setString(2, e.getPass());
            set.setString(3, e.getMail());
            set.setString(4, e.getPais());
            set.setInt(5, e.getId());
            status = set.executeUpdate();
            con.close();
         
            
        } catch (SQLException ex) {
           System.out.println("OCURRIO UN ERROR EN LA BASE DE DATOS");
            System.out.println("DATOS: "+ex.toString());
           // System.out.println(ex.getCause());
            System.out.println("MENSAJE: "+ex.getMessage());
            System.out.println("Codigo: "+ex.getLocalizedMessage());
            System.out.println(ex.getSQLState());
            StackTraceElement[] erm = ex.getStackTrace();
        }
        return status;
    }
    
    public static int Eliminar(int ID){
         int status = 0;/*Es necesario contar con un estado de la tabla de BD para saber
            si el empleado es nuevo o no */
        try {
           
            Connection con = EmpData.getConnection();
            String q;
            q = "DELETE FROM Datos WHERE id = ?";
            PreparedStatement set = con.prepareStatement(q);
            set.setInt(1, ID);
            
            status = set.executeUpdate();
            con.close();
         
            
        } catch (SQLException ex) {
           System.out.println("CONEXION FALLIDA");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return status;
    }
    
    public static Emp getEmpleadoByID(int ID){
        Emp e = new Emp();/*Es necesario contar con un estado de la tabla de BD para saber
            si el empleado es nuevo o no */
        try {
           
            Connection con = EmpData.getConnection();
            String q;
            q = "SELECT * FROM Datos WHERE id = ?";
            PreparedStatement set = con.prepareStatement(q);
            set.setInt(1, ID);
            
            ResultSet rs = set.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPass(rs.getString(3));
                e.setMail(rs.getString(4));
                e.setPais(rs.getString(5));
            } else {
            }
            
            
            
            con.close();
         
            
        } catch (SQLException ex) {
           System.out.println("CONEXION FALLIDA");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return e;
        
    }
    public static List<Emp> getAllEmpleados(){
        List<Emp> lista = new ArrayList<Emp>();/*Es necesario contar con un estado de la tabla de BD para saber
            si el empleado es nuevo o no */
        try {
           
            Connection con = EmpData.getConnection();
            
            String q;
            q = "SELECT * FROM Datos";
            PreparedStatement set = con.prepareStatement(q);
            
            ResultSet rs = set.executeQuery();
            while(rs.next()) {
                Emp e = new Emp();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPass(rs.getString(3));
                e.setMail(rs.getString(4));
                e.setPais(rs.getString(5));
                lista.add(e);
            }
            
            
            con.close();
         
            
        } catch (SQLException ex) {
           System.out.println("CONEXION FALLIDA");
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return lista;
        
    }
    
    public static Emp verificarUsuario(String nom, String pass){
        Emp e = new Emp();/*Es necesario contar con un estado de la tabla de BD para saber
            si el empleado es nuevo o no */
        try {
           
            Connection con = EmpData.getConnection();
            String q;
            q = "SELECT * FROM Datos WHERE nombre=? AND password=?";
            PreparedStatement set = con.prepareStatement(q);
            set.setString(1, nom);
            set.setString(2, pass);
            
            ResultSet rs = set.executeQuery();
            while(rs.next()) {
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPass(rs.getString(3));
                e.setMail(rs.getString(4));
                e.setPais(rs.getString(5));
                e.setId_rol(rs.getInt(6));
            } 
            
            
            
            
            con.close();
         
            
        } catch (SQLException ex) {
           System.out.println("CONEXION FALLIDA");
            System.out.println(ex.toString());
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }
        return e;
        
    }
}

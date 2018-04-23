/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
public class Emp {
    /*
    Tener base de datos creada para entender que clases son programables para
    el acceso a los datos, acciones y definicion de roles dentro del sistema
    */
    
    private int id, id_rol;
    private String nombre, pass, mail, pais;

    public Emp() {
    }
    public Emp(int id, String nombre, String pass, String mail, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.mail = mail;
        this.pais = pais;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}

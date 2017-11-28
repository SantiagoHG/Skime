/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jade
 */

public class Usuario {
    
    private int idUsuario;
    private int idAvatar;
    private String nombre;
    private String nickname;
    private String email;
    private String contraseña;
    private int edad;
    private double ingresoFijo;
    private int ingresoPeriodo;
    private double ProgresoTotal;
    private double AhorroTotal;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAvatar() {
        return idAvatar;
    }

    public void setIdAvatar(int idAvatar) {
        this.idAvatar = idAvatar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getIngresoFijo() {
        return ingresoFijo;
    }

    public void setIngresoFijo(double ingresoFijo) {
        this.ingresoFijo = ingresoFijo;
    }

    public int getIngresoPeriodo() {
        return ingresoPeriodo;
    }

    public void setIngresoPeriodo(int ingresoPeriodo) {
        this.ingresoPeriodo = ingresoPeriodo;
    }

    public double getProgresoTotal() {
        return ProgresoTotal;
    }

    public void setProgresoTotal(double ProgresoTotal) {
        this.ProgresoTotal = ProgresoTotal;
    }

    public double getAhorroTotal() {
        return AhorroTotal;
    }

    public void setAhorroTotal(double AhorroTotal) {
        this.AhorroTotal = AhorroTotal;
    }
    
    public void registrarUsuario(String nombre, String nickname, String email, String contraseña, int edad){
        Connection cn = null;
        PreparedStatement ps = null;
        
        Usuario usuario = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("insert into Usuario(Nombre, Nickname, Email, "
                    + "Contrasena, Edad) values (?,?,?,?,?);");
 
            ps.setString(1,nombre);
            ps.setString(2,nickname);
            ps.setString(3,email);
            ps.setString (4,contraseña);
            ps.setInt(5,edad);
            
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
            cn.close();
            ps.close();
            
            } catch (SQLException e) {}       
        }
        
    }
    
    public Usuario IniciarSesion(String email, String contraseña ) throws SQLException {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Usuario usuario = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("select * from Usuario where Email=? and Contraseña=? ;");
            ps.setString(1, email);
            ps.setString(2, contraseña);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario ();
                
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setNickname(rs.getString("Nickname"));
                usuario.setEmail(rs.getString("Email"));
                usuario.setContraseña(rs.getString("Contraseña"));
                usuario.setEdad(rs.getInt("Edad"));
                
                System.out.println (rs.getString("idUsuario"));
            }   
        }catch(SQLException e){
        }finally {
            cn.close();
            ps.close();
            rs.close();  
        }
        return usuario;  
    }
    
    public void editarInformacion(int idUsuario, String nombre, String nickname, double ingresoFijo, double ingresoPeriodo) throws SQLException{
        Connection cn = null;
        PreparedStatement ps = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("update Usuario set Nombre=? ,Nickname=? ,IngresoFijo=? ,IngresoPeriodo=? where idUsuario=? ;");
            
            ps.setString(1, nombre);
            ps.setString(2, nickname);
            ps.setDouble(3, ingresoFijo);
            ps.setDouble(4, ingresoPeriodo);
            ps.setInt(5, idUsuario);
            
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            cn.close();
            ps.close();  
        }
    }
}
 
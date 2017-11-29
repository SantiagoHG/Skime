/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Jade
 */
public class MetaUsuario {
    private int idMetaUsuario;
    private int idMetaColectiva;
    private int idUsuario;
    private double montoMetaUsuario;

    public int getIdMetaUsuario() {
        return idMetaUsuario;
    }

    public void setIdMetaUsuario(int idMetaUsuario) {
        this.idMetaUsuario = idMetaUsuario;
    }

    public int getIdMetaColectiva() {
        return idMetaColectiva;
    }

    public void setIdMetaColectiva(int idMetaColectiva) {
        this.idMetaColectiva = idMetaColectiva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMontoMetaUsuario() {
        return montoMetaUsuario;
    }

    public void setMontoMetaUsuario(double montoMetaUsuario) {
        this.montoMetaUsuario = montoMetaUsuario;
    }
    
    public void añadirUsuarioaMeta(int idUsuario, int idMetaColectiva, double montoMetaUsuario){
        Connection cn = null;
        PreparedStatement ps = null;
        
        MetaColectiva meta = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("insert into MetaUsuario(idUsuario, idMetaColectiva, MontoMetaUsuario) values (?,?,?);");
 
            ps.setInt(1,idUsuario);
            ps.setInt(2,idMetaColectiva);
            ps.setDouble(3,montoMetaUsuario);
            
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
    
}

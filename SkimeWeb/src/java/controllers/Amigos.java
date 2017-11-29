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
public class Amigos {
    private int idAmigos;
    private int idAmigo1;
    private int idAmigo2;

    public int getIdAmigos() {
        return idAmigos;
    }

    public void setIdAmigos(int idAmigos) {
        this.idAmigos = idAmigos;
    }

    public int getIdAmigo1() {
        return idAmigo1;
    }

    public void setIdAmigo1(int idAmigo1) {
        this.idAmigo1 = idAmigo1;
    }

    public int getIdAmigo2() {
        return idAmigo2;
    }

    public void setIdAmigo2(int idAmigo2) {
        this.idAmigo2 = idAmigo2;
    }
    
    public void agregarAmigo(int idAmigo1, int idAmigo2){
        Connection cn = null;
        PreparedStatement ps = null;
        
        Amigos amigos = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("insert into Amigos(idAmigo1, idAmigo2 ) values (?,?);");
 
            ps.setInt(1,idAmigo1);
            ps.setInt(2,idAmigo2);
            
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

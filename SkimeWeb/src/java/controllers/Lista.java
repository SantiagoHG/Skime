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
public class Lista {
    private int idLista;
    private int idUsuario;
    private String nombreLista;
    private double progresoLista;
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public double getProgresoLista() {
        return progresoLista;
    }

    public void setProgresoLista(double progresoLista) {
        this.progresoLista = progresoLista;
    }
    
    public ArrayList <Lista> consultarListas(int idUsuario) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList <Lista> lista_de_listas = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("select * from Lista where idUsuario = ?;");
            
            ps.setInt(1,idUsuario);
            rs = ps.executeQuery();
            
            lista_de_listas = new ArrayList<Lista>();
            
            while (rs.next()) { 
                Lista lista = new Lista();
                lista.setIdLista(rs.getInt("idLista"));
                lista.setIdUsuario(rs.getInt("idUsuario"));
                lista.setNombreLista(rs.getString("NombreLista"));
                
                lista_de_listas.add(lista); 
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
            cn.close();
            ps.close();
            rs.close();
            } catch (SQLException e) {} 
        }
        return lista_de_listas; 
    }
    
    public void registrarLista(int idUsuario, int idLista, String nombreLista){
    Connection cn = null;
    PreparedStatement ps = null;
        
    try {
        cn= DBConnection.getConnection();
            
        ps = cn.prepareStatement("insert into Lista(idLista, idUsuario, NombreLista) values (?, ?, ?);");
            ps.setInt(1, idLista);
            ps.setInt(2, idUsuario);
            ps.setString(3, nombreLista);
            
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
    
    public void borrarLista(int idLista){
        Connection cn = null;
        PreparedStatement ps = null;
        
        try {
            cn= DBConnection.getConnection();
            
            ps = cn.prepareStatement("delete from Lista where idLista= ?;");
            ps.setInt(1, idLista);
            
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

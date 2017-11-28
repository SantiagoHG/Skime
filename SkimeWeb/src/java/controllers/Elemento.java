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
public class Elemento {
    
    private int idElemento;
    private int idLista;
    private String nombreElemento;
    private String fechaInit;
    private String fechaEnd;
    private double costoElemento;
    private double montoElemento;
    private double progresoElemento;

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getNombreElemento() {
        return nombreElemento;
    }

    public void setNombreElemento(String nombreElemento) {
        this.nombreElemento = nombreElemento;
    }

    public String getFechaInit() {
        return fechaInit;
    }

    public void setFechaInit(String fechaInit) {
        this.fechaInit = fechaInit;
    }

    public String getFechaEnd() {
        return fechaEnd;
    }

    public void setFechaEnd(String fechaEnd) {
        this.fechaEnd = fechaEnd;
    }

    public double getCostoElemento() {
        return costoElemento;
    }

    public void setCostoElemento(double costoElemento) {
        this.costoElemento = costoElemento;
    }

    public double getMontoElemento() {
        return montoElemento;
    }

    public void setMontoElemento(double montoElemento) {
        this.montoElemento = montoElemento;
    }

    public double getProgresoElemento() {
        return progresoElemento;
    }

    public void setProgresoElemento(double progresoElemento) {
        this.progresoElemento = progresoElemento;
    }
    
    
    
    public void registrarElemento(int idLista, String nombreElemento, String fechaInit, String fechaEnd, double costoElemento){
        Connection cn = null;
        PreparedStatement ps = null;
        
        Elemento elemento = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("insert into Elemento(NombreElemento, FechaInit, FechaEnd, "
                    + "CostoElemento) values (?,?,?,?,?) where idLista=? ;");
 
            ps.setString(1,nombreElemento);
            ps.setString(2,fechaInit);
            ps.setString(3,fechaEnd);
            ps.setDouble (4,costoElemento);
            ps.setInt(5,idLista);
            
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
    
    public ArrayList <Elemento> consultarElementosdeLista(int idLista) {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ArrayList <Elemento> lista_de_elementos = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("select * from Elementos where idLista = ?;");
            
            ps.setInt(1,idLista);
            rs = ps.executeQuery();
            
            lista_de_elementos = new ArrayList<Elemento>();
            
            while (rs.next()) { 
                Elemento elemento = new Elemento();
                elemento.setIdElemento(rs.getInt("idElemento"));
                elemento.setNombreElemento(rs.getString("NombreElemento"));
                elemento.setFechaInit(rs.getString("FechaInit"));
                elemento.setFechaEnd(rs.getString("FechaEnd"));
                elemento.setCostoElemento(rs.getDouble("CostoElemento"));
                
                lista_de_elementos.add(elemento); 
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
        return lista_de_elementos; 
    }
    
}

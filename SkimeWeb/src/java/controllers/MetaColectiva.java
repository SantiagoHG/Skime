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
//create table MetaColectiva(idMetaColectiva int(6) not null auto_increment primary key, NombreMeta varchar(65), DescripcionMeta varchar (280), CostoMeta float(10), MontoMeta float(10), ProgresoMeta float(10));
//create table MetaUsuario(idMetaUsuario int(6) not null auto_increment primary key, idMetaColectiva int(6), idUsuario int(6), MontoMetaUsuario float(10));
public class MetaColectiva {
    
    private int idMetaColectiva;
    private String nombreMeta;
    private String descripcionMeta;
    private double costoMeta;

    public int getIdMetaColectiva() {
        return idMetaColectiva;
    }

    public void setIdMetaColectiva(int idMetaColectiva) {
        this.idMetaColectiva = idMetaColectiva;
    }

    public String getNombreMeta() {
        return nombreMeta;
    }

    public void setNombreMeta(String nombreMeta) {
        this.nombreMeta = nombreMeta;
    }

    public String getDescripcionMeta() {
        return descripcionMeta;
    }

    public void setDescripcionMeta(String descripcionMeta) {
        this.descripcionMeta = descripcionMeta;
    }

    public double getCostoMeta() {
        return costoMeta;
    }

    public void setCostoMeta(double costoMeta) {
        this.costoMeta = costoMeta;
    }
    
    public void registrarMeta(String nombreMeta, String descripcionMeta, double costoMeta){
        Connection cn = null;
        PreparedStatement ps = null;
        
        MetaColectiva meta = null;
        
        try {
            cn= DBConnection.getConnection();
            ps = cn.prepareStatement("insert into MetaColectiva(NombreMeta, DescripcionMeta, CostoMeta) values (?,?,?);");
 
            ps.setString(1,nombreMeta);
            ps.setString(2,descripcionMeta);
            ps.setDouble(3,costoMeta);
            
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

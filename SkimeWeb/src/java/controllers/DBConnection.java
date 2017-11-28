package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection getConnection() {
        
        String cls_nam;
        String url;
        String unm;
        String pwd;

        cls_nam = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/SkimeV1";
        unm = "root";
        pwd = "alpaca";
        
        try {
            Class.forName(cls_nam);
            return DriverManager.getConnection(url, unm, pwd);
        } catch (SQLException mysql_ex) {
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}

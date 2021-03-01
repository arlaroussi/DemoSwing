/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoswing;

import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author rlaroussi
 */
public class Modele  {
    //private static Connection conn;
    
    public static Connection Connexion(String url,String user,String password) throws SQLException {
        Connection conn=null;
        try {
		Class.forName("com.mysql.jdbc.Driver") ;
                conn = DriverManager.getConnection(url,user,password) ;
	}
	catch (ClassNotFoundException e){
		System.out.println("Erreur lors du chargement "+e.getMessage()) ;
                exit(0);
        }
       return conn;
}
    public void remplirCombo1(JComboBox comb, String req) throws SQLException {
        Statement stmt=null;
        Connection connexion=null;
        
        try {
            String url = "jdbc:mysql://localhost:3306/concours" ;
            String user= "root";
            String password ="";
            connexion = Modele.Connexion(url, user, password);
            stmt = (Statement) connexion.createStatement() ;
            ResultSet result = stmt.executeQuery(req) ;
            while (result.next()) {
                String nom = result.getString("nom");
                comb.addItem(nom);
           }
        }
        catch (SQLException e) {
		System.out.println("Connection error");
	}

    }
    
    public void remplirCombo3(JComboBox comb, String req) throws SQLException {       
        Statement stmt=null;
        Connection connexion=null;
    
        try {
            String url = "jdbc:mysql://localhost:3306/concours" ;
            String user= "root";
            String password ="";
            connexion = Modele.Connexion(url, user, password);
            stmt = (Statement) connexion.createStatement() ;
            ResultSet result = stmt.executeQuery(req) ;
            while (result.next()) {
                String nom = result.getString("libelle");
                comb.addItem(nom);
           }
        }
        catch (SQLException e) {
		System.out.println("Connection error");
	}

    }
    
    public int verifLogin(String req) throws SQLException {
        Statement stmt=null;
        Connection connexion=null;
        int nombre=0;
        try {
            String url = "jdbc:mysql://localhost:3306/concours" ;
            String user= "root";
            String password ="";
            connexion = Modele.Connexion(url, user, password);
            stmt = (Statement) connexion.createStatement() ;
            ResultSet result = stmt.executeQuery(req) ;

            while (result.next()){
                    nombre = result.getInt(1);
                }
            }
            catch (SQLException e) {
		System.out.println("Connection error");
            }
           return nombre;
}            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package app;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.SQLException;
/**
 *
 * @author Lenovo
 */
public class User {
    Connector connector = new Connector();
    
    public String[][] getUserByUsername(String username){
        String data[][] = new String[1][5];
        int jmlData = 0;
        try{
            String query = "SELECT * FROM user Where username='"+username+"'";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("username");
                data[jmlData][2] = resultSet.getString("password"); 
                data[jmlData][3] = resultSet.getString("alamat");
                data[jmlData][4] = resultSet.getString("no_hp");
                jmlData++; 
            }
            connector.statement.close();
           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }finally{
            return data;
        }
    }
    
    public boolean passwordMatch(String password,String passwordDB) throws NoSuchAlgorithmException{
        if (password.equals(passwordDB)) {
            return true;
        }else{
            return false;
        }
   }
  
}
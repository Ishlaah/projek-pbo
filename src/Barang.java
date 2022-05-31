//package app;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Barang {
    Connector connector = new Connector();
    
    public String[][] getDataBarang() {
        String data[][] = new String[50][5];
        int jmlData = 0;
        try{
            String query = "SELECT * FROM barang";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("nama_barang"); 
                data[jmlData][2] = resultSet.getString("jumlah"); 
                data[jmlData][3] = resultSet.getString("harga");
                data[jmlData][4] = resultSet.getString("tanggal_masuk");
                jmlData++; 
            }
            connector.statement.close();
           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            
        }finally{
            return data;
        }
    }
    
     public boolean checkID(String id){
        boolean found = false;
        try{
            String query = "SELECT id from barang";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            while(resultSet.next()){ //konversi tabel ke string
                if(resultSet.getString("id").equals(id)){
                    found = true;
                    break;
                }     
            }
            return found;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return found;
        }   
    }
     
    public int updateBarang(String id,String namabarang,String jumlah, String harga){

        try {
            String query = "UPDATE barang set nama_barang='"+namabarang+"', "
                    + "jumlah='"+jumlah+"', harga='"+harga+"' WHERE id='"+id+"'";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query); // eksekusi query

            JOptionPane.showMessageDialog(null,"Update data Berhasil !!");
            return 1;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int insertBarang(String namabarang,String jumlah, String harga){

        try {
            String query = "INSERT INTO barang (nama_barang,jumlah,harga) "
                    + "VALUES ('"+namabarang+"','"+jumlah+"', '"+harga+"')";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query); // eksekusi query

            JOptionPane.showMessageDialog(null,"Insert data Berhasil !!");
            return 1;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    public int updateBarang(String id, String namabarang, String jumlah){

        try {
             String query = "UPDATE kendaraan set nama_barang='"+namabarang+"', "
                    + "jumlah='"+jumlah+"'' WHERE id='"+id+"'";
            
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query); // eksekusi query

            JOptionPane.showMessageDialog(null,"Update data Berhasil !!");
            return 1;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    }
}

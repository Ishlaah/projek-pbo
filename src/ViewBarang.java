//package app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class ViewBarang {
    Connector connector = new Connector();
    Connection koneksi;
    Statement statement;
    

    JFrame window = new JFrame("Data Kendaraan");
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"Id", "Nama Barang","Jumlah","Harga","Tanggal Masuk"};
    
    JLabel judul = new JLabel("Ubah Data Barang");
    JLabel lid = new JLabel("Id Barang  ");
        JTextField tfid = new JTextField();
    JLabel lnamabarang = new JLabel("Nama Barang  ");
        JTextField tfnamabarang = new JTextField();
    JLabel ljumlah = new JLabel("Jumlah  ");
        JTextField tfjumlah= new JTextField();
    JLabel lharga = new JLabel("Harga ");
        JTextField tfharga = new JTextField();
        
    JButton btnUbah = new JButton("Ubah Data");
    
    public ViewBarang(){
        Barang barang = new Barang();
        String data[][] = barang.getDataBarang();
        
        
        
        window.setLayout(null);
        window.setSize(800,600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        
        // ADD COMPONENT
            window.add(judul);
            window.add(lid);
            window.add(tfid);
            window.add(lnamabarang);
            window.add(tfnamabarang);
            window.add(ljumlah);
            window.add(tfjumlah);
            window.add(lharga);
            window.add(tfharga);
            window.add(btnUbah);
            
        // ATUR LETAK
            judul.setBounds(70, 310, 290, 20);
            lid.setBounds(40, 350, 120, 20);
            tfid.setBounds(170, 350, 100, 20);
            lnamabarang.setBounds(40, 380, 120, 20);
            tfnamabarang.setBounds(170, 380, 100, 20);
            ljumlah.setBounds(40, 410, 120, 20);
            tfjumlah.setBounds(170, 410, 100, 20);
            lharga.setBounds(40, 470, 120, 20);
            tfharga.setBounds(170, 470, 100, 20);
            btnUbah.setBounds(80, 515, 120, 20);
        
        tabel = new JTable(data,namaKolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 730, 250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        btnUbah.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent arg0) {
                    if(barang.checkID(getID())){
                        barang.updateBarang(getID(),getnamabarang(),getjumlah(),getharga());
                    }else{
                        JOptionPane.showMessageDialog(null,"ID Kendaraan "+ getID()+ " tidak ditemukan");
                    }
                    
                    
                }
        });
    }
    
       
       
       
    
    public String getID(){
        return tfid.getText();
    }
    public String getnamabarang(){
        return tfnamabarang.getText();
    }
    public String getjumlah(){
        return tfjumlah.getText();
    }
    public String getharga(){
        return tfharga.getText();
    }
}

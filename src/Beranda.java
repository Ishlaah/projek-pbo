//package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.NoSuchAlgorithmException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class Beranda {
    Connector connector = new Connector();
    
    //DEKLARASI KOMPONEN  
    JFrame window = new JFrame("Beranda");
    JLabel judul = new JLabel("Beranda");
    JLabel greeting;
    JLabel linputbarang = new JLabel("Input barang");
    
    JLabel lihatbarang = new JLabel("Lihat barang");
    JLabel lnamabarang = new JLabel("Nama Barang  ");
        JTextField tfnamabarang = new JTextField();
    JLabel ljumlah = new JLabel("Jumlah  ");
        JTextField tfjumlah = new JTextField();
    JLabel lharga = new JLabel("Harga  ");
        JTextField tfharga = new JTextField();
    
      
        
        
    JButton btnBarang = new JButton("Data Barang");
    
    
    JButton btnSubmitBarang = new JButton("Submit Data Barang");
    
    
    
    
    public Beranda(String nama){
        Barang barang = new Barang();
        greeting = new JLabel("Selamat datang, " + nama);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setSize(1000,500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        // ADD Component
            window.add(judul);
            window.add(greeting);
            window.add(linputbarang);
          
            window.add(lihatbarang);
            // kendaraan
            window.add(lnamabarang);
            window.add(ljumlah);
            window.add(lharga);
            
            window.add(tfnamabarang);
            window.add(tfjumlah);
            window.add(tfharga);
           
           
            
            // penyewa
            
            // button
            window.add(btnBarang);
            
            
            window.add(btnSubmitBarang);
            
            

            
        // Atur Letak
            judul.setBounds(470, 12, 120, 20);
            greeting.setBounds(50, 55, 160, 20);
            lihatbarang.setBounds(110, 100, 160, 20);
            linputbarang.setBounds(440, 100, 160, 20);
            
            // bagian kendaraan
            lnamabarang.setBounds(340, 150, 120, 20);
            ljumlah.setBounds(340, 190, 120, 20);
            lharga.setBounds(340, 230, 120, 20);
            
            
            tfnamabarang.setBounds(465, 152, 125, 20);
            tfjumlah.setBounds(465, 192, 125, 20);
            tfharga.setBounds(465, 232, 125, 20);
           
            
            
            // bagian penyewa
            
            
            btnBarang.setBounds(80, 160, 140, 20);
           
            
            btnSubmitBarang.setBounds(410, 350, 180, 20);
            
            btnSubmitBarang.addActionListener(new ActionListener() {
                String jenis;
                @Override
                public void actionPerformed(ActionEvent arg0) {
                     barang.insertBarang(getnamabarang(),getjumlah(),getharga());
                    
                }
            });
            
            btnBarang.addActionListener(new ActionListener() {
                String jenis;
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    ViewBarang viewbarang = new ViewBarang();
                    
                }
            });
            
            
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

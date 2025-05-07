import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Pelanggan p = new Pelanggan();
        //frame homepage
        JFrame home = new JFrame();
        home.setSize(800, 500);
        home.getContentPane().setBackground(Color.darkGray);
        home.setLayout(null);

        // label Eka bis
        JLabel eka = new JLabel();
        eka.setText("Sistem Pemesanan Bis Eka");
        eka.setFont(new Font("Tahoma", Font.BOLD, 17));
        eka.setForeground(Color.white);
        eka.setBounds(268, 0, 300, 40);
        home.add(eka);

        //Textfield nama penumpang
        JLabel nama =  new JLabel();
        nama.setText("Nama Penumpang");
        nama.setFont(new Font("Tahoma", Font.BOLD, 17));
        nama.setForeground(Color.white);
        nama.setBounds(20, 60, 300, 25);
        home.add(nama);

        JTextField isiNama = new JTextField();
        isiNama.setFont(new Font("Tahoma", Font.PLAIN, 15));
        isiNama.setEditable(true);
        isiNama.setBounds(20, 90, 300, 25);
        home.add(isiNama);

        //Textfield NIK penumpang
        JLabel nik =  new JLabel();
        nik.setText("NIK Penumpang");
        nik.setFont(new Font("Tahoma", Font.BOLD, 17));
        nik.setForeground(Color.white);
        nik.setBounds(20, 120, 300, 25);
        home.add(nik);

        JTextField isiNik = new JTextField();
        isiNik.setFont(new Font("Tahoma", Font.PLAIN, 15));
        isiNik.setEditable(true);
        isiNik.setBounds(20, 150, 300, 25);
        home.add(isiNik);

        //Textfield No Handphone
        JLabel noHP =  new JLabel();
        noHP.setText("No HP Penumpang");
        noHP.setFont(new Font("Tahoma", Font.BOLD, 17));
        noHP.setForeground(Color.white);
        noHP.setBounds(20, 180, 300, 25);
        home.add(noHP);

        JTextField isiNoHP = new JTextField();
        isiNoHP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        isiNoHP.setEditable(true);
        isiNoHP.setBounds(20, 210, 300, 25);
        home.add(isiNoHP);

        //Dropdown titik awal
        JLabel awal =  new JLabel();
        awal.setText("Titik Awal");
        awal.setFont(new Font("Tahoma", Font.BOLD, 17));
        awal.setForeground(Color.white);
        awal.setBounds(425, 60, 300, 25);
        home.add(awal);

        JComboBox<String> tAwal = new JComboBox<>(new String[]{"Wilangan", "Ngawi", "Gendingan", "Solo", "Kartosuro", "Jogja", "Magelang"});
        tAwal.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tAwal.setBounds(425, 90, 300, 25);
        tAwal.setBackground(Color.white);
        home.add(tAwal);

        //Dropdown titik akhir
        JLabel akhir =  new JLabel();
        akhir.setText("Titik Akhir");
        akhir.setFont(new Font("Tahoma", Font.BOLD, 17));
        akhir.setForeground(Color.white);
        akhir.setBounds(425, 120, 300, 25);
        home.add(akhir);

        JComboBox<String> tAkhir = new JComboBox<>(new String[]{"Wilangan", "Ngawi", "Gendingan", "Solo", "Kartosuro", "Jogja", "Magelang"});
        tAkhir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tAkhir.setBounds(425, 150, 300, 25);
        tAkhir.setBackground(Color.white);
        home.add(tAkhir);

        //Harga
        JLabel harga =  new JLabel();
        harga.setText("Harga Tiket");
        harga.setFont(new Font("Tahoma", Font.BOLD, 17));
        harga.setForeground(Color.white);
        harga.setBounds(425, 180, 300, 25);
        home.add(harga);

        //Text Harga
        JTextArea display = new JTextArea();
        display.setFont(new Font("Tahoma", Font.PLAIN, 15));
        display.setText("Rp. "+p.getHarga(tAwal.getSelectedItem().toString(), tAkhir.getSelectedItem().toString())+",000");
        display.setEditable(false);
        display.setBounds(425, 210, 300, 25);
        home.add(display);

        //cekrute
        JLabel warning = new JLabel();
        warning.setVisible(false);
        warning.setFont(new Font("Tahoma", Font.BOLD, 12));
        warning.setForeground(Color.red);
        warning.setBounds(400, 240, 375, 25);
        final boolean[] t = {false};
        home.add(warning);

        ActionListener cekRute = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromCity = tAwal.getSelectedItem().toString();
                String toCity = tAkhir.getSelectedItem().toString();
                String c = p.checkRoute(tAwal.getSelectedItem().toString(), tAkhir.getSelectedItem().toString());
                warning.setText(c);
                warning.setVisible(true);
                
                if(c.equals(" ")){
                    t[0] = true;
                } else {
                    t[0] = false;
                }
            }
        };

        tAwal.addActionListener(cekRute);
        tAkhir.addActionListener(cekRute);

        ActionListener updateHarga = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromCity = tAwal.getSelectedItem().toString();
                String toCity = tAkhir.getSelectedItem().toString();
                int currentPrice = p.getHarga(fromCity, toCity);
                display.setText("Rp. " + currentPrice + ",000");
            }
        };

        tAwal.addActionListener(updateHarga);
        tAkhir.addActionListener(updateHarga);











        // button lihat layout bis
        JButton layout = new JButton();
        layout.setText("Pilih Kursi");
        layout.setBounds(600, 390, 150, 40);
        home.add(layout);

        //Warning belom diisi
        JLabel[] warn = new JLabel[3];

        for(int i=0;i<warn.length;i++) {
            warn[i] = new JLabel();
            warn[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            warn[i].setForeground(Color.red);
            warn[i].setText("* Isi ini terlebih dahulu");
            home.add(warn[i]);
            warn[i].setVisible(false);
        }

        warn[0].setBounds(180, 60, 200, 25);
        warn[1].setBounds(180, 120, 200, 25);
        warn[2].setBounds(180, 180, 200, 25);


        // Buka layout page
        layout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(isiNama.getText()!=null){
                    warn[0].setVisible(false);
                }if(isiNoHP.getText()!=null){
                    warn[1].setVisible(false);
                }if(isiNik.getText()!=null){
                    warn[2].setVisible(false);
                }if(isiNama.getText().isEmpty()){
                    warn[0].setVisible(true);
                }if(isiNik.getText().isEmpty()){
                    warn[1].setVisible(true);
                }if(isiNoHP.getText().isEmpty()){
                    warn[2].setVisible(true);
                }


                if(!Objects.equals(isiNama.getText(), "") && !Objects.equals(isiNoHP.getText(), "") && !Objects.equals(isiNik.getText(), "")) {
                    if(t[0]) {
                        new Bis();
                    }
                }
            }
        });
        
        home.setVisible(true);
        
    }
}
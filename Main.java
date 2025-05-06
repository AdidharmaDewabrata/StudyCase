import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

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


        home.setVisible(true);




















        // button lihat layout bis
        JButton layout = new JButton();
        layout.setText("Pilih Kursi");
        layout.setBounds(600, 390, 150, 40);
        home.add(layout);



        //frame layout
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setVisible(false);

            //Layout Bis
                //Pintu's
                JLabel label = new JLabel();
                label.setText("Pintu Depan");
                label.setFont(new Font("Times New Roman", Font.BOLD, 15));

                JLabel label2 = new JLabel();
                label2.setText("Pintu Belakang");
                label2.setFont(new Font("Times New Roman", Font.BOLD, 15));

                label.setBounds(10, -200, 500, 500);
                label2.setBounds(10, 340, 500, 500);

                frame.add(label);
                frame.add(label2);

                //Konduktor
                JButton konduktor = new JButton();
                konduktor.setText("Konduktor");
                konduktor.setBounds(10, 80, 100, 30);
                konduktor.setOpaque(true);
                frame.add(konduktor);

                //Driver
                JButton driver = new JButton();
                driver.setText("Driver");
                driver.setBounds(435, 60, 100, 40);
                frame.add(driver);

                //Seat A
                JButton[] A = new JButton[18];

                String a = "A";
                int x = 10;
                int y = 80;

                for(int i = 0; i < A.length; i++){
                    A[i] = new JButton();
                    A[i].setFont(new Font("Times New Roman", Font.BOLD, 13));
                    A[i].setText(a+(i+1));
                    A[i].setBorder(new LineBorder(Color.black,1));
                    if(i%2 == 0){
                        x = 10;
                        y+= 50;
                    }
                    else{
                        x += 95;
                    }
                    A[i].setBounds(x, y, 90, 30);
                    A[i].setBackground(Color.green);
                    frame.add(A[i]);
                }

                //Seat B
                JButton[] B = new JButton[22];

                String b = "B";
                int x2 = 370;
                int y2 = 80;

                for(int i = 0; i < B.length; i++){
                    B[i] = new JButton();
                    B[i].setFont(new Font("Times New Roman", Font.BOLD, 13));
                    B[i].setBorder(new LineBorder(Color.black,1));
                    B[i].setText(b+(i+1));

                    if(i%2 == 0){
                        x2 = 370;
                        y2+= 50;
                    }

                    else{
                        x2 += 95;
                    }

                    B[i].setBounds(x2, y2, 90, 30);
                    B[i].setBackground(Color.green);
                    frame.add(B[i]);
                }

                //Toilet
                JButton toilet = new JButton();
                toilet.setText("Toilet");
                toilet.setBounds(10, 620, 180, 40);
                frame.add(toilet);

                //Selanjutnya
                JButton next = new JButton();
                next.setText("Selanjutnya");
                next.setBounds(370, 700, 180, 40);
                frame.add(next);

        // Buka layout page
        layout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                frame.setVisible(true);
                }
            }
        );

        // ganti warna if clicked
        for(int i = 0; i<B.length; i++){
            int finalI = i;
            B[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(B[finalI].getBackground() == Color.yellow){
                        B[finalI].setBackground(Color.green);
                    }
                    else {
                        B[finalI].setBackground(Color.yellow);
                    }
                }

            });

            if(i<17) {
                int finalI1 = i;
                A[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(A[finalI1].getBackground() == Color.yellow){
                            A[finalI1].setBackground(Color.green);
                        }
                        else {
                            A[finalI1].setBackground(Color.yellow);
                        }
                    }
                });
            }
        }

    }
}
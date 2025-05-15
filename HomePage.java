import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class HomePage extends JFrame {
    static int[] jumlah = {1};
    static Long[] nik1 = {0L};
    static Long[] no = {0L};
    static String[] titik  = {"tes", "toto"};
    static String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "u", "V", "W", "X", "Y", "Z"};
    public HomePage() {
        Pelanggan p = new Pelanggan();
        //frame homepage
        this.setSize(800, 500);
        this.getContentPane().setBackground(Color.decode("#9a8c98"));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        // label Eka bis
        JLabel eka = new JLabel();
        eka.setText("Sistem Pemesanan Bis Eka");
        eka.setFont(new Font("Tahoma", Font.BOLD, 17));
        eka.setForeground(Color.decode("#f9dcc4"));
        eka.setBounds(268, 0, 300, 40);
        this.add(eka);

        //Textfield nama penumpang
        JLabel nama =  new JLabel();
        nama.setText("Nama Penumpang");
        nama.setFont(new Font("Tahoma", Font.BOLD, 17));
        nama.setForeground(Color.decode("#f9dcc4"));
        nama.setBounds(20, 60, 300, 25);
        this.add(nama);

        JTextField isiNama = new JTextField();
        isiNama.setFont(new Font("Tahoma", Font.PLAIN, 15));
        isiNama.setEditable(true);
        isiNama.setBackground(Color.decode("#ecf39e"));
        isiNama.setBounds(20, 90, 300, 25);
        p.setNama(isiNama.getText());
        this.add(isiNama);

        //Warn kl bukan angka
        JLabel warn3 = new JLabel("* Isi dengan angka!");
        warn3.setForeground(Color.red);
        warn3.setBounds(330, 120, 200, 25);
        warn3.setVisible(false);
        this.add(warn3);

        JLabel warn4 = new JLabel("* Isi dengan angka!");
        warn4.setForeground(Color.red);
        warn4.setBounds(330, 180, 200, 25);
        warn4.setVisible(false);
        this.add(warn4);

        //Textfield NIK penumpang
        JLabel nik =  new JLabel();
        nik.setText("NIK Penumpang");
        nik.setFont(new Font("Tahoma", Font.BOLD, 17));
        nik.setForeground(Color.decode("#f9dcc4"));
        nik.setBounds(20, 120, 300, 25);
        this.add(nik);

        JTextField isiNik = new JTextField();
        isiNik.setFont(new Font("Tahoma", Font.PLAIN, 15));
        isiNik.setEditable(true);
        isiNik.setBackground(Color.decode("#ecf39e"));
        isiNik.setBounds(20, 150, 300, 25);
        this.add(isiNik);

        //Textfield No Handphone
        JLabel noHP =  new JLabel();
        noHP.setText("No HP Penumpang");
        noHP.setFont(new Font("Tahoma", Font.BOLD, 17));
        noHP.setForeground(Color.decode("#f9dcc4"));
        noHP.setBounds(20, 180, 300, 25);
        this.add(noHP);

        JTextField isiNoHP = new JTextField();
        isiNoHP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        isiNoHP.setEditable(true);
        isiNoHP.setBackground(Color.decode("#ecf39e"));
        isiNoHP.setBounds(20, 210, 300, 25);
        this.add(isiNoHP);

        //Dropdown titik awal
        JLabel awal =  new JLabel();
        awal.setText("Titik Awal");
        awal.setFont(new Font("Tahoma", Font.BOLD, 17));
        awal.setForeground(Color.decode("#f9dcc4"));
        awal.setBounds(425, 60, 300, 25);
        this.add(awal);

        JComboBox<String> tAwal = new JComboBox<>(new String[]{"Wilangan", "Ngawi", "Gendingan", "Solo", "Kartosuro", "Jogja", "Magelang"});
        tAwal.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tAwal.setBounds(425, 90, 300, 25);
        tAwal.setBackground(Color.decode("#ecf39e"));
        this.add(tAwal);

        //Dropdown titik akhir
        JLabel akhir =  new JLabel();
        akhir.setText("Titik Akhir");
        akhir.setFont(new Font("Tahoma", Font.BOLD, 17));
        akhir.setForeground(Color.decode("#f9dcc4"));
        akhir.setBounds(425, 120, 300, 25);
        this.add(akhir);

        JComboBox<String> tAkhir = new JComboBox<>(new String[]{"Wilangan", "Ngawi", "Gendingan", "Solo", "Kartosuro", "Jogja", "Magelang"});
        tAkhir.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tAkhir.setBounds(425, 150, 300, 25);
        tAkhir.setBackground(Color.decode("#ecf39e"));
        titik[1] = Objects.requireNonNull(tAkhir.getSelectedItem()).toString();
        this.add(tAkhir);

        //Harga
        JLabel harga =  new JLabel();
        harga.setText("Harga / Tiket");
        harga.setFont(new Font("Tahoma", Font.BOLD, 17));
        harga.setForeground(Color.decode("#f9dcc4"));
        harga.setBounds(315, 280, 300, 25);
        this.add(harga);

        //Text Harga
        JTextArea display = new JTextArea();
        display.setFont(new Font("Tahoma", Font.PLAIN, 15));
        display.setText("Rp. "+p.getHarga(Objects.requireNonNull(tAwal.getSelectedItem()).toString(), tAkhir.getSelectedItem().toString())+",000");
        display.setEditable(false);
        display.setBackground(Color.decode("#ecf39e"));
        display.setBounds(315, 310, 115, 25);
        p.setHarga(p.getHarga(tAwal.getSelectedItem().toString(), tAkhir.getSelectedItem().toString()));
        this.add(display);

        //cekRute
        JLabel warning = new JLabel();
        warning.setVisible(false);
        warning.setFont(new Font("Tahoma", Font.BOLD, 12));
        warning.setForeground(Color.red);
        warning.setBounds(400, 240, 375, 25);
        boolean[] t = {false};
        this.add(warning);

        //Label jml tiket
        JLabel jml =  new JLabel("Jumlah Tiket");
        jml.setForeground(Color.decode("#f9dcc4"));
        jml.setBounds(425,180,300,25);
        jml.setFont(new Font("Tahoma", Font.BOLD, 17));
        this.add(jml);

        //Panel jml tiket
        JLabel showJumlah = new JLabel (String.valueOf(jumlah[0]));
        showJumlah.setFont(new Font("Tahoma", Font.PLAIN, 15));
        showJumlah.setForeground(Color.black);
        showJumlah.setBounds(425, 210, 100, 25);
        showJumlah.setVisible(true);
        this.add(showJumlah);

        JPanel jmlTiket = new JPanel();
        jmlTiket.setLayout(null);
        jmlTiket.setBounds(425, 210, 200, 25);
        jmlTiket.setBackground(Color.decode("#ecf39e"));
        this.add(jmlTiket);


        //tombol buat nambah/nurunin jumlah tiket
        JButton tambah = new JButton("^");
        tambah.setFont(new Font("Tahoma", Font.BOLD, 17));
        tambah.setForeground(Color.decode("#f9dcc4"));
        tambah.setBackground(Color.decode("#4a4e69"));
        tambah.setBorder(BorderFactory.createLineBorder(Color.black));
        tambah.setBounds(625,209,50,27);
        this.add(tambah);

        JButton turun = new JButton("v");
        turun.setFont(new Font("Tahoma", Font.BOLD, 17));
        turun.setForeground(Color.decode("#f9dcc4"));
        turun.setBackground(Color.decode("#4a4e69"));
        turun.setBorder(BorderFactory.createLineBorder(Color.black));
        turun.setBounds(675,209,50,27);
        this.add(turun);
        //mau yoba satuin bagian tambaha turujn
//        boolean allowed = false;
//        while(allowed==false){
//            tambah.addActionListener(e -> {
//                if(jumlah[0]==40){
//                    showJumlah.setText(String.valueOf(jumlah[0]));
//                }
//                else {
//                    jumlah[0]++;
//                    showJumlah.setText(String.valueOf(jumlah[0]));
//                }
//            });
//            turun.addActionListener(e -> {
//                if(jumlah[0]==0){
//                    showJumlah.setText(String.valueOf(jumlah[0]));
//                }
//                else {
//                    jumlah[0]--;
//                    showJumlah.setText(String.valueOf(jumlah[0]));
//                }
//            });
//            if (jumlah[0]!=0){
//                allowed = true;
//            }
//        }
        //ini dijejerin satu dulu
        tambah.addActionListener(e -> {
            if(jumlah[0]==40){
                showJumlah.setText(String.valueOf(jumlah[0]));
            }
            else {
                jumlah[0]++;
                showJumlah.setText(String.valueOf(jumlah[0]));
            }
        });
        turun.addActionListener(e -> {
            if(jumlah[0]>1){
                jumlah[0]--;
                showJumlah.setText(String.valueOf(jumlah[0]));
            }
            else {
                showJumlah.setText(String.valueOf(jumlah[0]));
            }
        });

        ActionListener cekRute = e -> {
            titik[0] = (String) tAwal.getSelectedItem();
            titik[1] = (String) tAkhir.getSelectedItem();
            String fromCity = tAwal.getSelectedItem().toString();
            String toCity = tAkhir.getSelectedItem().toString();
            String c = p.checkRoute(tAwal.getSelectedItem().toString(), tAkhir.getSelectedItem().toString());
            warning.setText(c);
            warning.setVisible(true);

            t[0] = c.equals(" ");
        };

        tAwal.addActionListener(cekRute);
        tAkhir.addActionListener(cekRute);

        int[] price = {0};

        ActionListener updateHarga = e -> {
            String fromCity = tAwal.getSelectedItem().toString();
            String toCity = tAkhir.getSelectedItem().toString();
            price[0] = p.getHarga(fromCity, toCity);
            display.setText("Rp. " + price[0]);
        };

        tAwal.addActionListener(updateHarga);
        tAkhir.addActionListener(updateHarga);

        // button lihat layout bis
        JButton layout = new JButton();
        layout.setText("Pilih Kursi");
        layout.setForeground(Color.decode("#f9dcc4"));
        layout.setBackground(Color.decode("#4a4e69"));
        layout.setBounds(600, 390, 150, 40);
        this.add(layout);

        //Label warning belom diisi
        JLabel[] warn = new JLabel[5];

        for(int i=0;i<warn.length;i++) {
            warn[i] = new JLabel();
            warn[i].setFont(new Font("Tahoma", Font.BOLD, 12));
            warn[i].setForeground(Color.red);
            if(i<3) {
                warn[i].setText("* Isi ini terlebih dahulu");
            }
            else{
                warn[i].setText("* Isi dengan angka");
            }
            this.add(warn[i]);
            warn[i].setVisible(false);
        }

        warn[0].setBounds(180, 60,  200, 25);
        warn[1].setBounds(180, 120, 200, 25);
        warn[2].setBounds(180, 180, 200, 25);
        warn[3].setBounds(180, 120, 200, 25);
        warn[4].setBounds(180, 180, 200, 25);

        this.setVisible(true);

        ImageIcon icon = new ImageIcon("C:\\Users\\adksp\\IdeaProjects\\StudyCase\\out\\Green Beige Organic Illustrative Brainstorm Presentation.png");

        Image img = icon.getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(img);

        JLabel[] gambar = new JLabel[3];
        int  x3 = -100;

        for (int i = 0; i < 3; i++) {
            gambar[i] = new JLabel(scaledIcon);
            gambar[i].setBounds(x3, 250, 450, 300);
            this.add(gambar[i]);
            x3+=175;
        }

        this.setVisible(true);


        // Buka layout page
        layout.addActionListener(e -> {
            boolean[] b = {false, false};

            //cek apkah isi nik mengandung huruf alphabet
            for (String s : alphabet) {
                if (!(isiNik.getText().toUpperCase().contains(s))) {
                    b[0] = false;
                    break;
                }
            }

            //cek apkah isi nik sudah tidak mengandung huruf alphabet
            for (String s : alphabet) {
                if (!(isiNoHP.getText().toUpperCase().contains(s))) {
                    b[1] = false;
                    break;
                }
            }

            //munculin si warning letter
            warn3.setVisible(b[0]);
            warn4.setVisible(b[1]);

            if (isiNama.getText().isEmpty()) {
                warn[0].setVisible(true);
            }
            else{
                warn[0].setVisible(false);
            }
            if (isiNik.getText().isEmpty()) {
                warn[1].setVisible(true);
            }
            else{
                warn[1].setVisible(false);

                for (String s : alphabet) {
                    if (isiNik.getText().toUpperCase().contains(s)) {
                        b[0] = true;
                        break;
                    }
                    if (!(isiNik.getText().toUpperCase().contains(s))) {
                        b[0] = false;
                        break;
                    }
                }

                warn[3].setVisible(b[0]);
            }
            if (isiNoHP.getText().isEmpty()) {
                warn[2].setVisible(true);
            }
            else{
                warn[2].setVisible(false);
                for (String s : alphabet) {
                    if (isiNoHP.getText().toUpperCase().contains(s)) {
                        b[1] = true;
                        break;
                    }
                }
                warn[4].setVisible(b[1]);

            }

            if (!Objects.equals(isiNama.getText(), "") && !Objects.equals(isiNoHP.getText(), "") && !Objects.equals(isiNik.getText(), "")) {
                if (t[0] && !b[0] && !b[1]) {
                    nik1[0] = Long.parseLong(isiNik.getText());
                    no[0] = Long.parseLong(isiNoHP.getText());
                    new Bis(isiNama.getText(), nik1[0], no[0], titik[0], titik[1], price[0], jumlah[0]);
                    this.setVisible(false);
                    this.dispose();
                }
            }
        });
    }
}



import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Bis extends HomePage{
    static int[] counter = {1}; static boolean flag = false; static int index1=0;
    static String[] kursi = new String[jumlah[0]]; static String s = "";
    public Bis(String nama, long nik, long noHP, String tAwal, String tAkhir, int harga, int jumlah) {

    //read file dari data.txt trus bikin kursi yang uda dibook jadi merah
        Scanner sc;
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            while(reader.readLine() !=null){
                index1++;
            }
        } catch (IOException d) {
            System.err.println(d);
        }

        String[][] ListKursi = new String[index1][9];
        String[] list = new String[]{"Wilangan", "Ngawi", "Gendingan", "Solo", "Kartosuro", "Jogja", "Magelang"};

        try(BufferedReader reader = new BufferedReader(new FileReader("data.txt"))){
            int o = 0;
            String s;
            while ((s = reader.readLine()) != null && o < ListKursi.length) {
                sc = new Scanner(s);
                int u = 0;
                while (sc.hasNext() && u < 9) {
                    ListKursi[o][u] = sc.next();
                    u++;
                }
                o++;
            }
        } catch (IOException e) {
        throw new RuntimeException(e);
        }

        //frame layout
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null); // Tetap null agar scrollPane bisa diposisikan manual

        // Panel untuk kursi dan semua komponen layout bis
        JPanel kursiPanel = new JPanel();
        kursiPanel.setLayout(null);
        kursiPanel.setPreferredSize(new Dimension(580, 1100)); // Panjang vertikal agar scroll muncul
        kursiPanel.setBackground(Color.LIGHT_GRAY);

        // ScrollPane membungkus panel
        JScrollPane scrollPane = new JScrollPane(kursiPanel);
        scrollPane.setBounds(0, 0, 600, 800); // Ukuran full frame
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Tambahkan scrollPane ke frame
        frame.add(scrollPane);
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

                kursiPanel.add(label);
                kursiPanel.add(label2);

            //Konduktor
            JButton konduktor = new JButton();
                konduktor.setText("Konduktor");
                konduktor.setBounds(10, 80, 100, 30);
                konduktor.setOpaque(true);
                kursiPanel.add(konduktor);

            //Driver
            JButton driver = new JButton();
                driver.setText("Driver");
                driver.setBounds(435, 60, 100, 40);
                kursiPanel.add(driver);


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
                kursiPanel.add(A[i]);
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
                kursiPanel.add(B[i]);
            }

        //Toilet
        JButton toilet = new JButton();
        toilet.setText("Toilet");
        toilet.setBounds(10, 620, 180, 40);
        kursiPanel.add(toilet);

        //warning label
        JLabel warn = new JLabel("Batas jumlah kursi telah dipenuhi");
        warn.setForeground(Color.red);
        warn.setBounds(370, 670, 200, 40);
        warn.setVisible(false);
        kursiPanel.add(warn);
        //warning label kursi uda di book
        JLabel warn2 = new JLabel("Kursi telah dipenuhi");
        warn.setForeground(Color.red);
        warn.setBounds(370, 670, 200, 40);
        warn.setVisible(false);
        kursiPanel.add(warn2);

        //ganti warna kursi kalo kursi uda di book
        String c = " ", d = " ";
        int jmlKursi =0;
        int[] chairQty = new int[index1];
        ArrayList<String> kursii = new ArrayList<>();
        for(int i = 0; i < index1;i++){
            c = ListKursi[i][8];
            if (c == null) continue;
            String[] seat = c.split("-");
            jmlKursi+=seat.length;
            chairQty[i] = jmlKursi;
            kursii.addAll(Arrays.asList(seat));
        }
        int value = 0, value2 = 0;

        for (int i = 0; i < index1; i++) {
            for(int j = 0; j < list.length; j++){
                if(ListKursi[i][5].equalsIgnoreCase(list[j])){
                    ListKursi[i][5] = String.valueOf(j);
                }
                if(ListKursi[i][4].equalsIgnoreCase(list[j])){
                    ListKursi[i][4] = String.valueOf(j);
                }
                if (tAwal.equalsIgnoreCase(list[j])) {
                    value = j;
                }
                if (tAkhir.equalsIgnoreCase(list[j])) {
                    value2 = j;
                }
            }
        }


        for(int i = 0; i<index1; i++){
            for(int j = 0; j<B.length; j++){
                for(int k = 0; k<jmlKursi; k++){
                    if(B[j].getText().equals(kursii.get(k))){
                        B[j].setBackground(Color.red);
                    }
                    if(j<18){
                        if(A[j].getText().equals(kursii.get(k))){
                            A[j].setBackground(Color.red);
                        }
                    }
                }
            }
        }

        System.out.println("ini titik akhir data lama: "+ListKursi[0][5]);
        System.out.println("ini titik awal data lama: "+ListKursi[0][4]);
        System.out.println("ini titik akhir data baru: "+value2);
        System.out.println("ini titik awal data baru: "+value);
        //ganti warna kursi kalau semisal titik awal data terbaru == titik akhir data lama
        //value = tAwal | value2 = tAkhir
        //"Wilangan", "Ngawi", "Gendingan", "Solo", "Kartosuro", "Jogja", "Magelang"
        for (int i = 0; i < index1; i++) {
            if (value2 <= Integer.parseInt(ListKursi[i][4]) || value >= Integer.parseInt(ListKursi[i][5])) {
                int startIndex = (i == 0) ? 0 : chairQty[i - 1];
                int endIndex = chairQty[i];

                for (int j = 0; j < B.length; j++) {
                    for (int k = startIndex; k < endIndex; k++) {
                        if (B[j].getText().equals(kursii.get(k))) {
                            B[j].setBackground(Color.green);
                        }
                        if (j < 18 && A[j].getText().equals(kursii.get(k))) {
                            A[j].setBackground(Color.green);
                        }
                    }
                }
            }
        }


        /*
        jadi dia tu kek nyimpen dulu data lama titik akhir di array, terus dia bakalan nge check apakah tAwal data baru == tAkhir data lama
        kalo iya berarti kayak kursi yang merah diubah warnany jadi hijau
         */

        // ganti warna if clicked
        for(int i = 0; i<B.length; i++){
            int finalI = i;
            B[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(B[finalI].getBackground() == Color.yellow){
                            counter[0]--;
                            B[finalI].setBackground(Color.green);
                            if(counter[0] <= jumlah){
                                warn.setVisible(false);
                                flag = false;
                            }
                        }
                        else if(B[finalI].getBackground() == Color.green){
                            if(counter[0]>jumlah) {
                                warn.setVisible(true);
                            } else {
                                warn.setVisible(false);
                                flag = false;
                                kursi[counter[0]-1] = B[finalI].getText();
                                s+= kursi[counter[0]-1]+"-";
                                counter[0]++;
                                B[finalI].setBackground(Color.yellow);
                            }
                        }
                    }

                });

                if(i<18) {
                    int finalI1 = i;
                    A[i].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(A[finalI].getBackground() == Color.yellow){
                                counter[0]--;
                                A[finalI].setBackground(Color.green);
                                if(counter[0] <= jumlah){
                                    warn.setVisible(false);
                                    flag = false;
                                }
                            }
                            else if(A[finalI].getBackground() == Color.green){
                                if(counter[0]>jumlah) {
                                    warn.setVisible(true);
                                } else {
                                    warn.setVisible(false);
                                    flag = false;
                                    kursi[counter[0]-1] = A[finalI].getText();
                                    s+= kursi[counter[0]-1]+"-";
                                    counter[0]++;
                                    A[finalI].setBackground(Color.yellow);
                                }
                            }
                            else{
                                warn2.setVisible(true);
                            }
                        }
                        });
                    }
                }

        //Selanjutnya
        JButton next = new JButton();
        next.setText("Selanjutnya");
        next.setBounds(370, 700, 180, 40);
        kursiPanel.add(next);

        frame.setVisible(true);

        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!(flag)) {
                        char space = ' ';
                        String u = s.substring(0,s.length()-1)+space;
                        s="";
                        counter[0]=1;
                        index1=0;
                        new ConfirmData(nama, nik, noHP, tAwal, tAkhir, harga, jumlah, u);
                        frame.setVisible(false);
                }
            }
        });
    }
}

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bis extends Main{
    static int[] counter = {1}; static boolean flag = false;
    static String[] kursi = new String[jumlah[0]]; static String s = "";
    public Bis(String nama, long nik, long noHP, String tAwal, String tAkhir, int harga, int jumlah) {
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
                        else {
                            System.out.println(counter[0]);
                            if(counter[0]>jumlah) {
                                warn.setVisible(true);
                            } else {
                                warn.setVisible(false);
                                flag = false;
                                kursi[counter[0]-1] = B[finalI].getText();
                                s+= kursi[counter[0]-1];
                                counter[0]++;
                                B[finalI].setBackground(Color.yellow);
                            }
                        }
                    }

                });

                if(i<17) {
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
                            else {
                                System.out.println(counter[0]);
                                if(counter[0]>jumlah) {
                                    warn.setVisible(true);
                                } else {
                                    warn.setVisible(false);
                                    flag = false;
                                    kursi[counter[0]-1] = A[finalI].getText();
                                    s+= kursi[counter[0]-1];
                                    counter[0]++;
                                    A[finalI].setBackground(Color.yellow);
                                }
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
                    new ConfirmData(nama, nik, noHP, tAwal, tAkhir, harga, jumlah, s);
                    frame.setVisible(false);
                }
            }
        });
    }
}

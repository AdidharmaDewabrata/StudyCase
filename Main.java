import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //frame
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        frame.setLayout(null);
        frame.setVisible(true);

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
                if(i%2 == 0){
                    x = 10;
                    y+= 50;
                }
                else{
                    x += 95;
                }
                A[i].setBounds(x, y, 90, 30);
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
                B[i].setText(b+(i+1));

                if(i%2 == 0){
                    x2 = 370;
                    y2+= 50;
                }

                else{
                    x2 += 95;
                }

                B[i].setBounds(x2, y2, 90, 30);
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

        //Check if tempat duduk telah terisi

        boolean cekA[] = new boolean[18];
        boolean cekB[] = new boolean[22];
    }
}
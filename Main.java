import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(600, 800);
        frame.setLayout(null);
        frame.setVisible(true);

        JLabel label = new JLabel();
        label.setText("Pemesanan Tiket Bus");
        label.setFont(new Font("Times New Roman", Font.ITALIC, 30));
        label.setBounds(75, -200, 500, 500);

        frame.add(label);

        JButton[] A = new JButton[18];

        String a = "A";
        int row1 = 10;
        int y = 30;

        for(int i = 0; i < A.length; i++){
            A[i] = new JButton();
            A[i].setFont(new Font("Times New Roman", Font.BOLD, 8));
            A[i].setText(a+(i+1));
            if(i%2 == 0){
                row1 = 10;
                y+= 55;
            }
            else{
                row1 += 55;
            }
            A[i].setBounds(row1, y, 50, 50);
            frame.add(A[i]);

        }
    }
}
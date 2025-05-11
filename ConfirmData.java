import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class ConfirmData extends Pelanggan {
    static int[] counter = {1};
    public ConfirmData(String nama, long nik, long nohp, String tAwal, String tAkhir, int harga, int jumlah, String kursi) {

        // Frame setup
        JFrame frame = new JFrame("Confirm Data");
        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setBackground(Color.darkGray);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel setup
        JPanel panel = new JPanel();
        panel.setBounds(0, 40, 900, 200);
        panel.setBackground(Color.lightGray);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(null);
        frame.add(panel);

        int Tharga = jumlah*harga;

        // Column titles
        String[] columns = {"No", "Nama", "NIK Penumpang", "No HP", "Titik Awal", "Titik Akhir", "Jumlah Tiket", "Total Harga", "Kursi"};
        String[][] data1 = {{" ", " ", " ", " ", " ", " ", " ", " ", " "}};

        JButton add = new JButton("Tambah Data");
        add.setBounds(490, 150,200, 30);
        add.setBackground(Color.WHITE);
        add.setVisible(true);
        panel.add(add);

        // Custom table model with overridden isCellEditable
        DefaultTableModel model = new DefaultTableModel(data1, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No cell is editable
            }
        };

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(counter[0]==1){
                    String[][] data = {
                            {String.valueOf(counter[0]), nama, String.valueOf(nik), String.valueOf(nohp), tAwal, tAkhir, String.valueOf(jumlah), String.valueOf(Tharga)}
                    };
                    model.setValueAt(String.valueOf(counter[0]), 0, 0);
                    model.setValueAt(nama, 0, 1);
                    model.setValueAt(String.valueOf(nik), 0, 2);
                    model.setValueAt(String.valueOf(nohp), 0, 3);
                    model.setValueAt(tAwal, 0, 4);
                    model.setValueAt(tAkhir, 0, 5);
                    model.setValueAt(jumlah, 0, 6);
                    model.setValueAt(Tharga, 0, 7 );
                    model.setValueAt(kursi, 0, 8 );

                    try(var writer = new PrintWriter("data.txt")){
                        writer.print(counter[0]+",");       writer.print(nama+",");      writer.print(nik+",");        writer.print(nohp+",");
                        writer.print(tAwal+",");             writer.print(tAkhir+",");     writer.print(jumlah+",");       writer.print(Tharga+",");
                        writer.print(kursi);
                        writer.println();
                    } catch(FileNotFoundException d){
                        System.err.println(d);
                    }

                    counter[0]++;
                }
                else{
                    counter[0]++;
                    String[][] data = {
                            {String.valueOf(counter[0]), nama, String.valueOf(nik), String.valueOf(nohp), tAwal, tAkhir, String.valueOf(jumlah), String.valueOf(Tharga)}
                    };
                    model.addRow(data);

                    try(var writer = new PrintWriter("data.txt")){
                        writer.print(counter[0]+",");       writer.print(nama+",");      writer.print(nik+",");        writer.print(nohp+",");
                        writer.print(tAwal+",");             writer.print(tAkhir+",");     writer.print(jumlah+",");       writer.print(Tharga+",");
                        writer.println();
                    } catch(FileNotFoundException d){
                        System.err.println(d);
                    }
                }
            }
        });

        // Create table with data and column names
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 250, 900, 250);
        frame.add(scrollPane);

        //Labels
        JLabel title = new JLabel("Data Penumpang");
        title.setBounds(335, 10, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel name = new JLabel("Nama Penumpang:");
        name.setBounds(10, 50, 150, 20);
        JTextField isiNama = new JTextField(nama);
        isiNama.setEditable(false);
        isiNama.setBounds(170,50,200,20);

        JLabel nik1 = new JLabel("NIK Penumpang:");
        nik1.setBounds(10, 80, 150, 20);
        JTextField isiNik = new JTextField(String.valueOf(nik));
        isiNik.setEditable(false);
        isiNik.setBounds(170,80,200,20);

        JLabel no = new JLabel("No HP:");
        no.setBounds(10, 110, 150, 20);
        JTextField isiNo = new JTextField(String.valueOf(nohp));
        isiNo.setEditable(false);
        isiNo.setBounds(170,110,200,20);

        JLabel titikAwal = new JLabel("Titik Awal:");
        titikAwal.setBounds(10, 140, 150, 20);
        JTextField isiTAwal = new JTextField(tAwal);
        isiTAwal.setEditable(false);
        isiTAwal.setBounds(170,140,200,20);

        JLabel titikAkhir = new JLabel("Titik Akhir:");
        titikAkhir.setBounds(10, 170, 150, 20);
        JTextField isiTAkhir = new JTextField(tAkhir);
        isiTAkhir.setEditable(false);
        isiTAkhir.setBounds(170,170,200,20);

        JLabel jumlahTiket = new JLabel("Jumlah Tiket:");
        jumlahTiket.setBounds(400, 50, 150, 20);
        JTextField isiJumlah = new JTextField(String.valueOf(jumlah));
        isiJumlah.setEditable(false);
        isiJumlah.setBounds(490,50,200,20);

        JLabel hargaTiket = new JLabel("Harga Tiket:");
        hargaTiket.setBounds(400, 80, 150, 20);
        JTextField isiHarga = new JTextField(String.valueOf(harga));
        isiHarga.setEditable(false);
        isiHarga.setBounds(490,80,200,20);

        JLabel harga1 = new JLabel("Total Harga:");
        harga1.setBounds(400, 110, 150, 20);
        JTextField isiHarga1 = new JTextField();
        isiHarga1.setText(String.valueOf(Tharga));
        isiHarga1.setEditable(false);
        isiHarga1.setBounds(490,110,200,20);


        // Add components to frame
        frame.add(title);               panel.add(titikAwal);
        panel.add(name);                panel.add(titikAkhir);
        panel.add(nik1);                panel.add(jumlahTiket);
        panel.add(no);                  panel.add(harga1);
        panel.add(isiTAwal);            panel.add(isiTAkhir);
        panel.add(jumlahTiket);         panel.add(isiJumlah);
        panel.add(isiHarga);            panel.add(isiNama);
        panel.add(isiNik);              panel.add(isiNo);
        panel.add(isiHarga1);           panel.add(hargaTiket);

        frame.setVisible(true);
    }
}
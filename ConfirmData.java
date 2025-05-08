import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ConfirmData extends Pelanggan {
    private String nama;
    public ConfirmData(int counter, String nama, int nik, int nohp, String tAwal, String tAkhir, int harga) {
        this.nama = nama;
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

        // Column titles
        String[] columns = {"No", "Nama Penumpang", "NIK Penumpang", "No HP", "Titik Awal", "Titik Akhir", "Jumlah Tiket", "Harga", "Kode Booking"};

        // Sample data (2D array: rows and columns)
        String[][] data = {
                {String.valueOf(counter), nama, String.valueOf(nik), String.valueOf(nohp), tAwal, tAkhir, String.valueOf(harga)}
        };

        // Custom table model with overridden isCellEditable
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No cell is editable
            }
        };

        // Create table with data and column names
        JTable table = new JTable(model);

        // Wrap table inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 250, 900, 250);

        //Labels
        JLabel title = new JLabel("Data Penumpang");
        title.setBounds(335, 10, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel name = new JLabel("Nama Penumpang:");
        name.setBounds(10, 50, 150, 20);

        JLabel nik1 = new JLabel("NIK Penumpang:");
        nik1.setBounds(10, 80, 150, 20);

        JLabel no = new JLabel("No HP:");
        no.setBounds(10, 110, 150, 20);

        JLabel titikAwal = new JLabel("Titik Awal:");
        titikAwal.setBounds(10, 140, 150, 20);

        JLabel titikAkhir = new JLabel("Titik Akhir:");
        titikAkhir.setBounds(10, 170, 150, 20);

        JLabel jumlahTiket = new JLabel("Jumlah Tiket:");
        jumlahTiket.setBounds(400, 50, 150, 20);

        JLabel harga1 = new JLabel("Total Harga:");
        harga1.setBounds(400, 80, 150, 20);

        // Add components to frame
        frame.add(title);
        panel.add(name);
        panel.add(nik1);
        panel.add(no);
        panel.add(titikAwal);
        panel.add(titikAkhir);
        panel.add(jumlahTiket);
        panel.add(harga1);
        frame.add(scrollPane); // Add the scrollPane containing the table

        JTextPane name1 = new JTextPane();
        name1.setEditable(false);
        name1.setBackground(Color.darkGray);
        name1.setText(nama);

        //Add data to table
        model.addRow(data);

        // Display the frame
        frame.setVisible(true);
    }
}
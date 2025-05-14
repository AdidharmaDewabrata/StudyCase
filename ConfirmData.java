import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class ConfirmData extends Pelanggan {
    static int[] counter = {0}; static String[][] dataa = new String[10][9]; static boolean flag=false; static int index1=0, index2=0;
    public ConfirmData(String nama, long nik, long nohp, String tAwal, String tAkhir, int harga, int jumlah, String kursi) {
        Scanner sc;
        //check if data.txt null ato ga
        File file = new File("data.txt");
        if(file.length()==0){
            flag=true;
            counter[0]++;
        }
        else {
            try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
                while(reader.readLine() !=null){
                    counter[0]++;
                }
            } catch (IOException d) {
                System.err.println(d);
            }

            try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
                int o = 0;
                String s;
                while ((s = reader.readLine()) != null && o < dataa.length) {
                    sc = new Scanner(s);
                    int u = 0;
                    while (sc.hasNext() && u < 9) {
                        dataa[o][u] = sc.next();
                        u++;
                    }
                    o++;
                }

//                counter[0] = Integer.parseInt(dataa[index1-1][0]);
            }catch (IOException d) {
                System.err.println(d);
            }
        }

        // Frame setup
        JFrame frame = new JFrame("Confirm Data");
        frame.setSize(925, 600);
        frame.setLayout(null);
        frame.setBackground(Color.darkGray);
        frame.getContentPane().setBackground(Color.decode("#9a8c98"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel setup
        JPanel panel = new JPanel();
        panel.setBounds(0, 55, 910, 185);
        panel.setBackground(Color.decode("#c9ada7"));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setLayout(null);
        frame.add(panel);
        //Warning cm bisa pencet sekali
        JLabel warn = new JLabel("Data telah ter-input");
        warn.setForeground(Color.red);
        warn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        warn.setBounds(367,530,200,30);
        warn.setVisible(false);
        frame.add(warn);
        //totalharga
        int Tharga = jumlah*harga;
        // Column titles
        String[] columns = {"No", "Nama", "NIK Penumpang", "No HP", "Titik Awal", "Titik Akhir", "Jumlah Tiket", "Total Harga", "Kursi"};
        String[][] data1 = new String[counter[0]][9];

        for(int i=0; i<counter[0]; i++){
            for(int j=0; j<9; j++){
                data1[i][j] = " ";
            }
        }
        //tombol tambah data
        JButton add = new JButton("Tambah Data");
        add.setForeground(Color.decode("#f9dcc4"));
        add.setBounds(350, 515,200, 30);
        add.setBackground(Color.decode("#4a4e69"));
        add.setVisible(true);
        frame.add(add);
        //tombol balek ke homepage
        JButton back = new JButton("Home Page");
        back.setBounds(50, 515,200, 30);
        back.setForeground(Color.decode("#f9dcc4"));
        back.setBackground(Color.decode("#4a4e69"));
        back.setVisible(true);
        frame.add(back);
        //tombol clear data
        JButton clear = new JButton("Clear Data");
        clear.setBounds(650, 515, 200, 30);
        clear.setForeground(Color.decode("#f9dcc4"));
        clear.setBackground(Color.decode("#4a4e69"));
        clear.setVisible(true);
        // biar tabel gbs di edit
        DefaultTableModel model = new DefaultTableModel(data1, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No cell is editable
            }
        };

        for (int i = 0; i < counter[0]; i++) {
            for (int j = 0; j < 9; j++) {
                model.setValueAt(dataa[i][j], i, j);
            }
        }

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //action yang bakalan dilakuin klo file data.txt kosong
                if(flag){
                    index2++;
                    model.setValueAt(String.valueOf(counter[0]+1), 0, 0);
                    model.setValueAt(nama, 0, 1);
                    model.setValueAt(String.valueOf(nik), 0, 2);
                    model.setValueAt(String.valueOf(nohp), 0, 3);
                    model.setValueAt(tAwal, 0, 4);
                    model.setValueAt(tAkhir, 0, 5);
                    model.setValueAt(jumlah, 0, 6);
                    model.setValueAt(Tharga, 0, 7 );
                    model.setValueAt(kursi, 0, 8 );

                    try(PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))){
                        writer.print(counter[0]+" ");       writer.print(nama+" ");      writer.print(nik+" ");        writer.print(nohp+" ");
                        writer.print(tAwal+" ");            writer.print(tAkhir+" ");     writer.print(jumlah+" ");       writer.print(Tharga+" ");
                        writer.print(kursi);
                        writer.println();
                    } catch(IOException d){
                        System.err.println(d);
                    }
                    counter[0]++;
                }
                else{
                    if(index2>0) {
                        warn.setVisible(true);
                    }
                    else{
                            //nambahin data baru ke dalem file data.txt
                            counter[0]++;
                            index2++;
                            String[] data = {String.valueOf(counter[0]), nama, String.valueOf(nik), String.valueOf(nohp), tAwal, tAkhir, String.valueOf(jumlah), String.valueOf(Tharga), kursi };
                            model.addRow(data);

                            try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
                                writer.print(counter[0] + " ");
                                writer.print(nama + " ");
                                writer.print(nik + " ");
                                writer.print(nohp + " ");
                                writer.print(tAwal + " ");
                                writer.print(tAkhir + " ");
                                writer.print(jumlah + " ");
                                writer.print(Tharga + " ");
                                writer.print(kursi);
                                writer.println();
                            } catch (IOException d) {
                                System.err.println(d);
                            }
                        }
                    }
                }
        });

        // Create table with data and column names
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 250, 890, 250);
        frame.add(scrollPane);

        //Labels
        JLabel title = new JLabel("Data Penumpang");
        title.setBounds(380, 10, 400, 30);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.decode("#f9dcc4"));

        JLabel name = new JLabel("Nama Penumpang:");
        name.setBounds(10, 40, 150, 20);
        JTextField isiNama = new JTextField(nama);
        isiNama.setEditable(false);
        isiNama.setBounds(170,40,200,20);

        JLabel nik1 = new JLabel("NIK Penumpang:");
        nik1.setBounds(10, 70, 150, 20);
        JTextField isiNik = new JTextField(String.valueOf(nik));
        isiNik.setEditable(false);
        isiNik.setBounds(170,70,200,20);

        JLabel no = new JLabel("No HP:");
        no.setBounds(10, 100, 150, 20);
        JTextField isiNo = new JTextField(String.valueOf(nohp));
        isiNo.setEditable(false);
        isiNo.setBounds(170,100,200,20);

        JLabel titikAwal = new JLabel("Titik Awal:");
        titikAwal.setBounds(10, 130, 150, 20);
        JTextField isiTAwal = new JTextField(tAwal);
        isiTAwal.setEditable(false);
        isiTAwal.setBounds(170,130,200,20);

        JLabel titikAkhir = new JLabel("Titik Akhir:");
        titikAkhir.setBounds(550, 130, 150, 20);
        JTextField isiTAkhir = new JTextField(tAkhir);
        isiTAkhir.setEditable(false);
        isiTAkhir.setBounds(640,130,200,20);

        JLabel jumlahTiket = new JLabel("Jumlah Tiket:");
        jumlahTiket.setBounds(550, 40, 150, 20);
        JTextField isiJumlah = new JTextField(String.valueOf(jumlah));
        isiJumlah.setEditable(false);
        isiJumlah.setBounds(640,40,200,20);

        JLabel hargaTiket = new JLabel("Harga Tiket:");
        hargaTiket.setBounds(550, 70, 150, 20);
        JTextField isiHarga = new JTextField(String.valueOf(harga));
        isiHarga.setEditable(false);
        isiHarga.setBounds(640,70,200,20);

        JLabel harga1 = new JLabel("Total Harga:");
        harga1.setBounds(550, 100, 150, 20);
        JTextField isiHarga1 = new JTextField();
        isiHarga1.setText(String.valueOf(Tharga));
        isiHarga1.setEditable(false);
        isiHarga1.setBounds(640,100,200,20);

        //back button action
        back.addActionListener(e -> {
            index2=0;
            counter[0]=0;
            flag=false;
            new HomePage();
            frame.setVisible(false);
        });

        //clear button action
        clear.addActionListener(e -> {
           for(int i = 0; i < counter[0]; i++){
               model.removeRow(i);
           }

           try(PrintWriter writer = new PrintWriter(new FileWriter("data.txt", false))){
                writer.print("");
           }catch(IOException d){
               System.err.println(d);
           }
        });

        // Add components to frame
        frame.add(title);               panel.add(titikAwal);           frame.add(clear);
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
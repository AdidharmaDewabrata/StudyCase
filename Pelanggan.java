public class Pelanggan {
    private String nama, tAwal, tAkhir, nik, noHP,noKursi;
    private int harga, index, index2;

    public String[] list = new String[]{"WILANGAN", "NGAWI", "GENDINGAN", "SOLO", "KARTOSURO", "JOGJA", "MAGELANG"};

    public Pelanggan() {}

    public Pelanggan(String nama, String tAwal, String tAkhir, String nik, String noHP, String noKursi, int harga) {
        this.nama = nama;       this.nik = nik;         this.harga = harga;
        this.tAwal = tAwal;     this.noHP = noHP;       this.noKursi = noKursi;
        this.tAkhir = tAkhir;
    }

    public String getNama() {return nama;}
    public void setNama(String nama) {this.nama = nama;}
    public String getTAwal() {return tAwal;}
    public void setTAwal(String tAwal) { this.tAwal = tAwal;}
    public String getTAkhir() {return tAkhir;}
    public void setTAkhir(String tAkhir) { this.tAkhir = tAkhir;}
    public String getNik() {return nik;}
    public void setNik(String nik) { this.nik = nik;}
    public String getNoHP() {return noHP;}
    public void setNoHP(String noHP) {this.noHP = noHP;}
    public String getNoKursi() {return noKursi;}
    public void setNoKursi(String noKursi) {this.noKursi = noKursi;}

    public int getHarga(String tAwal, String tAkhir) {
        int[][] hargabis = {
                {0, 35, 45, 55, 60, 70, 80}, //Wilangan
                {0, 0, 25, 30, 40, 45, 60}, //Ngawi
                {0, 0, 0, 25, 35, 40, 55}, //Gendingan
                {0, 0, 0, 0, 15, 15, 30}, //Solo
                {0, 0, 0, 0, 0, 15, 30}, //Kartosuro
                {0, 0, 0, 0, 0, 0, 15}, //Jogja
                {0, 0, 0, 0, 0, 0, 0}  //Magelang
        };

        int index = -1;
        int index2 = -1;

        // Convert to uppercase to match with list
        String fromCity = tAwal.toUpperCase();
        String toCity = tAkhir.toUpperCase();

        // Find the indices
        for (int i = 0; i < list.length; i++) {
            if (fromCity.equals(list[i])) {
                index = i;
            }
            if (toCity.equals(list[i])) {
                index2 = i;
            }
        }

        // Handle errors
        if (index == -1 || index2 == -1) {
            throw new IllegalArgumentException("City not found in list");
        }

        // Check for invalid route (trying to go backwards)
        if (index > index2) {
            return 0; // Or display an error message that this route isn't available
        }

        harga = hargabis[index][index2];
        return harga;

    }




    public String gettAwal(){
        return tAwal;
    }
}
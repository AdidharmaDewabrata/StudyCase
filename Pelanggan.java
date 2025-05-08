public class Pelanggan {
    private String nama, tAwal, tAkhir, noKursi, kode;
    private int harga, index, index2, jmlTiket, nik, noHP;

    public String[] list = new String[]{"WILANGAN", "NGAWI", "GENDINGAN", "SOLO", "KARTOSURO", "JOGJA", "MAGELANG"};

    public Pelanggan() {}

    public Pelanggan(String nama, String tAwal, String tAkhir, int nik, int noHP, String noKursi, int harga, int jmlTiket, String kode) {
        this.nama = nama;       this.nik = nik;             this.harga = harga;
        this.tAwal = tAwal;     this.noHP = noHP;           this.noKursi = noKursi;
        this.tAkhir = tAkhir;   this.jmlTiket = jmlTiket;   this.kode = kode;
    }

    public String getNama() {return nama;}
    public void setNama(String nama) {this.nama = nama;}
    public String getTAwal() {return tAwal;}
    public void setTAwal(String tAwal) { this.tAwal = tAwal;}
    public String getTAkhir() {return tAkhir;}
    public void setTAkhir(String tAkhir) { this.tAkhir = tAkhir;}
    public int getNik() {return nik;}
    public void setNik(int nik) { this.nik = nik;}
    public int getNoHP() {return noHP;}
    public void setNoHP(int noHP) {this.noHP = noHP;}
    public String getNoKursi() {return noKursi;}
    public void setNoKursi(String noKursi) {this.noKursi = noKursi;}
    public void setHarga(int harga) {this.harga = harga;}
    public int getHarga() {return harga;}
    public void setJmlTiket(){this.jmlTiket = jmlTiket;}
    public int getJmlTiket() {return jmlTiket;}
    public String getKode() {return kode;}
    public void setKode(String kode) {this.kode = kode;}

    public int getHarga(String tAwal, String tAkhir){
        int[][] hargabis = {
                {0, 35000, 45000, 55000, 60000, 70000, 80000}, //Wilangan
                {0, 0,     25000, 30000, 40000, 45000, 60000}, //Ngawi
                {0, 0,     0,     25000, 35000, 40000, 55000}, //Gendingan
                {0, 0,     0,     0,     15000, 15000, 30000}, //Solo
                {0, 0,     0,     0,     0,     15000, 30000}, //Kartosuro
                {0, 0,     0,     0,     0,     0,     15000}, //Jogja
                {0, 0,     0,     0,     0,     0,     0    }  //Magelang
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

    public String checkRoute(String tAwal, String tAkhir){
        String fromCity = tAwal.toUpperCase();
        String toCity = tAkhir.toUpperCase();
        String s = "";

        for (int i = 0; i < list.length; i++) {
            if (fromCity.equals(list[i])) {
                index = i;
            }
            if (toCity.equals(list[i])) {
                index2 = i;
            }
        }

        if(index2 < index){
            s =  "Titik tujuan tidak boleh mendahului titik keberangkatan";
        }
        else if(index2 == index){
            s =  "Titik keberangkatan tidak boleh sama dengan titik tujuan";
        }
        else {s = " ";}

        return s;
    }

    public Object[] toRow(){
        return new Object[]{Main.counter, nik, noHP, tAwal, tAkhir, jmlTiket, harga, kode};
    }
}
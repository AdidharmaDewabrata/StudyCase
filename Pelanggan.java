public class Pelanggan {
    private String nama, tAwal, tAkhir, nik, noHP,noKursi;
    private int harga, index;

    public String[] list = new String[]{"WILANGAN", "NGAWI", "GENDINGAN", "SOLO", "KARTOSURO", "JOGJA", "MAGELANG"};
    public int[][] price = new int[7][6];

    public Pelanggan(String nama, String tAwal, String tAkhir, String nik, String noHP, String noKursi, int harga) {
        this.nama = nama;       this.nik = nik;         this.harga = harga;
        this.tAwal = tAwal;     this.noHP = noHP;       this.noKursi = noKursi;
        this.tAkhir = tAkhir;
    }



    public static void setHarga(String tAwal, String tAkhir) {

        for(int i = 0; i < 7; i++){         //nentuin index
            if(tAwal.equals(list[i])){
                index = i;
            }


        }



    }

    public int getHarga() {
        return harga;
    }

    public String gettAwal(){
        return tAwal;
    }
}
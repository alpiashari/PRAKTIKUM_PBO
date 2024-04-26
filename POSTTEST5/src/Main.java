import java.io.*;
import java.util.*;

public final class Main {
    private static final InputStreamReader p = new InputStreamReader(System.in);
    private static final BufferedReader input = new BufferedReader(p);
    private static final ArrayList<SepakBola> DataSepakBola = new ArrayList<>();

    @SuppressWarnings("unused")
    private static final void clear() {
        System.out.println("\017\200\0171");
    }

    public static final void main(String[] args) throws Exception {
        while (true) {
            System.out.println("1. Tambah data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Update data");
            System.out.println("4. Hapus data");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan >>> ");
            final int pilih = Integer.parseInt(input.readLine());
            switch (pilih) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    hapusData();
                    break;
                case 5:
                    System.out.println("Thank You");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid");
                    break;
            }
        }
    }

    static final void tambahData() throws NumberFormatException, IOException {
        System.out.println("Tambah Data");
        System.out.println("===============");
        System.out.println("1. Tambah satu data");
        System.out.println("2. Tambah beberapa data sekaligus");
        System.out.print("Masukkan pilihan >>> ");
        final int pilih = Integer.parseInt(input.readLine());
        switch (pilih) {
            case 1:
                tambahSatuData();
                break;
            case 2:
                tambahBeberapaData();
                break;
            default:
                System.out.println("Pilihan Tidak Valid");
                break;
        }
    }

    static final void tambahSatuData() throws NumberFormatException, IOException {
        System.out.println("Masukkan Merek Bola (Puma/Adidas) >>> ");
        final String merek = input.readLine();
        String kode;
        while (true) {
            System.out.println("Masukkan Kode Barang >>>");
            kode = input.readLine();
            if (cekKode(kode)) {
                System.out.println("Kode Sudah ada!");
            } else {
                break;
            }
        }
        System.out.println("Masukkan Nama Barang >>>");
        final String nama = input.readLine();
        System.out.println("Masukkan Harga Barang >>>");
        final int harga = Integer.parseInt(input.readLine());
        if (merek.equalsIgnoreCase("Puma")) {
            System.out.println("Masukkan Jenis Bola Puma >>> ");
            final String jenis = input.readLine();
            final BolaPuma bolaPuma = new BolaPuma(kode, nama, harga, jenis);
            DataSepakBola.add(bolaPuma);
        } else if (merek.equalsIgnoreCase("Adidas")) {
            System.out.println("Masukkan Warna Bola Adidas >>> ");
            final String warna = input.readLine();
            final BolaAdidas bolaAdidas = new BolaAdidas(kode, nama, harga, warna);
            DataSepakBola.add(bolaAdidas);
        } else {
            System.out.println("Merek bola tidak dikenali!");
        }
        System.out.println("Data Telah diTambahkan!!!");
    }

    static final void tambahBeberapaData() throws NumberFormatException, IOException {
        System.out.println("Masukkan Jumlah Data Yang Ingin diTambahkan >>>");
        final int batasan = Integer.parseInt(input.readLine());
        for (int i = 1; i <= batasan; i++) {
            tambahSatuData();
        }
    }

    static final void display() {
        System.out.println("Data Barang Sepak Bola PT. Mitra Sport");
        for (SepakBola bola : DataSepakBola) {
            bola.display();
        }
    }

    static final void updateData() throws IOException {
        System.out.println("Update Data");
        System.out.println("==================");
        System.out.print("Masukkan Kode Data Yang Ingin diUpdate >>>");
        final String kodeUpdate = input.readLine();
        for (SepakBola bola : DataSepakBola) {
            if (bola.getKode().equals(kodeUpdate)) {
                System.out.println("Masukkan Nama Baru >>> ");
                final String newName = input.readLine();
                System.out.println("Masukkan Harga baru >>> ");
                final int newPrice = Integer.parseInt(input.readLine());

                bola.setNama(newName);
                bola.setHarga(newPrice);
                System.out.println("Data Berhasil diUpdate!!!");
                return;
            }
        }
        System.out.println("Data Tidak diTemukan!!!");
    }

    static final void hapusData() throws IOException {
        System.out.println("Hapus Data");
        System.out.println("===============");
        System.out.print("Masukkan Kode Data Yang Ingin diHapus >>>");
        final String kodeHapus = input.readLine();
        Iterator<SepakBola> iterator = DataSepakBola.iterator();
        while (iterator.hasNext()) {
            SepakBola bola = iterator.next();
            if (bola.getKode().equals(kodeHapus)) {
                iterator.remove();
                System.out.println("Data Berhasil diHapus!!!");
                return;
            }
        }
        System.out.println("Data Tidak diTemukan!!!");
    }

    static final boolean cekKode(String kode) {
        for (SepakBola bola : DataSepakBola) {
            if (bola.getKode().equals(kode)) {
                return true;
            }
        }
        return false;
    }
}

abstract class SepakBola {
    private final String kode;
    private String nama;
    private int harga;

    public SepakBola(String kode, String nama, int harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public abstract void display();
}

class BolaPuma extends SepakBola {
    private final String jenis;

    public BolaPuma(String kode, String nama, int harga, String jenis) {
        super(kode, nama, harga);
        this.jenis = jenis;
    }

    @Override
    public void display() {
        System.out.println("Kode: " + getKode());
        System.out.println("Nama: " + getNama());
        System.out.println("Harga: " + getHarga());
        System.out.println("Jenis: " + jenis);
        System.out.println("Merek: Puma");
    }
}

class BolaAdidas extends SepakBola {
    private final String warna;

    public BolaAdidas(String kode, String nama, int harga, String warna) {
        super(kode, nama, harga);
        this.warna = warna;
    }

    @Override
    public void display() {
        System.out.println("Kode: " + getKode());
        System.out.println("Nama: " + getNama());
        System.out.println("Harga: " + getHarga());
        System.out.println("Warna: " + warna);
        System.out.println("Merek: Adidas");
    }
}

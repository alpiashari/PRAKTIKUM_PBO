import java.io.*;
import java.util.*;

public class Main {
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<SepakBola> DataSepakBola = new ArrayList<>();

    @SuppressWarnings("unused")
    private static void clear() {
        System.out.println("\017\200\0171");
    }

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("1. Tambah data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Update data");
            System.out.println("4. Hapus data");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan >>> ");
            int pilih = Integer.parseInt(input.readLine());
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

    static void tambahData() throws NumberFormatException, IOException {
        System.out.println("Tambah Data");
        System.out.println("===============");
        System.out.println("1. Tambah satu data");
        System.out.println("2. Tambah beberapa data sekaligus");
        System.out.print("Masukkan pilihan >>> ");
        int pilih = Integer.parseInt(input.readLine());
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

    static void tambahSatuData() throws NumberFormatException, IOException {
        System.out.println("Masukkan Merek Bola (Puma/Adidas) >>> ");
        String merek = input.readLine();
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
        String nama = input.readLine();
        System.out.println("Masukkan Harga Barang >>>");
        int harga = Integer.parseInt(input.readLine());
        if (merek.equalsIgnoreCase("Puma")) {
            System.out.println("Masukkan Jenis Bola Puma >>> ");
            String jenis = input.readLine();
            BolaPuma bolaPuma = new BolaPuma(kode, nama, harga, jenis);
            DataSepakBola.add(bolaPuma);
        } else if (merek.equalsIgnoreCase("Adidas")) {
            System.out.println("Masukkan Warna Bola Adidas >>> ");
            String warna = input.readLine();
            BolaAdidas bolaAdidas = new BolaAdidas(kode, nama, harga, warna);
            DataSepakBola.add(bolaAdidas);
        } else {
            System.out.println("Merek bola tidak dikenali!");
        }
        System.out.println("Data Telah diTambahkan!!!");
    }

    static void tambahBeberapaData() throws NumberFormatException, IOException {
        System.out.println("Masukkan Jumlah Data Yang Ingin diTambahkan >>>");
        int batasan = Integer.parseInt(input.readLine());
        for (int i = 1; i <= batasan; i++) {
            tambahSatuData();
        }
    }

    static void display() {
        System.out.println("Data Barang Sepak Bola PT. Mitra Sport");
        for (SepakBola bola : DataSepakBola) {
            bola.display();
        }
    }

    static void updateData() throws IOException {
        System.out.println("Update Data");
        System.out.println("==================");
        System.out.print("Masukkan Kode Data Yang Ingin diUpdate >>>");
        String kodeUpdate = input.readLine();
        for (SepakBola bola : DataSepakBola) {
            if (bola.getKode().equals(kodeUpdate)) {
                System.out.println("Masukkan Nama Baru >>> ");
                String newName = input.readLine();
                System.out.println("Masukkan Harga baru >>> ");
                int newPrice = Integer.parseInt(input.readLine());

                bola.setNama(newName);
                bola.setHarga(newPrice);
                System.out.println("Data Berhasil diUpdate!!!");
                return;
            }
        }
        System.out.println("Data Tidak diTemukan!!!");
    }

    static void hapusData() throws IOException {
        System.out.println("Hapus Data");
        System.out.println("===============");
        System.out.print("Masukkan Kode Data Yang Ingin diHapus >>>");
        String kodeHapus = input.readLine();
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

    static boolean cekKode(String kode) {
        for (SepakBola bola : DataSepakBola) {
            if (bola.getKode().equals(kode)) {
                return true;
            }
        }
        return false;
    }
}

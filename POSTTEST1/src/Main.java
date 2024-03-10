import java.io.*;
import java.util.*;

public class Main {
    static int batasan;
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<SepakBola> DataSepakBola = new ArrayList<>();

    @SuppressWarnings("unused")
    private static void clear() {
        System.out.println("\017[H\017[A1");
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
        System.out.println("Masukkan Jumlah Data Yang Ingin diTambahkan >>>");
        batasan = Integer.parseInt(input.readLine());
        for (int i = 1; i <= batasan; i++) {
            System.out.println("Masukkan Kode Barang >>>");
            String kode = input.readLine();
            System.out.println("Masukkan Nama Barang >>>");
            String nama = input.readLine();
            System.out.println("Masukkan Harga Barang>>>");
            int harga = Integer.parseInt(input.readLine());
            SepakBola sba = new SepakBola(kode, nama, harga);
            DataSepakBola.add(sba);
        }
        System.out.println("Data Telah diTambahkan!!!");
    }

    static void display() {
        System.out.println("Data Barang Sepak Bola PT. Mitra Sport");
        for (int i = 0; i < DataSepakBola.size(); i++) {
            DataSepakBola.get(i).display();
        }
    }

    static void updateData() throws IOException {
        System.out.println("Update Data");
        System.out.println("==================");
        System.out.print("Masukkan Kode Data Yang Ingin diUpdate >>>");
        String kodeUpdate = input.readLine();
        for (int i = 0; i < DataSepakBola.size(); i++) {
            SepakBola sepakbola = DataSepakBola.get(i);
            if (sepakbola.getKode().equals(kodeUpdate)) {
                System.out.println("Masukkan Nama Baru >>> ");
                String newName = input.readLine();
                System.out.println("Masukkan Harga baru >>> ");
                int newPrice = Integer.parseInt(input.readLine());

                // Update data
                sepakbola.setNama(newName);
                sepakbola.setHarga(newPrice);
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
        for (int i = 0; i < DataSepakBola.size(); i++) {
            SepakBola sepakBola = DataSepakBola.get(i);
            if (sepakBola.getKode().equals(kodeHapus)) {
                DataSepakBola.remove(i);
                System.out.println("Data Berhasil diHapus!!!");
                return;
            }
        }
        System.out.println("Data Tidak diTemukan!!!");
    }
}



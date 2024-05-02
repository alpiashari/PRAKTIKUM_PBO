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
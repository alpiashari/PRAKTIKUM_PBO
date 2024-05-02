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

public class BolaPuma extends SepakBola {
    private String jenis;

    public BolaPuma(String kode, String nama, int harga, String jenis) {
        super(kode, nama, harga);
        this.jenis = jenis;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Jenis: " + jenis);
    }
}

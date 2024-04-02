public class BolaAdidas extends SepakBola {
    private String warna;

    public BolaAdidas(String kode, String nama, int harga, String warna) {
        super(kode, nama, harga);
        this.warna = warna;
    }

    public String getWarna() {
        return warna;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Warna: " + warna);  
    }
}

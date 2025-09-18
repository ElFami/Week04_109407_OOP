public class Barang {
    private int ID;
    private String Nama;
    private int Stock;
    private int Harga;

    public Barang(int ID, String Nama, int Stock, int Harga) {
        this.ID = ID;
        this.Nama = Nama;
        this.Stock = Stock;
        this.Harga = Harga;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getNama() {
        return Nama;
    }
    public void setNama(String Nama) {
        this.Nama = Nama;
    }
    public int getStock() {
        return Stock;
    }
    public void setStock(int Stock) {
        this.Stock = Stock;
    }
    public int getHarga() {
        return Harga;
    }
    public void setHarga(int Harga) {
        this.Harga = Harga;
    }
}

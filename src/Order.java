import java.util.Scanner;

public class Order {
    static Barang[] orders = new Barang[5];
    static String[] riwayatPesanan = new String[100]; // simpan daftar pesanan
    static int indexPesanan = 0; // penanda index pesanan

    // Inisialisasi data
    public static void stockData() {
        orders[0] = new Barang(1, "Pulpen Easy Gel 0.5mm", 120, 2000);
        orders[1] = new Barang(2, "Penggaris 30cm", 30, 5000);
        orders[2] = new Barang(3, "Tipe-x Roller", 30, 7000);
        orders[3] = new Barang(4, "Pensil Mekanik", 50, 5000);
        orders[4] = new Barang(5, "Buku Tulis", 100, 6000);
    }

    public static void filterData(int ID) {
        Scanner input = new Scanner(System.in);

        for (Barang stockData : orders) {
            if (stockData.getID() == ID) {
                int jumlahBarang;
                while (true) {
                    System.out.print("Masukkan Jumlah : ");
                    jumlahBarang = input.nextInt();

                    if (jumlahBarang <= stockData.getStock() && jumlahBarang > 0) {
                        break;
                    } else {
                        System.out.println("Jumlah tidak valid");
                    }
                }

                int totalHarga = stockData.getHarga() * jumlahBarang;
                System.out.println(jumlahBarang + " " + stockData.getNama() + " dengan total harga Rp" + totalHarga);

                System.out.print("Masukkan jumlah uang : ");
                int jumlahUang = input.nextInt();

                if (jumlahUang >= totalHarga) {
                    System.out.println("Berhasil dipesan");

                    // Simpan ke riwayat pesanan
                    riwayatPesanan[indexPesanan++] = jumlahBarang + "x " + stockData.getNama() + " = Rp" + totalHarga;

                    // Kurangi stok
                    stockData.setStock(stockData.getStock() - jumlahBarang);
                } else {
                    System.out.println("Jumlah uang tidak mencukupi");
                }
                break;
            }
        }
    }

    public static void showData() {
        System.out.println("Daftar Barang Toko Multiguna");
        for (Barang stockData : orders) {
            System.out.println("ID     : " + stockData.getID());
            System.out.println("Nama   : " + stockData.getNama());
            System.out.println("Stock  : " + stockData.getStock());
            System.out.println("Harga  : " + stockData.getHarga());
            System.out.println("----------------------------------");
        }
    }

    // Menu utama
    public static void Menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----Menu Toko Multiguna-----");
        System.out.println("1. Cari Barang berdasarkan ID");
        System.out.println("2. Lihat Hasil Pesanan");
        System.out.print("Pilihan : ");
        int pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                showData();
                System.out.print("Ketik 0 untuh batal\n");
                System.out.print("Pesan barang (ID):"); int id = input.nextInt();
                if (id != 0) filterData(id);
                break;

            case 2:
                System.out.println("----- Riwayat Pesanan -----");
                if (indexPesanan == 0) {
                    System.out.println("Belum ada pesanan.");
                } else {
                    for (int i = 0; i < indexPesanan; i++) {
                        System.out.println((i+1) + ". " + riwayatPesanan[i]);
                    }
                }
                break;

            default:
                Menu();
        }
    }

    public static void main(String[] args) {
        stockData();
        Menu();
    }
}

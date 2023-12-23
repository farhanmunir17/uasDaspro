package tiket_pesawat;

import java.util.Scanner;
import java.util.Map;

public class Tiket_pesawat {
    private static User currentUser;
    private static double userBalance;

    public static void main(String[] args) {
        FlightManager.initializeData();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Registrasi");
            System.out.println("2. Login");
            System.out.println("3. Keluar");
            System.out.print("Pilih Opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    loginUser(scanner);
                    break;
                case 3:
                    System.out.println(" Terima kasih telah menjadi pelanggan setia kami. Sebuah kehormatan memiliki pelanggan seperti Anda");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan Tidak Tersedia. Silahkan Coba Lagi.");
            }

            if (currentUser != null) {
                bookFlight(scanner);
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Masukan nama: ");
        String name = scanner.nextLine();
        System.out.print("Masukan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukan password: ");
        String password = scanner.nextLine();

        UserManager.registerUser(name, email, username, password);
    }

     private static void loginUser(Scanner scanner) {
        System.out.print("Masukan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukan password: ");
        String password = scanner.nextLine();

        currentUser = UserManager.loginUser(username, password);

        if (currentUser != null) {
            System.out.println(" Login Berhasil. Selamat Datang, " + currentUser.username + "!");
        } else {
            System.out.println(" Ada kesalahan username atau password. Silahkan Login Kembali.");
        }
    }

    private static void bookFlight(Scanner scanner) {
        Map<String, Flight> flights = FlightManager.getFlights();
        
        System.out.println("Kemana Anda Ingin Terbang? Penerbangan Tersedia:");
        for (String nomorPenerbangan : flights.keySet()) {
            Flight flight = flights.get(nomorPenerbangan);
            System.out.println(nomorPenerbangan + ". " + flight.getRute() + " - " + flight.getMaskapai() + " - " + flight.getKelas() + " - Rp" + flight.getHarga());
        }

        System.out.print("Pilih Penerbangan (Pilih Nomor): ");
        String nomorPenerbanganDipilih = scanner.nextLine();
        Flight penerbanganDipilih = FlightManager.getFlight(nomorPenerbanganDipilih);

        if (penerbanganDipilih == null) {
            System.out.println("Kesalahan Nomor Penerbangan. Silahkan Coba Lagi.");
            return;
        }

        System.out.println("Selected flight: " + penerbanganDipilih.getRute());
        System.out.println("Total Harga: Rp" + penerbanganDipilih.getHarga());

        System.out.print("Masukan Jumlah Pembayaran: Rp");
        double jumlahPembayaran = scanner.nextDouble();
        scanner.nextLine(); 

        if (jumlahPembayaran < penerbanganDipilih.getHarga()) {
            System.out.println("Uang Anda Tidak Cukup, Silahkan Pergi Sendiri.");
        } else {
            double change = jumlahPembayaran - penerbanganDipilih.getHarga();
            userBalance += penerbanganDipilih.getHarga();
            System.out.println("Booking Berhasil. Kembalian: Rp" + change);
            System.out.println("Kembalian: Rp" + userBalance);
        }
    }
}




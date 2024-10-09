/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Kamar[] kamarList = {
            new Kamar(101, "Deluxe", 500000),
            new Kamar(102, "Suite", 1000000),
            new Kamar(103, "Standard", 300000),
            new Kamar(104, "Presidential", 2000000),
            new Kamar(105, "Executive", 1500000)
        };

        tampilkanMenu(scanner, kamarList);
        scanner.close();
    }

    public static void tampilkanMenu(Scanner scanner, Kamar[] kamarList) {
        System.out.println("\n=== Selamat Datang di Hotel Singaperbangsa ===");
        System.out.println("1. Admin");
        System.out.println("2. Costumer");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        
        int pilihan = 0;
        try {
            pilihan = scanner.nextInt();
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Input tidak valid. Silakan masukkan angka.");
            scanner.nextLine(); 
            tampilkanMenu(scanner, kamarList); 
            return;
        }

        switch (pilihan) {
            case 1:
                adminMenu(scanner, kamarList);
                break;
            case 2:
                costumerMenu(scanner, kamarList);
                break;
            case 3:
                System.out.println("Terima kasih telah menggunakan layanan kami.");
                return; 
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                tampilkanMenu(scanner, kamarList); 
        }
    }

    public static void adminMenu(Scanner scanner, Kamar[] kamarList) {
        System.out.print("Masukkan nama admin: ");
        String namaAdmin = scanner.nextLine();
        Admin admin = new Admin(namaAdmin);
        
        System.out.println("\nAdmin mengelola ketersediaan kamar:");
        admin.kelolaKetersediaanKamar(kamarList[0], false); 
        admin.kelolaKetersediaanKamar(kamarList[2], false); 
        
        System.out.println("\nKamar setelah pengelolaan:");
        tampilkanDetailKamar(kamarList, 0); 

        tampilkanMenu(scanner, kamarList); 
    }

    public static void costumerMenu(Scanner scanner, Kamar[] kamarList) {
        System.out.print("Masukkan nama costumer: ");
        String namaCostumer = scanner.nextLine();
        Costumer costumer = new Costumer(namaCostumer);
        System.out.println("\nCostumer sedang melihat detail kamar yang tersedia:");
        
        if (cekKetersediaanKamar(kamarList, 0, costumer)) {
            System.out.print("\nMasukkan nomor kamar yang ingin dipesan: ");
            int nomorKamar = 0;
            try {
                nomorKamar = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan masukkan nomor kamar yang benar.");
                scanner.nextLine(); 
                costumerMenu(scanner, kamarList); // 
                return;
            }

            System.out.print("Masukkan tanggal pemesanan (format: dd/MM/yyyy): ");
            String tanggalPesan = scanner.nextLine();
            System.out.print("Masukkan tanggal keluar (format: dd/MM/yyyy): ");
            String tanggalKeluar = scanner.nextLine();

            if (!pesanKamar(kamarList, nomorKamar, tanggalPesan, tanggalKeluar, costumer, 0)) {
                System.out.println("Kamar tidak tersedia atau nomor kamar tidak valid.");
            }
        } else {
            System.out.println("Maaf, tidak ada kamar yang tersedia saat ini.");
        }

        tampilkanMenu(scanner, kamarList); 
    }

    public static void tampilkanDetailKamar(Kamar[] kamarList, int index) {
        if (index < kamarList.length) {
            kamarList[index].tampilkanDetail();
            tampilkanDetailKamar(kamarList, index + 1); 
        }
    }

    public static boolean cekKetersediaanKamar(Kamar[] kamarList, int index, Costumer costumer) {
        if (index >= kamarList.length) return false; 
        
        if (kamarList[index].isTersedia()) {
            costumer.lihatDetailKamar(kamarList[index]);
            return true; 
        }

        return cekKetersediaanKamar(kamarList, index + 1, costumer); 
    }

    public static boolean pesanKamar(Kamar[] kamarList, int nomorKamar, String tanggalPesan, String tanggalKeluar, Costumer costumer, int index) {
        if (index >= kamarList.length) return false; 

        if (kamarList[index].getNomorKamar() == nomorKamar && kamarList[index].isTersedia()) {
            costumer.pesanKamar(kamarList[index], tanggalPesan);
            kamarList[index].setTersedia(false, tanggalPesan, tanggalKeluar);
            costumer.lakukanPembayaran(kamarList[index]);
            return true; 
        }

        return pesanKamar(kamarList, nomorKamar, tanggalPesan, tanggalKeluar, costumer, index + 1); 
    }
}

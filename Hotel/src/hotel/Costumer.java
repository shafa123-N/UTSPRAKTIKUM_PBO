/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;
import java.util.Scanner;

public class Costumer extends User implements Pengguna {
    public Costumer(String namaCostumer) {
        setNama(namaCostumer);
    }
    public void lihatDetailKamar(Kamar kamar) {
        kamar.tampilkanDetail();
    }
    public void pesanKamar(Kamar kamar, String tanggalPesan) {
        if (kamar.isTersedia()) {
            kamar.setTersedia(false, tanggalPesan, null);
            System.out.println("Kamar berhasil dipesan oleh " + getNama() + " untuk tanggal " + tanggalPesan);
        } else {
            System.out.println("Maaf, kamar tidak tersedia.");
        }
    }
    public void lakukanPembayaran(Kamar kamar) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silakan pilih metode pembayaran:");
        System.out.println("1. Transfer Bank");
        System.out.println("2. Kartu Kredit");
        int metode = 0;
        try {
            metode = scanner.nextInt();
            scanner.nextLine(); 
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine(); 
            return;
        }
        switch (metode) {
            case 1:
                System.out.println("Anda memilih pembayaran via Transfer Bank.");
                break;
            case 2:
                System.out.println("Anda memilih pembayaran via Kartu Kredit.");
                break;
            default:
                System.out.println("Metode pembayaran tidak valid.");
                break;
        }

        System.out.println("Total yang harus dibayar: Rp " + kamar.getHarga());
        System.out.println("Terima kasih atas pembayarannya, " + getNama() + "!");
    }
}

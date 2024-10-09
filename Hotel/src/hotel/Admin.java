/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel;

/**
 *
 * @author Acer E5
 */
public class Admin   extends User implements Pengguna {
    public Admin(String namaAdmin) {
        setNama(namaAdmin);
    }
    public void lihatDetailKamar(Kamar kamar) {
        kamar.tampilkanDetail();
    }
    public void pesanKamar(Kamar kamar, String tanggalPesan) {
        System.out.println("Admin tidak dapat memesan kamar.");
    }

    public void kelolaKetersediaanKamar(Kamar kamar, boolean tersedia) {
        kamar.setTersedia(tersedia, null, null);
        System.out.println("Ketersediaan kamar " + kamar.getNomorKamar() + " telah diperbarui.");
    }
}

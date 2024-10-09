/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

/**
 *
 * @author Acer E5
 */
public class Kamar {
     private int nomorKamar;
    private boolean tersedia;
    private String tipeKamar;
    private double harga;
    private String tanggalMasuk;
    private String tanggalKeluar;
    public Kamar(int nomorKamar, String tipeKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.harga = harga;
        this.tersedia = true;
        this.tanggalMasuk = null;
        this.tanggalKeluar = null;
    }
    public int getNomorKamar() {
        return nomorKamar;
    }
    public boolean isTersedia() {
        return tersedia;
    }
    public void setTersedia(boolean tersedia, String tanggalMasuk, String tanggalKeluar) {
        this.tersedia = tersedia;
        if (!tersedia) {
            this.tanggalMasuk = tanggalMasuk;
            this.tanggalKeluar = tanggalKeluar;
        } else {
            this.tanggalMasuk = null;
            this.tanggalKeluar = null;
        }
    }
    public String getTipeKamar() {
        return tipeKamar;
    }
    public double getHarga() {
        return harga;
    }
    public void tampilkanDetail() {
        System.out.println("=========================================");
        System.out.println("Nomor Kamar: " + nomorKamar);
        System.out.println("Tipe Kamar: " + tipeKamar);
        System.out.println("Harga: Rp " + harga);
        System.out.println("Tersedia: " + (tersedia ? "Ya" : "Tidak"));
        if (!tersedia) {
            System.out.println("Tanggal Masuk : " + tanggalMasuk);
            System.out.println("Tanggal Keluar : " + tanggalKeluar);
        }
        System.out.println("=========================================");
    }

 }



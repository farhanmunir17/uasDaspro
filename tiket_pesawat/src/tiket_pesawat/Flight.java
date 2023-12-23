package tiket_pesawat;

public class Flight {
    private String rute;
    private String maskapai;
    private String kelas;
    private double harga;

    public Flight(String rute, String maskapai, String kelas, double harga) {
        this.rute = rute;
        this.maskapai = maskapai;
        this.kelas = kelas;
        this.harga = harga;
    }

    public String getRute() {
        return rute;
    }

    public String getMaskapai() {
        return maskapai;
    }

    public String getKelas() {
        return kelas;
    }

    public double getHarga() {
        return harga;
    }
}



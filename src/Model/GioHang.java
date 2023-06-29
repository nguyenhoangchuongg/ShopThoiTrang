/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Phan Tuan Kiet
 */
public class GioHang {
    String makh;
    String maSP;
    String tenSP;
    Float giaban;
    int soluong;
    Float tongtien;
    boolean check;
    int mahoadon;

    
    public GioHang() {
    }

    public GioHang(String makh, String maSP, String tenSP, Float giaban, int soluong, Float tongtien, boolean check, int mahoadon) {
        this.makh = makh;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaban = giaban;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.check = check;
        this.mahoadon = mahoadon;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Float getGiaban() {
        return giaban;
    }

    public void setGiaban(Float giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public Float getTongtien() {
        return tongtien;
    }

    public void setTongtien(Float tongtien) {
        this.tongtien = tongtien;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(int mahoadon) {
        this.mahoadon = mahoadon;
    }

}

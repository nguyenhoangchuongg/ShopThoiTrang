/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hoangchuongnguyen
 */
public class ChiTietHoaDonXuat {
    private String MaSP;
    private int MaHDX ;
    private float GiaBan ;
    private int SoLuong ;
    private float TongTien ;

    public ChiTietHoaDonXuat() {
    }

    public ChiTietHoaDonXuat(String MaSP, int MaHDX, float GiaBan, int SoLuong, float TongTien) {
        this.MaSP = MaSP;
        this.MaHDX = MaHDX;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
        this.TongTien = TongTien;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public int getMaHDX() {
        return MaHDX;
    }

    public void setMaHDX(int MaHDX) {
        this.MaHDX = MaHDX;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }
    
}

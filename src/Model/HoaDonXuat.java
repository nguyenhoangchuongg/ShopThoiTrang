/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author hoangchuongnguyen
 */
public class HoaDonXuat {
    private int MaHDX ;
    private String MaNV;
    private int MaKH ;
    private Date NgayBan ;
    private String TinhTrang ;
    private boolean check;
    public HoaDonXuat() {
    }

    public HoaDonXuat(int MaHDX, String MaNV, int MaKH, Date NgayBan, String TinhTrang, boolean check) {
        this.MaHDX = MaHDX;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayBan = NgayBan;
        this.TinhTrang = TinhTrang;
        this.check = check;
    }

    public int getMaHDX() {
        return MaHDX;
    }

    public void setMaHDX(int MaHDX) {
        this.MaHDX = MaHDX;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayBan() {
        return NgayBan;
    }

    public void setNgayBan(Date NgayBan) {
        this.NgayBan = NgayBan;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }


    
}

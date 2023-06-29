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
public class NhanVien {
    private String MaNV ;
    private String TenNV ;
    private String TenTK ;
    private boolean GioiTinh;
    private String DiaChi;
    private Date NgaySinh ;
    private String Email;
    private String CCCD ;
    private String SoDienThoai ;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, String TenTK, boolean GioiTinh, String DiaChi, Date NgaySinh, String Email, String CCCD, String SoDienThoai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.TenTK = TenTK;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.Email = Email;
        this.CCCD = CCCD;
        this.SoDienThoai = SoDienThoai;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    
}

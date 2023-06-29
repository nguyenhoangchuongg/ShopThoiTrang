/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hoangchuongnguyen
 */
public class KhachHang {
    private int MaKH ;
    private String TenKH;
    private String TenTK;
    private String SoDienThoai ;
    private String DiaChi ;
    private boolean GioiTinh;
    private String Email ;

    public KhachHang() {
    }

    public KhachHang(int MaKH, String TenKH, String TenTK, String SoDienThoai, String DiaChi, boolean GioiTinh, String Email) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.TenTK = TenTK;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.Email = Email;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
}

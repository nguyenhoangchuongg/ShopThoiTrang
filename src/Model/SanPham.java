/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hoangchuongnguyen
 */
public class SanPham {

    private String MaSP;
    private String TenSP;
    private String TenLoai;
    private float GiaNhap ;
    private int SoLuong;
    private String NguocGoc ;
    private String KichCo ;
    private String ChatLieu ;
    private String GioiThieu ;
    private String Hinh ;

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, String TenLoai, float GiaNhap, int SoLuong, String NguocGoc, String KichCo, String ChatLieu, String GioiThieu, String Hinh) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.TenLoai = TenLoai;
        this.GiaNhap = GiaNhap;
        this.SoLuong = SoLuong;
        this.NguocGoc = NguocGoc;
        this.KichCo = KichCo;
        this.ChatLieu = ChatLieu;
        this.GioiThieu = GioiThieu;
        this.Hinh = Hinh;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getNguocGoc() {
        return NguocGoc;
    }

    public void setNguocGoc(String NguocGoc) {
        this.NguocGoc = NguocGoc;
    }

    public String getKichCo() {
        return KichCo;
    }

    public void setKichCo(String KichCo) {
        this.KichCo = KichCo;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public String getGioiThieu() {
        return GioiThieu;
    }

    public void setGioiThieu(String GioiThieu) {
        this.GioiThieu = GioiThieu;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }


    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hoangchuongnguyen
 */
public class TaiKhoan {
    private String TenTK ;
    private String MatKhau ;
    private String VaiTro ;

    public TaiKhoan() {
    }

    public TaiKhoan(String TenTK, String MatKhau, String VaiTro) {
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}

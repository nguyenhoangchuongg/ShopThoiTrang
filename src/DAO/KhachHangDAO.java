/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangchuongnguyen
 */
public class KhachHangDAO extends ProDAO<KhachHang, Integer> {

    @Override
    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang(MaKhachHang,TenKhachHang,TenTaiKhoan,SoDienThoai,DiaChi,GioiTinh,Email) VALUES (?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaKH(), model.getTenKH(), model.getTenTK(), model.getSoDienThoai(), model.getDiaChi(), model.isGioiTinh(), model.getEmail());

    }

    @Override
    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang SET TenKhachHang=?,TenTaiKhoan=?,SoDienThoai=?,DiaChi=?,GioiTinh=?,Email=? WHERE MaKhachHang = ?";
        JdbcHelper.executeUpdate(sql, model.getTenKH(), model.getTenTK(), model.getSoDienThoai(), model.getDiaChi(), model.isGioiTinh(), model.getEmail(), model.getMaKH());
    }

    @Override
    public void delete(Integer makh) {
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        JdbcHelper.executeUpdate(sql, makh);
    }

    @Override
    public KhachHang selectById(Integer makh) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang=?";
        List<KhachHang> list = selectBySql(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }
    public void update1(KhachHang model) {
        String sql = "UPDATE KhachHang SET TenKhachHang=?,SoDienThoai=?,DiaChi=?,GioiTinh=?,Email=? WHERE MaKhachHang = ?";
        JdbcHelper.executeUpdate(sql, model.getTenKH(), model.getSoDienThoai(), model.getDiaChi(), model.isGioiTinh(), model.getEmail(), model.getMaKH());
    }
    public KhachHang select(int makh){
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang=?";
         List<KhachHang> list = selectBySql(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    public KhachHang selecttkkhbyid(String tentk) {
        String sql = "SELECT * FROM TaiKhoan tk inner join KhachHang kh on tk.TenTaiKhoan = kh.TenTaiKhoan \n"
                + "WHERE tk.TenTaiKhoan=?";
        List<KhachHang> list = selectBySql(sql, tentk);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM KhachHang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaKH(rs.getInt("MaKhachHang"));
        model.setTenKH(rs.getString("TenKhachHang"));
        model.setTenTK(rs.getString("TenTaiKhoan"));
        model.setSoDienThoai(rs.getString("SoDienThoai"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setEmail(rs.getString("Email"));
        return model;
    }
}

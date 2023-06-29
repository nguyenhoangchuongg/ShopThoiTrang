/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangchuongnguyen
 */
public class NhanVienDAO extends ProDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien(MaNhanVien,TenNhanVien,TenTaiKhoan,GioiTinh,DiaChi,NgaySinh,Email,CCCD,SoDienThoai)VALUES (?, ?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaNV(), model.getTenNV(),model.getTenTK(), model.isGioiTinh(), model.getDiaChi(), model.getNgaySinh(),model.getEmail(), model.getCCCD(), model.getSoDienThoai());
    }

    @Override
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET TenNhanVien=?, GioiTinh=?, DiaChi =? ,NgaySinh =?, Email = ?, CCCD =?, SoDienThoai = ? WHERE MaNhanVien=?";
        JdbcHelper.executeUpdate(sql, model.getTenNV(), model.isGioiTinh(), model.getDiaChi(), model.getNgaySinh(),model.getEmail(), model.getCCCD(), model.getSoDienThoai(), model.getMaNV());
    }
   @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNhanVien=?";
        JdbcHelper.executeUpdate(sql, MaNV);
    }
    
    public void deletenv_tk(String tentk){
        String sql = "DELETE NhanVien from NhanVien\n" +
"INNER join TaiKhoan on NhanVien.TenTaiKhoan = TaiKhoan.TenTaiKhoan \n" +
"WHERE  NhanVien.TenTaiKhoan = ?";
        JdbcHelper.executeUpdate(sql, tentk);
    }
 

    @Override
    public NhanVien selectById(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNhanVien=?";
        List<NhanVien> list = selectBySql(sql, manv);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    
    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM NhanVien";
        return selectBySql(sql);
    }
        

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
                List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
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
        

    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNhanVien"));
        model.setTenNV(rs.getString("TenNhanVien"));
        model.setTenTK(rs.getString("TentaiKhoan"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setEmail(rs.getString("Email"));
        model.setCCCD(rs.getString("CCCD"));
        model.setSoDienThoai(rs.getString("SoDienThoai"));
        return model;
    }

}

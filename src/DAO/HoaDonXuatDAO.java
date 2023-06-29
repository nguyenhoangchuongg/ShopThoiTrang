/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.HoaDonXuat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangchuongnguyen
 */
public class HoaDonXuatDAO extends ProDAO<HoaDonXuat, Integer> {

//    @Override
//    public void insert(HoaDonXuat model) {
//        String sql = "INSERT INTO HoaDonXuat(MaHoaDonXuat,MaNhanVien,MaKhachHang,NgayBan,TinhTrang)VALUES(?,?,?,?,?)";
//        JdbcHelper.executeUpdate(sql, model.getMaHDX(), model.getMaNV(), model.getMaKH(), model.getNgayBan(),model.getTinhTrang());
//    }
//
//    @Override
//    public void update(HoaDonXuat model) {
//        String sql = "UPDATE HoaDonXuat SET MaHoaDonXuat = ? ,MaNhanVien = ?,MaKhachHang = ?,NgayBan = ?, TinhTrang = ? WHERE MaHoaDonXuat = ?";
//        JdbcHelper.executeUpdate(sql,model.getMaHDX(),model.getMaNV(),model.getMaKH(),model.getNgayBan(),model.getTinhTrang(), model.getMaHDX());
//    }
//  
    public void updatehd(Integer mhd){
        String sql = "UPDATE HoaDonXuat SET TinhTrang = N'Đã xác nhận' WHERE MaHoaDonXuat = ?";
        JdbcHelper.executeUpdate(sql, mhd);
    }
//    @Override
//    public void delete(Integer mahdx) {
//        String sql = "DELETE from HoaDonXuat WHERE MaHoaDonXuat = ?";
//        JdbcHelper.executeUpdate(sql, mahdx);
//    }
//
    @Override
    public HoaDonXuat selectById(Integer mahdx) {
        String sql = "SELECT * FROM HoaDonXuat WHERE MaHoaDonXuat=?";
        List<HoaDonXuat> list = selectBySql(sql, mahdx);
        return list.size() > 0 ? list.get(0) : null;
    }
    @Override
    public void insert(HoaDonXuat model) {
        String sql = "INSERT INTO HoaDonXuat(MaHoaDonXuat,MaNhanVien,MaKhachHang,NgayBan,TinhTrang)VALUES(?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaHDX(), model.getMaNV(), model.getMaKH(), model.getNgayBan(), model.getTinhTrang());
    }

    @Override
    public void update(HoaDonXuat model) {
        String sql = "UPDATE HoaDonXuat SET MaHoaDonXuat = ? ,MaNhanVien = ?,MaKhachHang = ?,NgayBan = ?, TinhTrang = ? WHERE MaHoaDonXuat = ?";
        JdbcHelper.executeUpdate(sql, model.getMaHDX(), model.getMaNV(), model.getMaKH(), model.getNgayBan(), model.getTinhTrang(), model.getMaHDX());
    }

//    public void updatehd(String mhd) {
//        String sql = "UPDATE HoaDonXuat SET TinhTrang = 'Đã thanh toán' WHERE MaHoaDonXuat = ?";
//        JdbcHelper.executeUpdate(sql, mhd);
//    }

 
    public void delete(String mahdx) {
        String sql = "DELETE HoaDonXuat FROM HoaDonXuat \n"
                + "INNER JOIN ChiTietHoaDonXuat on HoaDonXuat.MaHoaDonXuat = ChiTietHoaDonXuat.MaHoaDonXuat \n"
                + "WHERE ChiTietHoaDonXuat.MaHoaDonXuat = ?";
        JdbcHelper.executeUpdate(sql, mahdx);
    }

    public HoaDonXuat selectById(String mahdx) {
        String sql = "SELECT * FROM HoaDonXuat WHERE MaHoaDonXuat=?";
        List<HoaDonXuat> list = selectBySql(sql, mahdx);
        return list.size() > 0 ? list.get(0) : null;
    }

  
    public List<HoaDonXuat> selectAlltt() {
        String sql = "select * from HoaDonXuat WHERE TinhTrang not in ( select TinhTrang from HoaDonXuat where TinhTrang = N'Chờ thanh toán')";
        return selectBySql(sql);
    }

    @Override
    public List<HoaDonXuat> selectAll() {
        String sql = "SELECT * FROM HoaDonXuat";
        return selectBySql(sql);
    }
    @Override
    protected List<HoaDonXuat> selectBySql(String sql, Object... args) {
        List<HoaDonXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonXuat model = readFromResultSet(rs);
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

    private HoaDonXuat readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonXuat model = new HoaDonXuat();
        model.setMaHDX(rs.getInt("MaHoaDonXuat"));
        model.setMaNV(rs.getString("MaNhanVien"));
        model.setMaKH(rs.getInt("MaKhachHang"));
        model.setNgayBan(rs.getDate("NgayBan"));
        model.setTinhTrang(rs.getNString("TinhTrang"));
        return model;
    }

    public List<Integer> selectYears() {
        String sql = "SELECT DISTINCT year(NgayBan) FROM HoaDonXuat ORDER BY year(NgayBan) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> selectMonth() {
        String sql = "SELECT DISTINCT month(NgayBan)  FROM HoaDonXuat ORDER BY month(NgayBan) DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}

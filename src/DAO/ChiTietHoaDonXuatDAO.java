/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.ChiTietHoaDonXuat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangchuongnguyen
 */
public class ChiTietHoaDonXuatDAO extends ProDAO<ChiTietHoaDonXuat, String> {

    @Override
    public void insert(ChiTietHoaDonXuat model) {
        String sql = "INSERT INTO ChiTietHoaDonXuat(MaSanPham,MaHoaDonXuat,GiaBan,SoLuong,TongTien) VALUES (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaSP(), model.getMaHDX(), model.getGiaBan(), model.getSoLuong(), model.getTongTien());
    }

    @Override
    public void update(ChiTietHoaDonXuat model) {
        String sql = "UPDATE ChiTietHoaDonXuat SET MaHoaDonXuat = ?,GiaBan =?,SoLuong=?,TongTien=? WHERE MaSanPham=?";
        JdbcHelper.executeUpdate(sql, model.getMaHDX(), model.getGiaBan(), model.getSoLuong(), model.getTongTien(), model.getMaSP());
    }

    @Override
    public void delete(String mahdx) {
        String sql = "DELETE FROM ChiTietHoaDonXuat WHERE MaHoaDonXuat = ?";
        JdbcHelper.executeUpdate(sql, mahdx);
    }

    @Override
    public ChiTietHoaDonXuat selectById(String mahdx) {
        String sql = "SELECT * FROM ChiTietHoaDonXuat WHERE MaHoaDonXuat=?";
        List<ChiTietHoaDonXuat> list = selectBySql(sql, mahdx);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ChiTietHoaDonXuat> selectAll() {
        String sql = "SELECT * FROM ChiTietHoaDonXuat";
        return selectBySql(sql);
    }

    @Override
    protected List<ChiTietHoaDonXuat> selectBySql(String sql, Object... args) {
        List<ChiTietHoaDonXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChiTietHoaDonXuat model = readFromResultSet(rs);
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

    private ChiTietHoaDonXuat readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietHoaDonXuat model = new ChiTietHoaDonXuat();
        model.setMaSP(rs.getString("MaSanPham"));
        model.setMaHDX(rs.getInt("MaHoaDonXuat"));
        model.setGiaBan(rs.getFloat("GiaBan"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setTongTien(rs.getFloat("TongTien"));
        return model;
    }
}

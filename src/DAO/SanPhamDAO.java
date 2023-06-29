/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangchuongnguyen
 */
public class SanPhamDAO extends ProDAO<SanPham, String> {

    @Override
    public void insert(SanPham model) {
        String sql = "INSERT INTO SanPham(MaSanPham,TenSanPham,GiaNhap,SoLuong,NguonGoc,KichCo,ChatLieu,GioiThieu,Hinh) VALUES(?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaSP(), model.getTenSP(), model.getGiaNhap(), model.getSoLuong(), model.getNguocGoc(), model.getKichCo(), model.getChatLieu(), model.getGioiThieu(), model.getHinh());
    }

    @Override
    public void update(SanPham model) {
        String sql = "UPDATE SanPham SET TenSanPham=?,GiaNhap=?,SoLuong=?,NguonGoc=?,KichCo=?,ChatLieu=?,GioiThieu=?,Hinh=? WHERE MaSanPham = ?";
        JdbcHelper.executeUpdate(sql, model.getTenSP(), model.getGiaNhap(), model.getSoLuong(), model.getNguocGoc(), model.getKichCo(), model.getChatLieu(), model.getGioiThieu(), model.getHinh(), model.getMaSP());
    }

    @Override
    public void delete(String masp) {
        String sql = "DELETE FROM SanPham WHERE MaSanPham = ?";
        JdbcHelper.executeUpdate(sql, masp);
    }

    @Override
    public SanPham selectById(String masap) {
                String sql = "SELECT * FROM SanPham WHERE MaSanPham=?";
        List<SanPham> list = selectBySql(sql, masap);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void updatesl(int sl, String masp){
        String sql = "UPDATE SanPham Set SoLuong = ? where MaSanPham=?";
        JdbcHelper.executeUpdate(sql, sl, masp);
    }
    @Override
    public List<SanPham> selectAll() {
        String sql = "SELECT * FROM SanPham";
        return selectBySql(sql);
    }
        

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SanPham model = readFromResultSet(rs);
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

    private SanPham readFromResultSet(ResultSet rs) throws SQLException {
        SanPham model = new SanPham();
        model.setMaSP(rs.getString("MaSanPham"));
        model.setTenSP(rs.getString("TenSanPham"));
        model.setGiaNhap(rs.getFloat("GiaNhap"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setNguocGoc(rs.getString("NguonGoc"));
        model.setKichCo(rs.getString("KichCo"));
        model.setChatLieu(rs.getString("ChatLieu"));
        model.setGioiThieu(rs.getString("GioiThieu"));
        model.setHinh(rs.getString("Hinh"));
        return model;
    }
}

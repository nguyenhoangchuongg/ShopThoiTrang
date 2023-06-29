/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import Model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoangchuongnguyen
 */
public class TaiKhoanDAO extends ProDAO<TaiKhoan, String> {

    @Override
    public void insert(TaiKhoan model) {
        String sql = "INSERT INTO TaiKhoan(TenTaiKhoan,MatKhau,VaiTro) VALUES (?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getTenTK(), model.getMatKhau(), model.getVaiTro());
    }

    @Override
    public void update(TaiKhoan model) {
        String sql = "UPDATE TaiKhoan SET MatKhau = ? ,VaiTro = ? WHERE TenTaiKhoan = ?";
        JdbcHelper.executeUpdate(sql, model.getMatKhau(), model.getVaiTro(), model.getTenTK());
    }

    @Override
    public void delete(String tentk) {
        String sql = "DELETE FROM TaiKhoan WHERE TenTaiKhoan = ?";
        JdbcHelper.executeUpdate(sql, tentk);
    }

    @Override
    public TaiKhoan selectById(String tentk) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenTaiKhoan=?";
        List<TaiKhoan> list = selectBySql(sql, tentk);
        return list.size() > 0 ? list.get(0) : null;
    }
    public void updateTK(String mk, String Email){
        String sql = "update TaiKhoan set MatKhau = ? from TaiKhoan,KhachHang  where (TaiKhoan.TenTaiKhoan = KhachHang.TenTaiKhoan ) and KhachHang.Email like ?";
         JdbcHelper.executeUpdate(sql, mk, Email);
    }
    @Override
    public List<TaiKhoan> selectAll() {
        String sql = "SELECT * FROM TaiKhoan";
        return selectBySql(sql);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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

    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setTenTK(rs.getString("TenTaiKhoan"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setVaiTro(rs.getString("VaiTro"));
        return model;
    }
}

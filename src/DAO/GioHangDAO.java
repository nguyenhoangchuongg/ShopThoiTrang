/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GioHang;
import Helper.JdbcHelper;
import Model.KhachHang;
import Model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phan Tuan Kiet
 */
public class GioHangDAO extends ProDAO<GioHang, String> {

    @Override
    public void insert(GioHang model) {
    }

    @Override
    public void update(GioHang entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

//    public GioHang selectById(int mkh) {
//        String sql = "select * from SanPham sp inner join ChiTietHoaDonXuat cthd on sp.MaSanPham = cthd.MaSanPham\n"
//                + "							inner join HoaDonXuat hdx on hdx.MaHoaDonXuat = cthd.MaHoaDonXuat \n"
//                + "							inner join KhachHang kh on kh.MaKhachHang = hdx.MaKhachHang where kh.MaKhachHang = ? and hdx.TinhTrang like N'Chờ Thanh Toán' ; ";
//        List<GioHang> list = selectBySql(sql, mkh);
//        return list.size() > 0 ? list.get(0) : null;
//    }
//
//    public List<GioHang> select(int mkh) {
//        String sql = "select hdx.MaHoaDonXuat, kh.MaKhachHang, sp.MaSanPham, sp.TenSanPham, cthd.GiaBan, cthd.SoLuong, cthd.TongTien from SanPham sp inner join ChiTietHoaDonXuat cthd on sp.MaSanPham = cthd.MaSanPham\n"
//                + "             						inner join HoaDonXuat hdx on hdx.MaHoaDonXuat = cthd.MaHoaDonXuat \n"
//                + "               						inner join KhachHang kh on kh.MaKhachHang = hdx.MaKhachHang where kh.MaKhachHang = ? and hdx.TinhTrang like N'Chờ Thanh Toán' ;  ";
//        return selectBySql(sql, mkh);
//    }
//
//    @Override
//    public List<GioHang> selectAll() {
//        String sql = "select * from KhachHang kh inner join HoaDonXuat hdx on kh.MaKhachHang = hdx.MaKhachHang\n"
//                + "							inner join ChiTietHoaDonXuat cthdx  on hdx.MaHoaDonXuat = cthdx.MaHoaDonXuat";
//        return selectBySql(sql);
//    }

    public GioHang selectById1(int mkh) {
        String sql = "select * from SanPham sp inner join ChiTietHoaDonXuat cthd on sp.MaSanPham = cthd.MaSanPham\n"
                + "							inner join HoaDonXuat hdx on hdx.MaHoaDonXuat = cthd.MaHoaDonXuat \n"
                + "							inner join KhachHang kh on kh.MaKhachHang = hdx.MaKhachHang where kh.MaKhachHang = ? and hdx.TinhTrang like N'Chờ Thanh Toán' ; ";
        List<GioHang> list = selectBySql(sql, mkh);
        return list.size() > 0 ? list.get(0) : null;
    }
    public List<GioHang> select(int mkh){
        String sql = "select hdx.MaHoaDonXuat, kh.MaKhachHang, sp.MaSanPham, sp.TenSanPham, cthd.GiaBan, cthd.SoLuong, cthd.TongTien from SanPham sp inner join ChiTietHoaDonXuat cthd on sp.MaSanPham = cthd.MaSanPham\n" +
"             						inner join HoaDonXuat hdx on hdx.MaHoaDonXuat = cthd.MaHoaDonXuat \n" +
"               						inner join KhachHang kh on kh.MaKhachHang = hdx.MaKhachHang where kh.MaKhachHang = ? and hdx.TinhTrang like N'Chờ Thanh Toán' ;  ";
          return selectBySql(sql, mkh);
    }
    @Override
    public List<GioHang> selectAll() {
        String sql = "select * from KhachHang kh inner join HoaDonXuat hdx on kh.MaKhachHang = hdx.MaKhachHang\n"
                + "							inner join ChiTietHoaDonXuat cthdx  on hdx.MaHoaDonXuat = cthdx.MaHoaDonXuat";
        return selectBySql(sql);
    }
    
    public void delete12(int hd) {
        String sql = "DELETE from HoaDonXuat WHERE TinhTrang = N'Chờ thanh toán' and MaHoaDonXuat = ?";
        JdbcHelper.executeUpdate(sql, hd);
    }

    @Override
    protected List<GioHang> selectBySql(String sql, Object... args) {
        List<GioHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    GioHang model = readFromResultSet(rs);
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

    private GioHang readFromResultSet(ResultSet rs) throws SQLException {
        GioHang model = new GioHang();
        model.setMahoadon(rs.getInt("MaHoaDonXuat"));
        model.setMakh(rs.getString("MaKhachHang"));
        model.setMaSP(rs.getString("MaSanPham"));
        model.setTenSP(rs.getString("TenSanPham"));
        model.setGiaban(rs.getFloat("GiaBan"));
        model.setSoluong(rs.getInt("SoLuong"));
        model.setTongtien(rs.getFloat("TongTien"));
        return model;
    }

    @Override
    public GioHang selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

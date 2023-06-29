/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author vutai
 */
public class ThongKeDao {
      public List<Object[]> getDoanhThu(int nam, int year) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{CALL thongkedoanhthu (?,?)}";
                rs = JdbcHelper.executeQuery(sql, nam, year);
                while (rs.next()) {
                    Object[] model = {rs.getString("TenSanPham"),
                        rs.getString("MaSanPham"), rs.getInt("SoLuong"), rs.getDouble("TongTien"), rs.getDouble("LoiNhuan")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        return list;
    }
      public Double getTongDoanhThu(int nam, int year) {
          Double tongtien = 0.0;
        try {
            
            ResultSet rs = null;
            try {
                String sql = "{CALL tongdoanhthu (?,?)}";
                rs = JdbcHelper.executeQuery(sql, nam, year);
                while(rs.next()){
                tongtien = rs.getDouble("TongLoiNhuan");
            }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
          return tongtien;

    }
    public List<Object[]> getSoLuongKhach(int nam, int year) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{CALL thongkekhach (?,?)}";
                rs = JdbcHelper.executeQuery(sql, nam, year);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("SoLuongKhach"), rs.getDouble("SoLuongSanPham"), rs.getDouble("DoanhThu")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

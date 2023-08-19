/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.MonHoc;
import Utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class MonHocDAO extends EduSysDAO<MonHoc, Integer> {
    
    String INSERT_SQL = "INSERT INTO MonHoc (MaMH, TenMon, ThoiLuong, MoTa, NgayBatDau) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE KhoaHoc SET  TenMon=?, ThoiLuong=?, MoTa=?, NgayBatDau=? WHERE MaMH=?";
    String DELETE_SQL = "DELETE FROM KhoaHoc WHERE MaMH=?";
    String SELECT_ALL_SQL = "SELECT * FROM MonHoc";
    String SELECT_BY_ID_SQL = "SELECT * FROM MonHoc WHERE MaMH=?";
    @Override
    public void insert(MonHoc entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaMH(),
                entity.getTenMon(),
                entity.getThoiLuong(),
                entity.getMoTa());
    }

    @Override
    public void update(MonHoc entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getTenMon(),
                entity.getThoiLuong(),
                entity.getMoTa(),
                entity.getMaMH());
    }

    @Override
    public void delete(Integer id) {
         JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public MonHoc selectById(Integer id) {
         List<MonHoc> list = this.selectBySQL(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<MonHoc> selectAll() {
        return this.selectBySQL(SELECT_ALL_SQL);
    }

    @Override
    protected List<MonHoc> selectBySQL(String sql, Object... args) {
         List<MonHoc> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                MonHoc entity = new MonHoc();
               entity.setMaMH(rs.getString("MaMH"));
                entity.setTenMon(rs.getString("TenMon"));
                entity.setThoiLuong(rs.getInt("ThoiLuong"));
                entity.setMoTa(rs.getString("MoTa"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
}

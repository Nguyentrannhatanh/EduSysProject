/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author DELL
 */
import java.sql.*;
import java.util.Date;

public class MonHoc {
    private String maMH;
    private String TenMon;
    private int thoiLuong;
    private String moTa;
    
    @Override
    public String toString() {
        return this.TenMon;
    }

    @Override
    public boolean equals(Object obj) {
        MonHoc other = (MonHoc) obj;
        return other.getMaMH().equals(this.getMaMH());
    }

    public MonHoc() {
    }

    public MonHoc(String maMH, String TenMon, int thoiLuong, String moTa) {
        this.maMH = maMH;
        this.TenMon = TenMon;
        this.thoiLuong = thoiLuong;
        this.moTa = moTa;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
  
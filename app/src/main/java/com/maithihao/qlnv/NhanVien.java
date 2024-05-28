package com.maithihao.qlnv;

public class NhanVien {
    private String id, ten, que, gioitinh, chucvu, luong;

    public NhanVien() {
    }

    public NhanVien(String id, String ten, String que, String gioitinh, String chucvu, String luong) {
        this.id = id;
        this.ten = ten;
        this.que = que;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.luong = luong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }
}

package com.example.listviewadu;

public class SinhVien {
    int avatar;
    String tenSinhVien;
    String masvSinhVien;
    public SinhVien() {
    }

    public SinhVien(int avatar, String tenSinhVien, String masvSinhVien) {
        this.avatar = avatar;
        this.tenSinhVien = tenSinhVien;
        this.masvSinhVien = masvSinhVien;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getMasvSinhVien() {
        return masvSinhVien;
    }

    public void setMasvSinhVien(String masvSinhVien) {
        this.masvSinhVien = masvSinhVien;
    }
}

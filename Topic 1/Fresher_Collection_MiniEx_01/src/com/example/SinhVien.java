package com.example;

import java.util.*;

public class SinhVien {
    private final String mssv;
    private final String ten;

    private final Set<Diem> monDaHoc = new HashSet<>();

    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public String getMssv() { return mssv; }

    public String getTen() { return ten; }

    public boolean themDiem(Diem diemMoi) { return this.monDaHoc.add(diemMoi); }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        int total = 0, tongTC = 0, tc;
        for (Diem diem : monDaHoc) {
            tc = diem.getMon().getTcLT() + diem.getMon().getTcTH();
            total += (diem.getDiem() * tc);
            tongTC += tc;
        }
        return total / (double) tongTC;
    }

    //TODO Cau 2
    public String bangDiem() {
        /*
         MSSV : 0203044
         Ten  : Nguyen Van A
         Danh Sach Diem
         STT  Ten Mon             Diem       So Tin Chi
         1    Cau Truc Du Lieu 1  8          3
         2    Cau Truc Du Lieu 2  8          3
         Diem Trung Binh   8.0
        */
        int stt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("MSSV : ").append(this.mssv).append("\n");
        sb.append("Ten  : ").append(this.ten);
        sb.append("\nDanh Sach Diem\n");
        sb.append(String.format("%-10s%-20s%-10s%-10s\n", "STT", "Ten Mon", "Diem", "So Tin Chi"));
        for(Diem diem : monDaHoc) {
            sb.append(String.format("%-10s%-20s%-10s%-10s\n", ++stt,
                    diem.getMon().getTen(),
                    diem.getDiem(),
                    diem.getMon().getTcLT() + diem.getMon().getTcTH())
            );
        }
        sb.append("Diem Trung Binh   ").append(String.format("%.1f", tinhDiemTrungBinh()));

        return sb.toString();
    }

    //TODO Cau 3
    public String xepLoai() {
        double tb = tinhDiemTrungBinh();
        /*
        Quy tac xep loai nhu sau
            DiemTB < 5 -> YEU
            DiemTB >= 5 va DiemTB < 6 -> TB
            DiemTB >= 6 va DiemTB < 7 -> TB-KHA
            DiemTB >= 7 va DiemTB < 8 -> KHA
            DiemTB >= 8 -> GIOI
        */
        if(tb < 5) return "YEU";
        else if(tb >= 5 && tb < 6) return "TB";
        else if(tb >= 6 && tb < 7) return "TB-KHA";
        else if(tb >= 7 && tb < 8) return "KHA";
        else return "GIOI";
    }
}
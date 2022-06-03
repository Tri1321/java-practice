package com.example;

import java.util.*;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private final List<SinhVien> dsLop = new ArrayList<>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public boolean them(SinhVien svMoi) { return dsLop.add(svMoi); }

    //TODO Cau 4
    public String inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        int stt = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Danh Sach Diem Lop : ").append(this.ten).append("\n");
        sb.append("Giao Vien Chu Nhiem : ").append(this.giaoVien).append("\n");
        sb.append(String.format("%-10s%-10s%-20s%-10s%-10s\n", "STT", "MSSV", "Ten", "Diem TB", "Xep Loai"));
        for(SinhVien sv : dsLop) {
            sb.append(String.format("%-10s%-10s%-20s%-10s%-10s\n", ++stt,
                    sv.getMssv(),
                    sv.getTen(),
                    String.format("%.1f", sv.tinhDiemTrungBinh()),
                    sv.xepLoai()
            ));
        }
        return sb.toString();
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
        return dsLop.stream().sorted((o1, o2) -> {
            double diem1 = o1.tinhDiemTrungBinh(), diem2 = o2.tinhDiemTrungBinh();
            if (diem1 > diem2) return -1;
            else if (diem1 < diem2) return 1;
            return 0;
        }).limit(10).toList();
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        return dsLop.stream().filter(e -> e.xepLoai().equals("YEU")).toList();
    }
}
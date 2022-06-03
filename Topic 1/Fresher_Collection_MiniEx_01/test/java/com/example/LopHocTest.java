package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {

    @Test
    void them() {
    }

    @Test
    void inDiem() {
        MonHoc mh1 = new MonHoc("Toan", 2, 1);
        MonHoc mh2 = new MonHoc("Van", 3, 1);
        MonHoc mh3 = new MonHoc("Anh", 2, 1);

        SinhVien sv1 = new SinhVien("0123456", "Hoang Dinh Tri");
        sv1.themDiem(new Diem(mh1, 7));
        sv1.themDiem(new Diem(mh2, 8));
        sv1.themDiem(new Diem(mh3, 9));

        SinhVien sv2 = new SinhVien("0333333", "Phan Minh Thai");
        sv2.themDiem(new Diem(mh1, 5));
        sv2.themDiem(new Diem(mh2, 4));
        sv2.themDiem(new Diem(mh3, 5));

        LopHoc lh1 = new LopHoc("Lop 1", "abc");
        lh1.them(sv1);
        lh1.them(sv2);

        System.out.println("\n" + lh1.inDiem());
    }

    @Test
    void top10() {
        MonHoc mh1 = new MonHoc("Toan", 2, 1);
        MonHoc mh2 = new MonHoc("Van", 3, 1);
        MonHoc mh3 = new MonHoc("Anh", 2, 1);

        //DTB: 8.0
        SinhVien sv1 = new SinhVien("0123456", "Hoang Dinh Tri");
        sv1.themDiem(new Diem(mh1, 7));
        sv1.themDiem(new Diem(mh2, 8));
        sv1.themDiem(new Diem(mh3, 9));

        //DTB: 4.6
        SinhVien sv2 = new SinhVien("0333333", "Phan Minh Thai");
        sv2.themDiem(new Diem(mh1, 5));
        sv2.themDiem(new Diem(mh2, 4));
        sv2.themDiem(new Diem(mh3, 5));

        //DTB: 7.6
        SinhVien sv3 = new SinhVien("0444444", "Nguyen Van A");
        sv3.themDiem(new Diem(mh1, 8));
        sv3.themDiem(new Diem(mh2, 7));
        sv3.themDiem(new Diem(mh3, 8));

        //DTB: 7.9
        SinhVien sv4 = new SinhVien("0555555", "Nguyen Van B");
        sv4.themDiem(new Diem(mh1, 8));
        sv4.themDiem(new Diem(mh2, 7));
        sv4.themDiem(new Diem(mh3, 9));

        LopHoc lh1 = new LopHoc("Lop 1", "abc");
        lh1.them(sv1);
        lh1.them(sv2);
        lh1.them(sv3);
        lh1.them(sv4);

        System.out.println("\nTop 10:");
        lh1.top10().forEach(sv -> System.out.println(sv.toString()));
    }

    @Test
    void sinhVienYeu() {
        MonHoc mh1 = new MonHoc("Toan", 2, 1);
        MonHoc mh2 = new MonHoc("Van", 3, 1);
        MonHoc mh3 = new MonHoc("Anh", 2, 1);

        SinhVien sv1 = new SinhVien("0123456", "Hoang Dinh Tri");
        sv1.themDiem(new Diem(mh1, 7));
        sv1.themDiem(new Diem(mh2, 8));
        sv1.themDiem(new Diem(mh3, 9));

        SinhVien sv2 = new SinhVien("0333333", "Phan Minh Thai");
        sv2.themDiem(new Diem(mh1, 5));
        sv2.themDiem(new Diem(mh2, 4));
        sv2.themDiem(new Diem(mh3, 5));

        LopHoc lh1 = new LopHoc("Lop 1", "abc");
        lh1.them(sv1);
        lh1.them(sv2);

        System.out.println("Sinh Vien Xep Loai YEU:");
        lh1.sinhVienYeu().forEach(sv -> System.out.println(sv.toString()));
    }
}
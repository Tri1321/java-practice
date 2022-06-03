package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void getMssv() {
    }

    @Test
    void getTen() {
    }

    @Test
    void themDiem() {
    }

    @Test
    void tinhDiemTrungBinh() {
        MonHoc mh1 = new MonHoc("Toan", 2, 1);
        MonHoc mh2 = new MonHoc("Van", 3, 1);
        MonHoc mh3 = new MonHoc("Anh", 2, 1);

        SinhVien sv1 = new SinhVien("0123456", "Hoang Dinh Tri");
        sv1.themDiem(new Diem(mh1, 7));
        sv1.themDiem(new Diem(mh2, 8));
        sv1.themDiem(new Diem(mh3, 9));

        assertEquals(8.0, sv1.tinhDiemTrungBinh());
    }

    @Test
    void bangDiem() {
        MonHoc mh1 = new MonHoc("Toan", 2, 1);
        MonHoc mh2 = new MonHoc("Van", 3, 1);
        MonHoc mh3 = new MonHoc("Anh", 2, 1);

        SinhVien sv1 = new SinhVien("0123456", "Hoang Dinh Tri");
        sv1.themDiem(new Diem(mh1, 7));
        sv1.themDiem(new Diem(mh2, 8));
        sv1.themDiem(new Diem(mh3, 9));

        System.out.println(sv1.bangDiem());
    }

    @Test
    void xepLoai() {
        MonHoc mh1 = new MonHoc("Toan", 2, 1);
        MonHoc mh2 = new MonHoc("Van", 3, 1);
        MonHoc mh3 = new MonHoc("Anh", 2, 1);

        SinhVien sv1 = new SinhVien("0123456", "Hoang Dinh Tri");
        sv1.themDiem(new Diem(mh1, 7));
        sv1.themDiem(new Diem(mh2, 8));
        sv1.themDiem(new Diem(mh3, 9));

        String xepLoai = sv1.xepLoai();
        assertEquals("GIOI", xepLoai);

        System.out.println(xepLoai);
    }
}
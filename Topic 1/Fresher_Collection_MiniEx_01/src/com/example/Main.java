package com.example;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(sv1.bangDiem());
        System.out.println("Xep loai: " + sv1.xepLoai());

        System.out.println("\n" + lh1.inDiem());

        System.out.println("Sinh Vien Xep Loai YEU:");
        lh1.sinhVienYeu().forEach(sv -> System.out.println(sv.toString()));

        System.out.println("\nTop 10:");
        lh1.top10().forEach(sv -> System.out.println(sv.toString()));
    }
}
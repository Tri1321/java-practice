package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {
    @Test
    void compareTo() {
    }

    @Test
    void getMon() {
    }

    @Test
    void setMon() {
    }

    @Test
    void getDiem() {
    }

    @Test
    void setDiem() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testClone() {
        MonHoc mh1 = new MonHoc("Toan", 1, 1);
        Diem d1 = new Diem(mh1, 5);
        Diem d2 = d1.clone();
        assertEquals(d1, d2);
    }
}
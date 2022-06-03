package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {
    @Test
    void testEquals() {
        MonHoc mh1 = new MonHoc("abc", 1, 1);
        MonHoc mh2 = new MonHoc("abc", 1, 1);
        assertEquals(mh1, mh2);
    }

    @Test
    void getTen() {
        MonHoc mh1 = new MonHoc("abc", 1, 1);
        assertEquals("abc", mh1.getTen());
    }

    @Test
    void setTen() {
        MonHoc mh1 = new MonHoc("abc", 1, 1);
        mh1.setTen("def");
        assertEquals("def", mh1.getTen());
    }

    @Test
    void getTcLT() {
        MonHoc mh1 = new MonHoc("abc", 1, 2);
        assertEquals(1, mh1.getTcLT());
    }

    @Test
    void setTcLT() {
        MonHoc mh1 = new MonHoc("abc", 1, 2);
        mh1.setTcLT(3);
        assertEquals(3, mh1.getTcLT());
    }

    @Test
    void getTcTH() {
        MonHoc mh1 = new MonHoc("abc", 1, 2);
        assertEquals(2, mh1.getTcTH());
    }

    @Test
    void setTcTH() {
        MonHoc mh1 = new MonHoc("abc", 1, 2);
        mh1.setTcTH(3);
        assertEquals(3, mh1.getTcTH());
    }
}
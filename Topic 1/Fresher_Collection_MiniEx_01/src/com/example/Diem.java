package com.example;

import java.io.Serializable;
import java.util.Objects;

public class Diem implements Comparable<Diem>, Serializable {
    private MonHoc mon;
    private int diem;

    public MonHoc getMon() { return mon; }

    public int getDiem() { return diem; }

    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    @Override
    public int compareTo(Diem o) {
        if(this.diem < o.getDiem()) return -1;
        else if(this.diem > o.getDiem()) return 1;
        return 0;
    }

    @Override
    public Diem clone() {
        return new Diem(this.mon, this.diem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diem diem1 = (Diem) o;
        return diem == diem1.diem && Objects.equals(mon, diem1.mon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mon, diem);
    }
}
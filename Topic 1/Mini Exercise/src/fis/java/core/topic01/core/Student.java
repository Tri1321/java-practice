package fis.java.core.topic01.core;

import java.util.Date;

public class Student {
    private int code;
    private String name;
    private Date birthDate;

    public Student(int code, String name, Date date) {
        this.code = code;
        this.name = name;
        this.birthDate = date;
    }

    public int getCode() { return code; }

    public String getName() { return name; }

    public Date getDate() { return birthDate; }

    public void setCode(int code) { this.code = code; }

    public void setName(String name) { this.name = name; }

    public void setDate(Date date) { this.birthDate = date; }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", date=" + birthDate +
                '}';
    }

    public int compareTo(Student s) {
        return 0;
    }
}

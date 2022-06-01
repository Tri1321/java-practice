package fis.java.core.topic01.dao;

import fis.java.core.topic01.core.Student;

public class StudentDAO {
    public Student[] students;
    public int count;
    ISortStrategy sortStrategy;

    public void addStudent(Student s) {
        students[count] = s;
        count++;
    }

    public StudentDAO(Student[] students) {
        this.students = students;
        this.count = 0;
        this.sortStrategy = new SelectionSortStrategy();
    }

    public ISortStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void removeStudent(int code) {}
}
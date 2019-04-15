package com.greatyun.vo;

import com.greatyun.pojo.Student;

import java.util.List;

public class PageVo {
    private int hasmore;
    private List<Student> studentList;

    public PageVo(int hasmore, List<Student> studentList) {
        this.hasmore = hasmore;
        this.studentList = studentList;
    }

    public PageVo() {
    }

    public int getHasmore() {
        return hasmore;
    }

    public void setHasmore(int hasmore) {
        this.hasmore = hasmore;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

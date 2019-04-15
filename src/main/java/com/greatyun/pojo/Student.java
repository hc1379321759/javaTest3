package com.greatyun.pojo;

public class Student{
    private Integer studentId;

    private String name;

    private Integer age;

    private String avatarUrl;

    private Integer credit;

    public Student(Integer studentId, String name, Integer age, String avatarUrl, Integer credit) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.avatarUrl = avatarUrl;
        this.credit = credit;
    }

    public Student() {
        super();
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
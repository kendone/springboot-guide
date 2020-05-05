package com.kendo.xml;

import java.util.List;

/*One*/
@SuppressWarnings("unused")
class OneToManyTeacher {
    private Integer id;

    private String name;

    private String email;

    private String phone;

    private OneToOneAddress address;

    private List<OneToManyCourse> courses;//一个老师可以教授一门或多门课程

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public OneToOneAddress getAddress() {
        return address;
    }

    public void setAddress(OneToOneAddress address) {
        this.address = address;
    }

    public List<OneToManyCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<OneToManyCourse> courses) {
        this.courses = courses;
    }
}
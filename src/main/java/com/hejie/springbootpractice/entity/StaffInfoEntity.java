package com.hejie.springbootpractice.entity;

/**
 * @Program: springbootpractice
 * @Description: 实体类(职工)
 * @Author: hejie
 * @Create: 2020-05-18 16:44
 */
public class StaffInfoEntity {

    private String staff_no;
    private String name;
    private String ac_no;
    private String ac_name;
    private String ac_br_name;

    public String getStaff_no() {
        return staff_no;
    }

    public void setStaff_no(String staff_no) {
        this.staff_no = staff_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAc_no() {
        return ac_no;
    }

    public void setAc_no(String ac_no) {
        this.ac_no = ac_no;
    }

    public String getAc_name() {
        return ac_name;
    }

    public void setAc_name(String ac_name) {
        this.ac_name = ac_name;
    }

    public String getAc_br_name() {
        return ac_br_name;
    }

    public void setAc_br_name(String ac_br_name) {
        this.ac_br_name = ac_br_name;
    }

    @Override
    public String toString() {
        return "StaffInfoEntity{" +
                "staff_no='" + staff_no + '\'' +
                ", name='" + name + '\'' +
                ", ac_no='" + ac_no + '\'' +
                ", ac_name='" + ac_name + '\'' +
                ", ac_br_name='" + ac_br_name + '\'' +
                '}';
    }
}

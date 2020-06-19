package com.hejie.springbootpractice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Program: springbootpractice
 * @Description: 实体类(机构)
 * @Author: hejie
 * @Create: 2020-05-18 17:04
 */
@Entity
@Table(name = "com_department")
public class ComDepartmentEntity {

    @Id
    @Column(name = "cur_dep_no")
    private String cur_dep_no;

    @Column(name = "dep_name")
    private String dep_name;

    @Column(name = "cur_up_br_no")
    private String cur_up_br_no;

    public String getCur_dep_no() {
        return cur_dep_no;
    }

    public void setCur_dep_no(String cur_dep_no) {
        this.cur_dep_no = cur_dep_no;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getCur_up_br_no() {
        return cur_up_br_no;
    }

    public void setCur_up_br_no(String cur_up_br_no) {
        this.cur_up_br_no = cur_up_br_no;
    }

    @Override
    public String toString() {
        return "ComDepartmentEntity{" +
                "cur_dep_no='" + cur_dep_no + '\'' +
                ", dep_name='" + dep_name + '\'' +
                ", cur_up_br_no='" + cur_up_br_no + '\'' +
                '}';
    }
}

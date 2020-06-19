package com.hejie.springbootpractice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Program: springbootpractice
 * @Description:
 * @Author: hejie
 * @Create: 2020-05-25 16:00
 */
@Entity
@Table(name = "stockhld_info")
public class StockhldInfoEntity {

    @Id
    @Column(name = "client_no")
    private String client_no;

    @Column(name = "client_name")
    private String client_name;

    @Column(name = "certifno")
    private String certifno;

    public String getClient_no() {
        return client_no;
    }

    public void setClient_no(String client_no) {
        this.client_no = client_no;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getCertifno() {
        return certifno;
    }

    public void setCertifno(String certifno) {
        this.certifno = certifno;
    }

    @Override
    public String toString() {
        return "StockhldInfoEntity{" +
                "client_no='" + client_no + '\'' +
                ", client_name='" + client_name + '\'' +
                ", certifno='" + certifno + '\'' +
                '}';
    }
}

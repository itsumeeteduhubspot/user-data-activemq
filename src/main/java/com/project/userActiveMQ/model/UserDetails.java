package com.project.userActiveMQ.model;

import java.io.Serializable;

public class UserDetails implements Serializable {
    private static final long serialVersionUID=1L;

    private Integer pid;
    private String name;
    private String address;
    private Long contact;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User Details are: {" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                '}';
    }
}

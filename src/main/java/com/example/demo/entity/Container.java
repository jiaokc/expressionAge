package com.example.demo.entity;

import javax.persistence.*;

/**
 * add by jiaokc
 * 20190715
 * 快递柜映射实体类
 */
@Entity
@Table(name="CONTAINER")
public class Container {

    @Id //设置主键
    private  Integer id; //序号
    private  String con_name; //快读柜名称
    private  String con_status; //快递柜状态 0 无货 1 有货 2 异常
    private  String con_info; //具体信息
    private  String con_auth_code; //验证码
    private  String con_error_message; //错误信息

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCon_name() {
        return con_name;
    }

    public void setCon_name(String con_name) {
        this.con_name = con_name;
    }

    public String getCon_status() {
        return con_status;
    }

    public void setCon_status(String con_status) {
        this.con_status = con_status;
    }

    public String getCon_info() {
        return con_info;
    }

    public void setCon_info(String con_info) {
        this.con_info = con_info;
    }

    public String getCon_auth_code() {
        return con_auth_code;
    }

    public void setCon_auth_code(String con_auth_code) {
        this.con_auth_code = con_auth_code;
    }

    public String getCon_error_message() {
        return con_error_message;
    }

    public void setCon_error_message(String con_error_message) {
        this.con_error_message = con_error_message;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id=" + id +
                ", con_name='" + con_name + '\'' +
                ", con_status='" + con_status + '\'' +
                ", con_info='" + con_info + '\'' +
                ", con_auth_code='" + con_auth_code + '\'' +
                ", con_error_message='" + con_error_message + '\'' +
                '}';
    }
}

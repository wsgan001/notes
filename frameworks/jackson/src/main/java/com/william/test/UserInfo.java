package com.william.test;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zdpwilliam on 17-3-2.
 */
public class UserInfo implements Serializable {

    private Integer id;       //用户（老师，学生，游客）的ID
    private Integer uid;      //关联的老师或学生的用户ID，游客uid为id
    private String username;  //老师或学生或游客名称，默认为游客
    private Integer role;     //用户角色：0-游客，1-老师，2-学生
    private String contact;   //用户联系方式
    private Date createdAt;  //创建时间
    private Date updatedAt;  //关联的老师或学生的用户ID，游客无uid

    public UserInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", contact='" + contact + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

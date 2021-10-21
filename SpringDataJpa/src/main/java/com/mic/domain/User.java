package com.mic.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="user_id")
    private long userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age")
    private Integer age;

    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    //中间表名
    @JoinTable(name = "sys_user_role",
        //当前对象在中间表的外键
        joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")},
        //对主对象在中间表的外键
        inverseJoinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

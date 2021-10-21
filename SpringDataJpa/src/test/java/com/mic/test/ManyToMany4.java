package com.mic.test;

import com.mic.dao.RoleDao;
import com.mic.dao.UserDao;
import com.mic.domain.Role;
import com.mic.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToMany4 {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    //多对多放弃维护权，被动的一方放弃
    @Test
    @Transactional
    @Rollback(value = false)
    public void save(){
        User user = new User();
        user.setUserName("lishi");

        Role role = new Role();
        role.setRoleName("PM");
    //多对多放弃维护权，被动的一方(Role)放弃
        user.getRoles().add(role);
//        role.getUsers().add(user);
        userDao.save(user);
        roleDao.save(role);
    }

    //多对多级联操作(保存用户的同时保存用户的关联角色)
    @Test
    @Transactional
    @Rollback(value = false)
    public void saveCascade(){
        User user = new User();
        user.setUserName("lishi");

        Role role = new Role();
        role.setRoleName("PM");
        user.getRoles().add(role);
        userDao.save(user);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void removeCascade(){
        User user = userDao.findOne(1l);
        userDao.delete(user);
    }
}

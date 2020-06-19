package com.hejie.springbootpractice.test;

import com.hejie.springbootpractice.SpringbootpracticeApplication;
import com.hejie.springbootpractice.dao.ComDepartmentDao;
import com.hejie.springbootpractice.entity.ComDepartmentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Program: springbootpractice
 * @Description: 测试类(基于junit)
 * @Author: hejie
 * @Create: 2020-05-20 17:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootpracticeApplication.class)
public class TestJdbc {
    @Autowired
    ComDepartmentDao comDepartmentDao;

    @Test
    public void test() {
        List<ComDepartmentEntity> list = comDepartmentDao.findAll();
        for (ComDepartmentEntity comDepartmentEntity : list) {
            System.out.println(comDepartmentEntity.toString());
        }
    }
}

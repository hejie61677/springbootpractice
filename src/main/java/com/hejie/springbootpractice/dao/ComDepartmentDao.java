package com.hejie.springbootpractice.dao;

import com.hejie.springbootpractice.entity.ComDepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Program: springbootpractice
 * @Description: 数据访问相关(机构相关),基于jpa
 * @Author: hejie
 * @Create: 2020-05-14 08:48
 */
public interface ComDepartmentDao extends JpaRepository<ComDepartmentEntity, String> {
}

package com.hejie.springbootpractice.dao;

import com.hejie.springbootpractice.entity.StockhldInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Program: springbootpractice
 * @Description: 数据访问相关(股东相关),基于jpa
 * @Author: hejie
 * @Create: 2020-05-25 08:48
 */
public interface StockhldInfoDao extends JpaRepository<StockhldInfoEntity, String> {
}

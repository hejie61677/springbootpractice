package com.hejie.springbootpractice.mapper;

import com.hejie.springbootpractice.entity.StaffInfoEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Program: springbootpractice
 * @Description: mapper接口(职工相关)
 * @Author: hejie
 * @Create: 2020-05-18 16:49
 */
@Mapper
@Repository
public interface StaffInfoMapper {

    //注解方式，也可以使用配置文件方式。
    @Select(value = "select staff_no, name, ac_no, ac_name, ac_br_name from staff_info order by staff_no")
    List<StaffInfoEntity> selAll();

    @Select(value = "select staff_no, name, ac_no, ac_name, ac_br_name from staff_info where rownum <= #{size} order by staff_no ")
    List<StaffInfoEntity> selBySize(int start, int size);

    @Insert(value = "insert into staff_info (staff_no, name, ac_no, ac_name, ac_br_name) values (#{staff_no}, #{name}, #{ac_no}, #{ac_name}, #{ac_br_name})")
    int insStaff(StaffInfoEntity staffInfoEntity);

    @Delete(value = "delete from staff_info where staff_no = #{staff_no}")
    int delStaff(String staff_no);

    @Update(value = "update staff_info set name = #{name}, ac_no = #{ac_no}, ac_name = #{ac_name}, ac_br_name = #{ac_br_name} where staff_no = #{staff_no}")
    int updStaff(StaffInfoEntity staffInfoEntity);

    @Select(value = "Select staff_no, name, ac_no, ac_name, ac_br_name from staff_info where staff_no = #{staff_no}")
    StaffInfoEntity selStaff(String staff_no);

}

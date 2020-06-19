package com.hejie.springbootpractice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejie.springbootpractice.entity.StaffInfoEntity;
import com.hejie.springbootpractice.mapper.StaffInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Program: springbootpractice
 * @Description: 控制器(职工相关)
 * @Author: hejie
 * @Create: 2020-05-18 16:54
 */
@Controller
public class StaffInfoController {

    @Autowired
    StaffInfoMapper staffInfoMapper;

    @RequestMapping(value = "/staffList")
    public String selAll(Model model) {
        List<StaffInfoEntity> staffInfoEntities = staffInfoMapper.selAll();
        model.addAttribute("staffs", staffInfoEntities);
        return "staffList";
    }

    @RequestMapping(value = "/staffInsert")
    public String insStaff(StaffInfoEntity staffInfoEntity, Model model) {
        int result = staffInfoMapper.insStaff(staffInfoEntity);
        model.addAttribute("insResult", result);
        return "redirect:staffListByPage";
    }

    @RequestMapping(value = "/staffDelete")
    public String delStaff(String staff_no, Model model) {
        int result = staffInfoMapper.delStaff(staff_no);
        model.addAttribute("delResult", result);
        return "redirect:staffListByPage";
    }

    @RequestMapping(value = "/staffUpdate")
    public String updStaff(StaffInfoEntity staffInfoEntity, Model model) {
        int result = staffInfoMapper.updStaff(staffInfoEntity);
        model.addAttribute("updResult", result);
        return "redirect:staffListByPage";
    }

    @RequestMapping(value = "staffEdit")
    public String selStaff(String staff_no, Model model) {
        StaffInfoEntity staffInfoEntity = staffInfoMapper.selStaff(staff_no);
        model.addAttribute("staff", staffInfoEntity);
        return "staffEdit";
    }

    @RequestMapping(value = "/staffListByPage")
    public String selByPage(Model model, @RequestParam(value = "start", defaultValue = "1") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(start, size);
        List<StaffInfoEntity> staffInfoEntities = staffInfoMapper.selAll();
        PageInfo<StaffInfoEntity> page = new PageInfo<>(staffInfoEntities);
        model.addAttribute("page", page);
        return "staffListByPage";
    }

    @GetMapping(value = "/helloGet1/{staff_no}")
    @ResponseBody
    public StaffInfoEntity get1(@PathVariable(value = "staff_no") String staff_no) {
        return staffInfoMapper.selStaff(staff_no);
    }

    @GetMapping(value = "/helloGet2/{start}/{size}")
    @ResponseBody
    public List<StaffInfoEntity> get2(@PathVariable(value = "start") int start, @PathVariable(value = "size") int size) {
        return staffInfoMapper.selBySize(start, size);
    }
}

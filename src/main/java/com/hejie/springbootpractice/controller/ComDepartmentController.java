package com.hejie.springbootpractice.controller;

import com.hejie.springbootpractice.dao.ComDepartmentDao;
import com.hejie.springbootpractice.entity.ComDepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Program: springbootpractice
 * @Description: 控制器(机构相关)
 * @Author: hejie
 * @Create: 2020-05-14 08:57
 */
@Controller
public class ComDepartmentController {

    @Autowired
    ComDepartmentDao comDepartmentDao;

    @RequestMapping(value = "/depList")
    public String selAllList(Model model) {
        List<ComDepartmentEntity> comDepartmentEntities = comDepartmentDao.findAll();
        model.addAttribute("deps", comDepartmentEntities);
        return "depList";
    }

    @RequestMapping(value = "/depAdd")
    public String insDep(ComDepartmentEntity comDepartmentEntity) {
        comDepartmentDao.save(comDepartmentEntity);
        return "redirect:depList";
    }

    @RequestMapping(value = "/depListByPage")
    public String selList(Model model, @RequestParam(value = "start", defaultValue = "0")int start, @RequestParam(value = "size", defaultValue = "10")int size) {
        start = start < 0 ? 0 : start;
        Sort sort = Sort.by(Sort.Direction.DESC, "cur_dep_no");
        Pageable pageable = PageRequest.of(start, size, sort);
        Page<ComDepartmentEntity> page = comDepartmentDao.findAll(pageable);
        model.addAttribute("page", page);
        return "depListByPage";
    }

}

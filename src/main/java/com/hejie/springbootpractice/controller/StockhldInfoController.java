package com.hejie.springbootpractice.controller;

import com.hejie.springbootpractice.entity.StockhldInfoEntity;
import com.hejie.springbootpractice.service.StockhldInfoService;
import com.hejie.springbootpractice.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Program: springbootpractice
 * @Description: 控制器(股东相关)
 * @Author: hejie
 * @Create: 2020-05-25 17:16
 */
@Controller
public class StockhldInfoController {

    @Autowired
    StockhldInfoService stockhldInfoService;

    @RequestMapping(value = "/stockListByPage")
    public String selList(Model model, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "10") int size) {
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC, "certifno");
        Pageable pageable = new PageRequest(start, size, sort);
        Page4Navigator<StockhldInfoEntity> page = stockhldInfoService.selList(pageable);
        model.addAttribute("page", page);
        return "stockList";
    }
}

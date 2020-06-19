package com.hejie.springbootpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Program: springbootpractice
 * @Description: 控制器(hello)
 * @Author: hejie
 * @Create: 2020-05-12 17:11
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello springboot";
    }

    @RequestMapping("/hello1")
    public String hello1(Model model) {
        model.addAttribute("time", DateFormat.getDateInstance().format(new Date()));
        model.addAttribute("hello", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~滴滴~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return "hello";
    }

    @RequestMapping("/hello2")
    public ModelAndView hello2() {

        if (true) {
            throw new RuntimeException("滴滴滴,报错了");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("time", DateFormat.getDateInstance().format(new Date()));
        modelAndView.addObject("hello", "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~滴滴~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

}

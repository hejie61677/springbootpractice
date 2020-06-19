package com.hejie.springbootpractice.test;

import com.hejie.springbootpractice.util.NetUtil;

/**
 * @Program: springbootpractice
 * @Description:
 * @Author: hejie
 * @Create: 2020-06-11 16:40
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(cn.hutool.core.util.NetUtil.isUsableLocalPort(10000));
        NetUtil.isLoaclPortUsing(10000);
    }
}

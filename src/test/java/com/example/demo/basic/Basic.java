package com.example.demo.basic;

import java.util.TreeMap;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/8
 */
public class Basic {
    public static void main(String[] args) {
        System.out.println(1 << 30);
        System.out.println((1 << 30) >>>1);
        System.out.println(0.0f);

        final TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put("1",null);
    }
}

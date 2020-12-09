package edu.cdu.ppj.chapter3;

import java.util.Scanner;

public class arr_match {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] str1 = {"张三", "李四", "王二", "Tom", "Jack"};
        System.out.println("请输入要查询的名字：");
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        match(str1, s1);

    }

    public static void match(String[] str, String s1) {
        int flag = 0;
        for (int i = 0; i < str.length; i++) {
            if (s1.equals(str[i])) {
                System.out.println("该名字在数组中位置为：" + (i + 1));
                flag = 1;
            }
        }
        if (0 == flag) {
            System.out.println(-1);
        }
    }
}

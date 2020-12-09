package edu.cdu.ppj.chapter3;

import java.io.IOException;
import java.util.Scanner;

public class Pyramid {

    public static void main(String[] args) throws IOException {
        System.out.println("请输入金字塔层数：");
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("请输入字符：");
        int col = input.nextInt();
        String a = input2.nextLine();
        for (int i = 1; i <= col; i++) {

            for (int k = 0; k < col - i; k++) {
                System.out.print(" ");
            }
            for (int m = 0; m < 2 * i - 1; m++) {
                System.out.print(a);
            }
            System.out.println();
        }
    }

}

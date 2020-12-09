package edu.cdu.ppj.chapter3;

public class ArrayUtils {
    public static void main(String[] args) {
        int array[] = {12, 23, 456, 222, 768, 93245};
        int sum = 0;
        int average = 0;
        int max, min;
        max = min = array[0];
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
        }
        System.out.println("和=" + sum);
        System.out.println("平均值=" + sum / array.length);
        System.out.println("最大数 = " + max);
        System.out.println("最小数 = " + min);
    }
}


package com.pyq.study.algorithm;

/**
 * Created by pangyueqiang on 17/8/24.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class DyadicArraySearch {
    public static boolean find(int target, int[][] array) {
        if (array == null | array.length == 0)
            return false;
        int row = array.length;
        int col = array[0].length;
        int cursor = 0;
        while (col > 0 & cursor < row) {
            if (array[cursor][col - 1] > target) {
                col--;
            } else if (array[cursor][col - 1] < target) {
                cursor++;
            } else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        System.out.println(find(17,array));
    }
}

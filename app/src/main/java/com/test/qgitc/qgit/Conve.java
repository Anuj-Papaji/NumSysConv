package com.test.qgitc.qgit;

/**
 * Created by sumk on 28/10/17.
 */

public class Conve {

    int[] qint = new int[32];
    int queryType = 0;
    int resType = 0, tagLen = 0, tagCount = 0; //51713

    /**
     * solving an array for compact number system
     */
    private int compact(int base) {         //51713
        int sum = 0;
        int i = 0;
        for (; i < tagLen; i++) {
            sum = sum + (int) (qint[i] * Math.pow(base, (tagLen - 1 - i)));
        }
        return sum;
    }

    /**
     * solving  for expanded number system
     */
    private String expand(int d, int base) {    //51713
        int[] x = getConv(d, base);
        String ces = "";
        int i = tagCount;
        for (; i >= 0; i--) {
            ces = ces + x[i];
        }
        return ces;
    }

    /**
     * converts number to array of other number system with different bases
     */
    private int[] getConv(int num, int base) {          //51713
        int i = 0;
        tagCount = 0;
        int[] res = new int[32];
        while (num >= base) {
            res[i] = (num % base);
            num /= base;
            i++;
            tagCount++;
        }
        res[i] = num;
        return res;
    }
}

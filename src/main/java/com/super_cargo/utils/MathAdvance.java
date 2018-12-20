package com.super_cargo.utils;

public class MathAdvance {


    public static double FIRST_POSITIVE_INTEGER(double d){
        double summ;
        if (d % 2 != 0){
            int x = (int) d;
            summ  = (int) (d + (d - x));
        }else{
            summ = (int) d;
        }
        return summ;
    }
}


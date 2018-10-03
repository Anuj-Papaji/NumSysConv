package com.test.qgitc.qgit;

/**
 * Created by sumk on 28/10/17.
 */

public class Refr {

    char sym ='*' ;
    int val ;

    public Refr(){}

    public Refr (char sym, int val){
        set_value(sym, val) ;
    }

    public char get_sym(){
        return sym;
    }

    public int get_val(){
        return val ;
    }

    public void set_value(char sym, int val){
        this.sym = sym;
        this.val = val;
    }
}

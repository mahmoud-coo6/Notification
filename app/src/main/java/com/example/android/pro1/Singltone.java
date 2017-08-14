package com.example.android.pro1;

/**
 * Created by Mahmoud Abdo on 8/13/2017.
 */

public class Singltone {

    private static Singltone anInstance=null;

    private Singltone(){

    }

    public  static Singltone getInctance(){
        if (anInstance == null){
            return anInstance=new Singltone();
        }
        return anInstance;
    }
}

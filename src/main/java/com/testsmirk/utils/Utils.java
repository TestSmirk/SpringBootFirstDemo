package com.testsmirk.utils;

import java.util.Random;

/**
 * Created by testsmirk on 2017/4/25.
 */
public class Utils {
    public static int randomRound( int min,int max ){
        Random random = new Random();
        return random.nextInt(max)%(max-min+1) + min;
    }

    public static String getName(String[] names) {

        return names[randomRound(0,names.length)];
    }
}

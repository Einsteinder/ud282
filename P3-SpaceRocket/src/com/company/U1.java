package com.company;

import java.util.Random;

/**
 * Created by klepht on 3/11/18.
 */
public class U1 extends Rocket{


    U1(){
        value = 1;
        weight = 10000;
        maxWeight = 18000;
    }
    public boolean land(){
        Random rand = new Random();
        int n = rand.nextInt(100 * weight / maxWeight);
        if(n < 1 * weight / maxWeight){
            return false;
        }else{
            return true;
        }


    }
    public boolean launch(){
        Random rand = new Random();
        int n = rand.nextInt(100 * weight / maxWeight);
        if(n < 5 * weight / maxWeight){
            return false;
        }else{
            return true;
        }

    }


}

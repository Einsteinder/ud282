package com.company;

import java.util.Random;

/**
 * Created by klepht on 3/11/18.
 */
public class U2 extends Rocket{



    U2(){
        weight = 18000;
        value = 1.2;
        maxWeight = 29000;
    }
    public boolean land(){
        Random rand = new Random();
        int n = rand.nextInt(100 * weight / maxWeight);
        if(n < 8 * weight / maxWeight){
            return false;
        }else{
            return true;
        }


    }
    public boolean launch(){
        Random rand = new Random();
        int n = rand.nextInt(100 * weight / maxWeight);
        if(n < 4 * weight / maxWeight){
            return false;
        }else{
            return true;
        }

    }


}
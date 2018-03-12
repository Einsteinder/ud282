package com.company;

/**
 * Created by klepht on 3/11/18.
 */
public class Rocket implements SpaceShip {
    int weight;
    int maxWeight;
    double value;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(weight + item.weight > maxWeight){
            return false;
        }else{
        return true;
        }
    }

    @Override
    public void carry(Item item) {
        weight += item.weight;

    }
}


package com.company;

/**
 * Created by klepht on 3/11/18.
 */
public interface SpaceShip {
    boolean launch ();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}

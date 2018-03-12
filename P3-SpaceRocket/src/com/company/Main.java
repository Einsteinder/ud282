package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        String phase1 = "phase-1.txt";
        String phase2 = "phase-2.txt";

        Simulation newSimu = new Simulation();
        final ArrayList<Item> phase1Item = newSimu.loadItems(phase1);
        final ArrayList<Item> phase2Item = newSimu.loadItems(phase2);

        final ArrayList<Rocket> U1WithP1 = newSimu.loadU1(phase1Item);
        final ArrayList<Rocket> U1WithP2 = newSimu.loadU1(phase2Item);
        final ArrayList<Rocket> U2WithP1 = newSimu.loadU2(phase1Item);
        final ArrayList<Rocket> U2WithP2 = newSimu.loadU2(phase2Item);

        double cost1 = newSimu.runSimulation(U1WithP1);
        cost1 += newSimu.runSimulation(U1WithP2);
        double cost2 = newSimu.runSimulation(U2WithP1);
        cost2 += newSimu.runSimulation(U2WithP2);
        System.out.println("SpaceShip U1 costs: "+cost1);
        System.out.println("SpaceShip U2 costs: "+cost2);





        // write your code here
    }
}

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by klepht on 3/11/18.
 */
public class Simulation {
    public ArrayList<Item> loadItems(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner fileScanner = new Scanner(file);

        List<String> nameList = new ArrayList<>();
        ArrayList<Item> itemList = new ArrayList<>();


        while(fileScanner.hasNextLine()){
            nameList.add(fileScanner.nextLine());
        }
        for(int i = 0;i < nameList.size();i++){
            Item newItem = new Item();
            newItem.name = nameList.get(i).split("=")[0];
            newItem.weight = Integer.parseInt(nameList.get(i).split("=")[1]);
            itemList.add(newItem);

        }
        return itemList;

    }
    public ArrayList<Rocket> loadU1(ArrayList<Item> phase) throws FileNotFoundException {
        ArrayList<U1> U1List = new ArrayList<>();
        int totalWeight = 0;
        for(Item temp:phase){
            totalWeight += temp.weight;

        }
        U1 temp = new U1();
        for(int i =0; i < totalWeight/temp.maxWeight+2;i++){
            U1List.add(new U1());
        }
        int j = 0;

        while(phase.size()>0){
            if (U1List.get(j).canCarry(phase.get(0))){
                U1List.get(j).carry(phase.get(0));
            }
            else {
                j += 1;
            }
            phase.remove(0);
        }
        ArrayList<Rocket>  U1ReturnList =  new ArrayList<>();
        for(U1 item : U1List){
            U1ReturnList.add(item);
        }
        return U1ReturnList;

    }
    public ArrayList<Rocket> loadU2(ArrayList<Item> phase) throws FileNotFoundException {
        ArrayList<U2> U2List = new ArrayList<>();
        int totalWeight = 0;
        for(Item temp:phase){
            totalWeight += temp.weight;

        }
        U2 temp = new U2();

        for(int i =0; i < totalWeight/temp.maxWeight+2;i++){
            U2List.add(new U2());
        }
        int j = 0;

        while(phase.size()>0){
            if (U2List.get(j).canCarry(phase.get(0))){
                U2List.get(j).carry(phase.get(0));
            }
            else {
                j += 1;
            }
            phase.remove(0);
        }
        ArrayList<Rocket>  U1ReturnList =  new ArrayList<>();
        for(U2 item : U2List){
            U1ReturnList.add(item);
        }
        return U1ReturnList;

    }


    public double runSimulation(ArrayList<Rocket> U){
        double cost = 0;
        for(Rocket item :U){

            boolean launchStatus = item.launch();
            boolean landStatus = item.land();
            cost = item.value;
            while(!launchStatus|!landStatus){
                launchStatus = item.launch();
                landStatus = item.land();
                cost += item.value;

            }


        }
        return cost;
    }
}

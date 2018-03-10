package com.company;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by klepht on 3/10/18.
 */
public class Game {
    private String currentName = "";
    private String movieName = "";
    private int tryTimes = 0;
    Game() throws FileNotFoundException {
        movieName = initName();

        for(int i = 0; i < movieName.length();i++){
            currentName += "_";
        }

    }

    public String getInputString(){
        Scanner inputScanner = new Scanner(System.in);
        String inputString = inputScanner.nextLine();
        return inputString;

    }
    public List<Integer> checkContain(String inputString){
        int index = movieName.indexOf(inputString);
        List<Integer> indexList = new ArrayList<>();


        while (index >= 0) {
            indexList.add(index);
            index = movieName.indexOf(inputString, index + 1);

        }
        return indexList;
    }

    public String getMovieName(){
        return movieName;

    }
    public void updateCurrentName(String x, Integer index){
        String newName = currentName.substring(0,index) + x + currentName.substring(index + 1);
        currentName = newName;

    }
    public boolean go(){
        boolean win = false;
        while(!win && tryTimes<10){
            System.out.println(currentName);
            String inputString = getInputString();
            if(inputString.length()>1){
                System.out.println("You can only input one character once!");
                continue;
            }


            List<Integer> indexList = checkContain(inputString);
            if(indexList.size()==0){
                System.out.println("Wrong! You have "+(9 - tryTimes)+" times");
                tryTimes += 1;
            }
            for(int i = 0; i < indexList.size();i++){
                updateCurrentName(inputString,indexList.get(i));
            }
            win = checkWin();

        }
        return win;
    }
    public boolean checkWin(){
        if(movieName.equals(currentName)){
            return true;
        }
        else{
            return false;
        }
    }
    private String initName() throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);

        List<String> nameList = new ArrayList<>();

        while(fileScanner.hasNextLine()){
            nameList.add(fileScanner.nextLine());
        }
        int lengthOfName = nameList.size();

        Random rand = new Random();

        int n = rand.nextInt(lengthOfName);


        return nameList.get(n);


    }


}

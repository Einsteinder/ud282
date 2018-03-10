package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Game newGame = new Game();
        System.out.println(newGame.getMovieName());
        if(newGame.go()){
            System.out.println("You Win!");
            System.out.println("The movie is: "+newGame.getMovieName());

        }else{
            System.out.println("You Lose!");
        }
	// write your code here
    }
}

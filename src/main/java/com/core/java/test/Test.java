package com.core.java.test;

public class Test {


}

class Person{

    private Person(){
    }

    private static Person person;
    public synchronized static Person getInstance(){
        if(person == null){
            person = new Person();
            return person;
        }
        return person;
    }


    public int getNoOfWays(int n){
        int i = 0;
          /* // 0,1,2,3,4
            // 0-1, 1,2, 2-3, 3-4
            //0-2, 2-4,
                    0-1, 1-3, 3-4
                            0-1, 1-2,2-4
                                    0-2, 2-3, 3-4*/
        while (i<n) {
            int j = i;
            i++;
            i = j + i;
        }

        return -1;
    }

}


//Consider a single-player game on a board consisting of a single row of N squares (indexed 0 to N-1),
//where the player's goal is to move a token from square 0 to square N-1 by flipping 2 coins (instead of rolling a dice). The rules of the game are:
//
//If all coins land on "Heads" the player moves two positions ahead, i.e. from position i to i+2, if possible.
//If any of the coins does not land on "Heads" the player moves a single position ahead (from i to i+1). In other words, if any (or all) of the coins land on "Tails", the player moves a single position ahead.
//If the player is at one position away from the last square (i.e. position N-2), and all coins land on "Heads", the player must flip the coins again until there is a valid move possible. Only valid moves are counted in determining the number of ways.
//The game always starts at position 0.
//Write a function that can determine the number of ways to reach Nth position (numbering of positions starting with 0).


//Given a 2D screen, location of a pixel in the screen and a color,
//replace color of the given pixel and all adjacent same colored pixels with the given color.
/*      0 0 0 0
        0 1 1 0
        1 1 1 0
        2 3 3 1*/

        /*0 0 0 0
        0 1 1 0
        2 1 1 0
        2 2 3 1*/


class Matrix{

    public void pixelCheck(int[][] a, int b){
        for (int i = 0; i<a.length; i++){
            for (int j = i; j<a[j].length; j++){
                if(a[i][j] == b){
                   if(j != 0){
                       int k = j;
                       a[i][--k] = b;
                   }
                   if(j != a[j].length){
                       a[i][++j] = b;
                   }
                }
            }
        }
    }
}
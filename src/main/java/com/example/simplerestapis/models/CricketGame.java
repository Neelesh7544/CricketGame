package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
@Component
public class CricketGame {

    static  int temp = Integer.MAX_VALUE;
    int teamAscore = 0;
    int teamBscore = 0;
    public Match setup(){
        Match m = new Match();
        return m;
    }
    public int randomGenerator(){
        Random rand = new Random();
        return rand.nextInt(8);
    }
    public int start( HashMap<Integer,Integer> teamMap){
        int score = 0;
        for (int i=0;i<300;i++){
            if (teamMap.containsKey(7) && teamMap.get(7) == 10){
                break;
            }

            int temp1 = randomGenerator();
            if (temp1 != 7){
                if (teamMap.containsKey(temp1)){
                    int temp2 = teamMap.get(temp1);
                    teamMap.put(temp1, temp2 + 1);
                    score+=temp1;
                }
                else{
                    teamMap.put(temp1,1);
                    score+=temp1;
                }
            }
            else {
                if (teamMap.containsKey(temp1)) {
                    int temp2 = teamMap.get(temp1);
                    teamMap.put(temp1, temp2 + 1);
                } else {
                    teamMap.put(temp1, 1);
                }
            }
            if(score>temp)break;
        }
        System.out.println(Arrays.asList(teamMap));
        temp = score;
        return score;
    }


}
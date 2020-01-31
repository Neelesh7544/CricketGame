package com.example.simplerestapis.util;

public class PlayerRatingUtil {
    public static double[] getdistribution(int rating){
        if (rating == 3){
            return new double[]{0.07,0.1,0.25,0.3,0.1,0.05,0.1,0.03};
        }
        else if (rating == 2){
            return new double[]{0.1,0.3,0.3,0.05,0.05,0.05,0.05,0.1};
        }
        else{
            return new double[]{0.3,0.18,0.18,0.01,0.01,0.01,0.01,0.30};
        }
    }
}

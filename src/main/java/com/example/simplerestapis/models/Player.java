package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

@Component
public class Player  {
    String name;
    int id;
    int matchesPlayed;
    int runsScored;
    int numberOfBallsPlayed;
    int numberOfBoundaries;
    float numOfOvers;
    int runsGiven;
    int wicketsTaken;
    int maidenOvers;
    public String getName() {
        return this.name;
    }
    public void setName(String abc) {
        this.name = abc;
    }
    public void setRunsScored(int a){
        this.runsScored = a;
    }
    public int getRunsScored(){
        return this.runsScored;
    }
    public void setNumberOfBoundaries(int a){
        this.numberOfBoundaries = a;
    }
    public int getNumberOfBoundaries(){
        return this.numberOfBoundaries;
    }
    public int getNumberOfBallsPlayed(){
        return this.numberOfBallsPlayed;
    }
    public void setNumberOfBallsPlayed(int a){
        this.numberOfBallsPlayed = a;
    }
    public void setWicketsTaken(int a){
        this.wicketsTaken = a;
    }
    public int getWicketsTaken(){
        return  this.wicketsTaken;
    }
    public void setNumOfOvers(float a){
        this.numOfOvers = a;
    }
    public float getNumOfOvers(){
        return this.numOfOvers;
    }
    public void setRunsGiven(int a){
        this.runsGiven = a;
    }
    public int getRunsGiven(){
        return this.runsGiven;
    }
    public void setMaidenOvers(int a){
        this.maidenOvers = a;
    }
    public int getMaidenOvers(){
        return this.maidenOvers;
    }

    public void setMatchesPlayed(int a) {
        this.matchesPlayed = a;
    }
    public int getMatchesPlayed(){
        return this.matchesPlayed;
    }
}

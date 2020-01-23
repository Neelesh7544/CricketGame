package com.example.simplerestapis.models;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class Result {
    private String winner;
    private long teamAscore;
    private long teamBscore;
    private String result;

    public String getWinner() {
        return winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String r) {
        this.result = r;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public long getteamAscore() {
        return teamAscore;
    }

    public void setteamAscore(long score) {
        this.teamAscore = score;
    }

    public long getteamBscore() {
        return teamBscore;
    }

    public void setteamBscore(long score) {
        this.teamBscore = score;
    }
}

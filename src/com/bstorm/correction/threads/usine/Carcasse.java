package com.bstorm.correction.threads.usine;

public class Carcasse {

    private int scoreSecurite;

    public Carcasse(int scoreSecurite) {
        this.scoreSecurite = scoreSecurite;
    }

    public int getScoreSecurite() {
        return scoreSecurite;
    }

    public void setScoreSecurite(int scoreSecurite) {
        this.scoreSecurite = scoreSecurite;
    }

    @Override
    public String toString() {
        return "Carcasse{" +
                "scoreSecurite=" + scoreSecurite +
                '}';
    }
}

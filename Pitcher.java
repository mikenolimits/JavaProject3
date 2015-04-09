package com.company;

/**
 * Created by michaelkantor on 4/9/15.
 */
public class Pitcher extends Player {


    float era;

    public Pitcher(String battingAvg,String number, String lastName, String firstName,String era){
        super(battingAvg,number,lastName,firstName,'P');
    }


    public float getEra() {
        return era;
    }

    public void setEra(float era) {
        this.era = era;
    }
}

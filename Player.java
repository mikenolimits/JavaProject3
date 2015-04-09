package com.company;

/**
 * Created by michaelkantor on 3/16/15.
 */

/** This Class Is Pretty straightforward. The Constructor accepts
 *  4 arguments used to fully prepare a Player. Int and Float are created
 *  By Using the appropriate wrapper classes Integer & Float
 * **/
public class Player {

    /*Batting Avg For The Player */
    public float   battingAvg;
    /*Jersey # For The Player */
    public int     number;
    /*Last Name For The Player */
    public String  lastName;
    /*First Name For The Player */
    public String  firstName;

    public char    playerType;


    public Player(String battingAvg,String number, String lastName, String firstName,char playerType){

        float avg = Float.parseFloat(battingAvg);

        if(avg < 0 || avg > 100){
            throw new IllegalArgumentException("Batting Avg Is Out Of Range...");
        }

        setPlayerType(playerType);
        setBattingAvg(avg);
        setNumber(Integer.parseInt(number));
        setLastName(lastName);
        setFirstName(firstName);
    }


    public Player(char playerType,String battingAvg,String number, String lastName, String firstName){

        setPlayerType(playerType);
        setBattingAvg(Float.parseFloat(battingAvg));
        setNumber(Integer.valueOf(number));
        setLastName(lastName);
        setFirstName(firstName);
    }

    /**
     * This Method simply implements compareTo by using the lastName of both objects,
     * self & the param otherPlayer.
     * @param otherPlayer Player
     * @return int
     */
    public int compareTo(Player otherPlayer){

        return lastName.compareTo(otherPlayer.lastName);
    }


    public float getBattingAvg() {
        return battingAvg;
    }

    public void setBattingAvg(float battingAvg) {
        this.battingAvg = battingAvg;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getPlayerType() {
        return playerType;
    }

    public void setPlayerType(char playerType) {
        this.playerType = playerType;
    }

}

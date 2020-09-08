package com.mohammedchowdhury.bullsandcows.dto;

/**
 *
 * @author mohammedchowdhury
 */
public class RoundVM {

    private String guess;
    private String result;
    private String timeOfGuess;

    public RoundVM(Round round) {
        this.guess = round.getAnswer();
        this.result = round.getResult();
        this.timeOfGuess = round.getTimeOfGuess().getDayOfMonth() + " " + round.getTimeOfGuess().getMonth() + "," + round.getTimeOfGuess().getYear() + " Time :" + round.getTimeOfGuess().getHour() + ":" + round.getTimeOfGuess().getMinute() + ":" + round.getTimeOfGuess().getSecond();
    }

    public String getGuess() {
        return guess;
    }

    public String getResult() {
        return result;
    }

    public String getTimeOfGuess() {
        return timeOfGuess;
    }
}

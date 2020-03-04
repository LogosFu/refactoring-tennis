package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;

    public TennisGame1() {
        //do nothing when construction in this role
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore) {
            return getScoreWhenTwoPlayerEqual();
        } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return getScoreWhenWinFourFirst();
        } else {
            return getScoreDefaultRule();
        }
    }

    private String getScoreDefaultRule() {
        int tempScore;
        StringBuilder score = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerOneScore;
            else {
                score.append("-");
                tempScore = playerTwoScore;
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }

    private String getScoreWhenWinFourFirst() {
        StringBuilder score = new StringBuilder();
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score.toString();
    }

    private String getScoreWhenTwoPlayerEqual() {
        StringBuilder score = new StringBuilder();
        switch (playerOneScore) {
            case 0:
                score = new StringBuilder("Love-All");
                break;
            case 1:
                score = new StringBuilder("Fifteen-All");
                break;
            case 2:
                score = new StringBuilder("Thirty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;
        }
        return score.toString();
    }
}
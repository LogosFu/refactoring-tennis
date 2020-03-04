package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int M_SCORE1 = 0;
    private int M_SCORE2 = 0;

    public TennisGame1() {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            M_SCORE1 += 1;
        else
            M_SCORE2 += 1;
    }

    public String getScore() {
        if (M_SCORE1 == M_SCORE2) {
            return getScoreWhenTwoPlayerEqual();
        } else if (M_SCORE1 >= 4 || M_SCORE2 >= 4) {
            return getScoreWhenWinFourFrist();
        } else {
            return getScoreDefaultRule();
        }
    }

    private String getScoreDefaultRule() {
        int tempScore;
        StringBuilder score = new StringBuilder();
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = M_SCORE1;
            else {
                score.append("-");
                tempScore = M_SCORE2;
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

    private String getScoreWhenWinFourFrist() {
        StringBuilder score = new StringBuilder();
        int minusResult = M_SCORE1 - M_SCORE2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score.toString();
    }

    private String getScoreWhenTwoPlayerEqual() {
        StringBuilder score = new StringBuilder();
        switch (M_SCORE1) {
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
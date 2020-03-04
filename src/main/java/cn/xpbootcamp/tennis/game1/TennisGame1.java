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
        return getScoreOutPut(playerOneScore)
            + "-"
            + getScoreOutPut(playerTwoScore);
    }

    private String getScoreOutPut(int tempScore) {
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String getScoreWhenWinFourFirst() {
        int minusResult = playerOneScore - playerTwoScore;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getScoreWhenTwoPlayerEqual() {
        switch (playerOneScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {

    private int playOnePoint = 0;
    private int playTwoPoint = 0;

    public TennisGame2() {
    }

    public String getScore() {
        String P1res = "";
        String P2res = "";
        String score = "";
        if (isPointSame()) {
            score = getScoreWhenPointSame(score);
        }
        final int playOnePoint = this.playOnePoint;
        final int playTwoPoint = this.playTwoPoint;
        if (isPlayOneGreateThanTwo()) {

            if (playTwoPoint == 0) {
                P1res = getScoreByPointWhenOtherIsZero(playOnePoint);
                P2res = "Love";
                score = P1res + "-" + P2res;
            }
            if (playOnePoint < 4) {
                if (playOnePoint == 2) {
                    P1res = "Thirty";
                }
                if (playOnePoint == 3) {
                    P1res = "Forty";
                }
                if (playTwoPoint == 1) {
                    P2res = "Fifteen";
                }
                if (playTwoPoint == 2) {
                    P2res = "Thirty";
                }
                score = P1res + "-" + P2res;
            }
            if (playTwoPoint >= 3) {
                score = "Advantage player1";
            }
            if (playOnePoint >= 4 && playTwoPoint >= 0 && (playOnePoint - playTwoPoint) >= 2) {
                score = "Win for player1";
            }
        }
        if (playTwoPoint > 0 && playOnePoint == 0) {
            P2res = getScoreByPointWhenOtherIsZero(playTwoPoint);
            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (playTwoPoint > playOnePoint && playTwoPoint < 4) {
            if (playTwoPoint == 2) {
                P2res = "Thirty";
            }
            if (playTwoPoint == 3) {
                P2res = "Forty";
            }
            if (playOnePoint == 1) {
                P1res = "Fifteen";
            }
            if (playOnePoint == 2) {
                P1res = "Thirty";
            }
            score = P1res + "-" + P2res;
        }

        if (playTwoPoint > playOnePoint && playOnePoint >= 3) {
            score = "Advantage player2";
        }

        if (playTwoPoint >= 4 && playOnePoint >= 0 && (playTwoPoint - playOnePoint) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String getScoreByPointWhenOtherIsZero(int playOnePoint) {
        if (playOnePoint == 1) {
            return "Fifteen";
        }
        if (playOnePoint == 2) {
            return "Thirty";
        }
        if (playOnePoint == 3) {
            return "Forty";
        }
        return null;
    }

    private boolean isPlayOneGreateThanTwo() {
        return playOnePoint > playTwoPoint;
    }

    private String getScoreWhenPointSame(String score) {
        if (playOnePoint < 4) {
            if (playOnePoint == 0) {
                score = "Love";
            }
            if (playOnePoint == 1) {
                score = "Fifteen";
            }
            if (playOnePoint == 2) {
                score = "Thirty";
            }
            score += "-All";
        }
        if (playOnePoint >= 3) {
            score = "Deuce";
        }
        return score;
    }

    private boolean isPointSame() {
        return playOnePoint == playTwoPoint;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            playOnePoint++;
        } else {
            playTwoPoint++;
        }
    }
}
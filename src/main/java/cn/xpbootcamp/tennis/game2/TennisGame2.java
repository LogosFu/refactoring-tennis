package cn.xpbootcamp.tennis.game2;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame2 implements TennisGame {

  private int playOnePoint = 0;
  private int playTwoPoint = 0;
  private String P1res = "";
  private String P2res = "";

  public TennisGame2() {
  }

  public String getScore() {

    String score = "";
    if (isPointSame()) {
      return getScoreWhenPointSame(score);
    }
    if (isPlayOneGreateThanTwo()) {

      return getScoreForPlayOneLeading(score, this.playOnePoint, this.playTwoPoint);
    }

    return getScoreForPlayerTwoLeading(score, this.playOnePoint, this.playTwoPoint);
  }

  private String getScoreForPlayerTwoLeading(String score, int playOnePoint, int playTwoPoint) {
    if (playTwoPoint > 0 && playOnePoint == 0) {
      P2res = getScoreByPointWhenOtherIsZero(playTwoPoint);
      P1res = "Love";
      score = P1res + "-" + P2res;
    }

    if (playTwoPoint > playOnePoint && playTwoPoint < 4) {
      P2res = getScoreForLeadingWhenLessThanFour(P2res, playTwoPoint);
      P1res = getScoreForFallBehindWhenLessThanFour(P1res, playOnePoint);
      score = P1res + "-" + P2res;
    }

    if (playTwoPoint > playOnePoint && playOnePoint >= 3) {
      score = "Advantage player2";
    }

    if (playTwoPoint >= 4 && playOnePoint >= 0 && isGapMoreThanTwo(playTwoPoint,
        playOnePoint)) {
      score = "Win for player2";
    }
    return score;
  }

  private String getScoreForPlayOneLeading(String score, int playOnePoint, int playTwoPoint) {
    if (playTwoPoint == 0) {
      P1res = getScoreByPointWhenOtherIsZero(playOnePoint);
      P2res = "Love";
      score = P1res + "-" + P2res;
    }
    if (playOnePoint < 4) {
      P1res = getScoreForLeadingWhenLessThanFour(P1res, playOnePoint);
      P2res = getScoreForFallBehindWhenLessThanFour(P2res, playTwoPoint);
      score = P1res + "-" + P2res;
    }
    if (playTwoPoint >= 3) {
      score = "Advantage player1";
    }
    if (playOnePoint >= 4 && playTwoPoint >= 0 && isGapMoreThanTwo(playOnePoint,
        playTwoPoint)) {
      score = "Win for player1";
    }
    return score;
  }

  private boolean isGapMoreThanTwo(int playOnePoint, int playTwoPoint) {
    return (playOnePoint - playTwoPoint) >= 2;
  }

  private String getScoreForFallBehindWhenLessThanFour(String p2res, int playTwoPoint) {
    if (playTwoPoint == 1) {
      p2res = "Fifteen";
    }
    if (playTwoPoint == 2) {
      p2res = "Thirty";
    }
    return p2res;
  }

  private String getScoreForLeadingWhenLessThanFour(String p1res, int playOnePoint) {
    if (playOnePoint == 2) {
      p1res = "Thirty";
    }
    if (playOnePoint == 3) {
      p1res = "Forty";
    }
    return p1res;
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
      score = getScoreForFallBehindWhenLessThanFour(score, playOnePoint);
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
package com.zz.entities.view;

import com.zz.entities.Score;

public class ScoreView extends Score {
    /**
     * 排名
     */
    private String Ranking;

    public String getRanking() {
        return Ranking;
    }

    public void setRanking(String ranking) {
        Ranking = ranking;
    }
}

package com.londonappbrewery.destini;

/**
 * Created by Jan Kotas on 23.02.2018.
 */

public class Story {
    private int mStory;
    private int mAnswer1;
    private int mAnswer2;

    public Story(int story, int answer1, int answer2){
        mStory = story;
        mAnswer1 = answer1;
        mAnswer2 = answer2;
    }

    public int getStory() {
        return mStory;
    }

    public int getAnswer1() {
        return mAnswer1;
    }

    public int getAnswer2() {
        return mAnswer2;
    }
}

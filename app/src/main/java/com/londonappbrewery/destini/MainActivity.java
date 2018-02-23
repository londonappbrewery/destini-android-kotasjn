package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    int mStory;
    int mAnswer1;
    int mAnswer2;

    private Story[] mStoryBank = new Story[]{
            new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    private End[] mEndBank = new End[] {
            new End(R.string.T4_End),
            new End(R.string.T5_End),
            new End(R.string.T6_End)
    };

    int mStoryNumber;

    TextView mStoryTextView;
    Button mButtonAnswer1;
    Button mButtonAnswer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonAnswer1 = (Button) findViewById(R.id.buttonTop);
        mButtonAnswer2 = (Button) findViewById(R.id.buttonBottom);

        mStoryNumber = 0;

        mStory = mStoryBank[mStoryNumber].getStory();
        mAnswer1 = mStoryBank[mStoryNumber].getAnswer1();
        mAnswer2 = mStoryBank[mStoryNumber].getAnswer2();

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryTextView.setText(mStory);
        mButtonAnswer1.setText(mAnswer1);
        mButtonAnswer2.setText(mAnswer2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextStory(mStoryNumber, 1);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNextStory(mStoryNumber, 2);
            }
        });

    }

    private void setNextStory(int storyNumber, int answer) {
        if (storyNumber == 0) {
            if (answer == 1)
                updateStory(2);
            else
                updateStory(1);
        } else if (storyNumber == 1) {
            if (answer == 1)
                updateStory(2);
            else
                setEnd(0);
        } else if (storyNumber == 2) {
            if (answer == 1)
                setEnd(2);
            else
                setEnd(1);
        }
    }

    private void updateStory(int storyNumber) {
        mStoryNumber = storyNumber;
        mStoryTextView.setText(mStoryBank[storyNumber].getStory());
        mButtonAnswer1.setText(mStoryBank[storyNumber].getAnswer1());
        mButtonAnswer2.setText(mStoryBank[storyNumber].getAnswer2());
    }

    private void setEnd(int endNumber){
        mStoryTextView.setText(mEndBank[endNumber].getText());
        mButtonAnswer1.setVisibility(View.GONE);
        mButtonAnswer2.setVisibility(View.GONE);
    }
}

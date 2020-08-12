package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int foulsTeamA = 0;
    int foulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {

        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays fouls for Team A.
     */
    public void displayFoulForTeamB(int fouls) {
        TextView foulView = (TextView) findViewById(R.id.text_foul_B_team);
        foulView.setText(getApplicationContext().getString(R.string.fouls) + " " + String.valueOf(fouls));
    }

    /**
     * Displays fouls for Team B.
     */
    public void displayFoulForTeamA(int fouls) {
        TextView foulView = (TextView) findViewById(R.id.text_foul_A_team);
        foulView.setText(getApplicationContext().getString(R.string.fouls) + " " + String.valueOf(fouls));
    }

    /**
     * Resets scores and fouls.
     */
    public void resetAll() {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.A1:
                scoreTeamA = scoreTeamA + 1;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.B1:
                scoreTeamB = scoreTeamB + 1;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.A2:
                scoreTeamA = scoreTeamA + 2;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.B2:
                scoreTeamB = scoreTeamB + 2;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.A3:
                scoreTeamA = scoreTeamA + 3;
                displayForTeamA(scoreTeamA);
                break;
            case R.id.B3:
                scoreTeamB = scoreTeamB + 3;
                displayForTeamB(scoreTeamB);
                break;
            case R.id.button_foul_A_team:
                foulsTeamA++;
                displayFoulForTeamA(foulsTeamA);
                break;
            case R.id.button_foul_B_team:
                foulsTeamB++;
                displayFoulForTeamB(foulsTeamB);
                break;
            case R.id.reset:
                scoreTeamA = 0;
                scoreTeamB = 0;
                foulsTeamA = 0;
                foulsTeamB = 0;
                displayForTeamA(scoreTeamA);
                displayForTeamB(scoreTeamB);
                displayFoulForTeamA(foulsTeamA);
                displayFoulForTeamB(foulsTeamB);
                break;
        }
    }

}

package com.example.android.courtcounter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//This app maintains the score of two teams.It also keeps track of the fouls comitted.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int scoreA;
    int scoreB;
    int foulA;
    int foulB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set onClickListeners for the buttons
        Button add3pointsTeamA = (Button) findViewById(R.id.points_3_A);
        add3pointsTeamA.setOnClickListener(this);
        Button add2pointsTeamA = (Button) findViewById(R.id.points_2_A);
        add2pointsTeamA.setOnClickListener(this);
        Button add1pointsTeamA = (Button) findViewById(R.id.points_1_A);
        add1pointsTeamA.setOnClickListener(this);
        Button add3pointsTeamB = (Button) findViewById(R.id.points_3_B);
        add3pointsTeamB.setOnClickListener(this);
        Button add2pointsTeamB = (Button) findViewById(R.id.points_2_B);
        add2pointsTeamB.setOnClickListener(this);
        Button add1pointsTeamB = (Button) findViewById(R.id.points_1_B);
        add1pointsTeamB.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.points_1_A: {
                addPoints('A', 1);
                break;
            }
            case R.id.points_2_A: {
                addPoints('A', 2);
                break;
            }
            case R.id.points_3_A: {
                addPoints('A', 3);
                break;
            }
            case R.id.points_1_B: {
                addPoints('B', 1);
                break;
            }
            case R.id.points_2_B: {
                addPoints('B', 2);
                break;
            }
            case R.id.points_3_B: {
                addPoints('B', 3);
                break;
            }
        }
    }
    public void displayScore(char s, int score) {
        switch (s) {
            case 'A':
                TextView scoreAView = (TextView) findViewById(R.id.team_a_score);
                scoreAView.setText(String.valueOf(score));
                break;
            case 'B':
                TextView scoreBView = (TextView) findViewById(R.id.team_b_score);
                scoreBView.setText(String.valueOf(score));
                break;
        }
    }
    public void addPoints(char team, int points) {
        switch (team) {
            case 'A':
                scoreA = scoreA + points;
                displayScore(team, scoreA);
                break;
            case 'B':
                scoreB = scoreB + points;
                displayScore(team, scoreB);
                break;
        }
    }
    public void resetScores(View view) {
        scoreA=0;
        scoreB=0;
        foulA = 0;
        foulB = 0;
        displayScore('A', scoreA);
        displayScore('B', scoreB);
        displayFoulTeamA(foulA);
        displayFoulTeamB(foulB);
    }
    public void displayFoulTeamA(int foul) {
        TextView foulView = (TextView) findViewById(R.id.team_a_fouls);
        foulView.setText(String.valueOf(foul));
    }
    public void displayFoulTeamB(int foul) {
        TextView textView = (TextView) findViewById(R.id.team_b_fouls);
        textView.setText(String.valueOf(foul));
    }
    public void addFoulsTeamA(View v) {
        foulA = foulA + 1;
        displayFoulTeamA(foulA);
    }
    public void addFoulsTeamB(View v) {
        foulB = foulB + 1;
        displayFoulTeamB(foulB);
    }
}

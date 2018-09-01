package com.example.android.boybandquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Total score
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called to check answers and highlight the right ones.
     * You get 2 points for the right answer to the question with multiple choice (1, 4), but only if you check all of them correctly.
     * You get 1 point for the right answer to the question with single right answer (2, 3, 5, 6).
     * You get 4 points for the right answer to the question with no variants offered (7).
     * The right answers are highlighted in green
     */
    public void totalScore(View view) {

        // Get color to highlight the right answers
        int colorRightAnswer = getResources().getColor(R.color.colorRightAnswer);

        // Check the answer to the question 1; highlight the right answers
        CheckBox checkBoxNoMercy = findViewById(R.id.cb_no_mercy);
        boolean noMercy = checkBoxNoMercy.isChecked();
        checkBoxNoMercy.setBackgroundColor(colorRightAnswer);

        CheckBox checkBoxTLC = findViewById(R.id.cb_tlc);
        boolean tlc = checkBoxTLC.isChecked();

        CheckBox checkBoxHanson = findViewById(R.id.cb_hanson);
        boolean hanson = checkBoxHanson.isChecked();
        checkBoxHanson.setBackgroundColor(colorRightAnswer);

        CheckBox checkBoxPentatonix = findViewById(R.id.cb_pentatonix);
        boolean pentatonix = checkBoxPentatonix.isChecked();

        CheckBox checkBoxOneDirection = findViewById(R.id.cb_one_direction);
        boolean oneDirection = checkBoxOneDirection.isChecked();
        checkBoxOneDirection.setBackgroundColor(colorRightAnswer);

        CheckBox checkBoxA1 = findViewById(R.id.cb_a1);
        boolean a1 = checkBoxA1.isChecked();
        checkBoxA1.setBackgroundColor(colorRightAnswer);

        if (noMercy && hanson && oneDirection && a1 && !tlc && !pentatonix) {
            score += 2;
        }

        // Check the answer to the question 2; highlight the right answer
        RadioButton radioButtonBackstreetBoys = findViewById(R.id.rb_backstreet_boys);
        boolean backstreetBoys = radioButtonBackstreetBoys.isChecked();
        if (backstreetBoys) {
            score ++;
        }
        radioButtonBackstreetBoys.setBackgroundColor(colorRightAnswer);

        // Check the answer to the question 3; highlight the right answer
        RadioButton radioButtonNsync = findViewById(R.id.rb_nsync);
        boolean nSync = radioButtonNsync.isChecked();
        if (nSync) {
            score ++;
        }
        radioButtonNsync.setBackgroundColor(colorRightAnswer);

        // Check the answer to the question 4; highlight the right answers
        CheckBox checkBoxGeorgeMichael = findViewById(R.id.cb_george_michael);
        boolean georgeMichael = checkBoxGeorgeMichael.isChecked();
        checkBoxGeorgeMichael.setBackgroundColor(colorRightAnswer);

        CheckBox checkBoxJustinBieber = findViewById(R.id.cb_justin_bieber);
        boolean justinBieber = checkBoxJustinBieber.isChecked();

        CheckBox checkBoxMichaelJackson = findViewById(R.id.cb_michael_jackson);
        boolean michaelJackson = checkBoxMichaelJackson.isChecked();
        checkBoxMichaelJackson.setBackgroundColor(colorRightAnswer);

        CheckBox checkBoxRobbieWilliams = findViewById(R.id.cb_robbie_williams);
        boolean robbieWilliams = checkBoxRobbieWilliams.isChecked();
        checkBoxRobbieWilliams.setBackgroundColor(colorRightAnswer);

        CheckBox checkBoxEnriqueIglesias = findViewById(R.id.cb_enrique_iglesias);
        boolean enriqueIglesias = checkBoxEnriqueIglesias.isChecked();

        CheckBox checkBoxJayZ = findViewById(R.id.cb_jay_z);
        boolean jayZ = checkBoxJayZ.isChecked();

        if (georgeMichael && michaelJackson && robbieWilliams && !justinBieber && !enriqueIglesias && !jayZ) {
            score += 2;
        }

        // Check the answer to the question 5; highlight the right answer
        RadioButton radioButtonMilliVanilli = findViewById(R.id.rb_milli_vanilli);
        boolean milliVanilli = radioButtonMilliVanilli.isChecked();
        if (milliVanilli) {
            score ++;
        }
        radioButtonMilliVanilli.setBackgroundColor(colorRightAnswer);

        // Check the answer to the question 6; highlight the right answer
        RadioButton radioButtonTakeThat = findViewById(R.id.rb_take_that);
        boolean takeThat = radioButtonTakeThat.isChecked();
        if (takeThat) {
            score ++;
        }
        radioButtonTakeThat.setBackgroundColor(colorRightAnswer);

        // Check the answer to the question 7; highlight and show the right answer
        EditText answer7 = findViewById(R.id.question_7);
        String passedAnswer7 = answer7.getText().toString();
        if (!TextUtils.isEmpty(passedAnswer7)) {
            if (Integer.parseInt(passedAnswer7) == 104) {
                score += 4;
            }
        }
        answer7.setBackgroundColor(colorRightAnswer);
        answer7.setText(R.string.answer_7);

        // Pass the data to show the results
        displayScore(score);
    }

    /**
     * This method compares the score to the max possible and shows it in a toast
     *
     * @param totalScore the player's score
     */
    public void displayScore(int totalScore) {

        // Compare the player's results to the max
        String result;
        if (totalScore >= 8) {
            result = getString(R.string.high_score);
        } else if (totalScore >= 5) {
            result = getString(R.string.medium_score);
        } else {
            result = getString(R.string.low_score);
        }

        // Create a message and show a toast
        Toast.makeText(this, totalScore + result, Toast.LENGTH_LONG).show();
    }
}


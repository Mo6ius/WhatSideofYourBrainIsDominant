package com.example.android.whatsideofyourbrainisdominant;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app asks demographic questions and helps users determine which side of their brains is more active.
 */
public class MainActivity extends AppCompatActivity {

    String gender = "";
    String genderResult = "";
    String race = "";
    String age = "";
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Determines race/ethnic group.
     */
    public void checkBox(View view) {

        CheckBox nativeAM = findViewById(R.id.nativeAM);
        CheckBox asian = findViewById(R.id.asian);
        CheckBox black = findViewById(R.id.black);
        CheckBox caucasian = findViewById(R.id.caucasian);
        CheckBox hispanic = findViewById(R.id.hispanic);
        CheckBox hawaiian = findViewById(R.id.hawaiian);
        CheckBox more = findViewById(R.id.more);

        if (nativeAM.isChecked()) {
            race += getString(R.string.raceNativeAM);
        } else if (asian.isChecked()) {
            race += getString(R.string.raceAsian);
        } else if (black.isChecked()) {
            race += getString(R.string.raceBlack);
        } else if (caucasian.isChecked()) {
            race += getString(R.string.raceCaucasian);
        } else if (hispanic.isChecked()) {
            race += getString(R.string.raceHispanic);
        } else if (hawaiian.isChecked()) {
            race += getString(R.string.raceHawaiian);
        } else if (more.isChecked()) {
            race += getString(R.string.raceMore);
        } else {
            race += getString(R.string.raceNone);
        }


    }

    /**
     * Calculates points for question 1.
     */
    public void calculateScore1(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left1:
                if (checked)
                    score += 2;
                break;
            case R.id.right1:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Calculates points for question 2.
     */
    public void calculateScore2(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left2:
                if (checked)
                    score += 2;
                break;
            case R.id.right2:
                if (checked)
                    score += 1;
                break;
        }
    }


    /**
     * Calculates points for question 3.
     */
    public void calculateScore3(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left3:
                if (checked)
                    score += 2;
                break;
            case R.id.right3:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Calculates points for question 4.
     */
    public void calculateScore4(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left4:
                if (checked)
                    score += 2;
                break;
            case R.id.right4:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Calculates points for question 5.
     */
    public void calculateScore5(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left5:
                if (checked)
                    score += 2;
                break;
            case R.id.right5:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Calculates points for question 6.
     */
    public void calculateScore6(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left6:
                if (checked)
                    score += 2;
                break;
            case R.id.right6:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Calculates points for question 7.
     */
    public void calculateScore7(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.left7:
                if (checked)
                    score += 2;
                break;
            case R.id.right7:
                if (checked)
                    score += 1;
                break;
        }
    }

    /**
     * Interprets the scores after the Result button is pressed.
     */
    public void interpretScore(View view) {
        String leftOrRight = "";

        if (score >= 12) {
            leftOrRight += score;
            leftOrRight += " points.\n";
            leftOrRight += getString(R.string.left);
            displayResult(leftOrRight);
        } else if (score >= 9) {
            leftOrRight += score;
            leftOrRight += " points.\n";
            leftOrRight += getString(R.string.balanced);
            displayResult(leftOrRight);
        } else {
            leftOrRight += score;
            leftOrRight += " points.\n";
            leftOrRight += getString(R.string.right);
            displayResult(leftOrRight);
        }
    }

    /**
     * Displays the result on screen.
     */
    private void displayResult(String result) {

        RadioGroup radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        int selectedGender = radioGroupGender.getCheckedRadioButtonId();
        RadioButton buttonGender = (RadioButton) findViewById(selectedGender);
        gender += buttonGender.getText().toString().toLowerCase();
        genderResult += getString(R.string.genderResult) + gender;

        RadioGroup selectedGroupAge = (RadioGroup) findViewById(R.id.radioGroupAge);
        int selectedAgeRange = selectedGroupAge.getCheckedRadioButtonId();
        RadioButton buttonAge = (RadioButton) findViewById(selectedAgeRange);
        age += buttonAge.getText().toString();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        TextView displayResult = (TextView) findViewById(R.id.result);
        displayResult.setText(getString(R.string.hi) + name + genderResult + getString(R.string.linebreak) + race +
                getString(R.string.belong) + age + getString(R.string.agescore) + result);
    }

}
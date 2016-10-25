package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*This app displays a quiz about octopuses*/

    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the submit_answers button is clicked
    public void submitAnswers(View view) {
        RadioButton ansOneTrue = (RadioButton) findViewById(R.id.answer_1_true);
        boolean ansOnePickedTrue = ansOneTrue.isChecked();

        RadioButton ansOneFalse = (RadioButton) findViewById(R.id.answer_1_false);
        boolean ansOnePickedFalse = ansOneFalse.isChecked();

        RadioButton ansTwoChoiceOne = (RadioButton) findViewById(R.id.answer_2_choice_1);
        boolean ansTwoPickedChoiceOne = ansTwoChoiceOne.isChecked();

        RadioButton ansTwoChoiceTwo = (RadioButton) findViewById(R.id.answer_2_choice_2);
        boolean ansTwoPickedChoiceTwo = ansTwoChoiceTwo.isChecked();

        RadioButton ansTwoChoiceThree = (RadioButton) findViewById(R.id.answer_2_choice_3);
        boolean ansTwoPickedChoiceThree = ansTwoChoiceThree.isChecked();

        CheckBox ansThreeChoiceOne = (CheckBox) findViewById(R.id.answer_3_choice_1);
        boolean ansThreePickedChoiceOne = ansThreeChoiceOne.isChecked();

        CheckBox ansThreeChoiceTwo = (CheckBox) findViewById(R.id.answer_3_choice_2);
        boolean ansThreePickedChoiceTwo = ansThreeChoiceTwo.isChecked();

        CheckBox ansThreeChoiceThree = (CheckBox) findViewById(R.id.answer_3_choice_3);
        boolean ansThreePickedChoiceThree = ansThreeChoiceThree.isChecked();

        CheckBox ansThreeChoiceFour = (CheckBox) findViewById(R.id.answer_3_choice_4);
        boolean ansThreePickedChoiceFour = ansThreeChoiceFour.isChecked();

        CheckBox ansFourChoiceOne = (CheckBox) findViewById(R.id.answer_4_choice_1);
        boolean ansFourPickedChoiceOne = ansFourChoiceOne.isChecked();

        CheckBox ansFourChoiceTwo = (CheckBox) findViewById(R.id.answer_4_choice_2);
        boolean ansFourPickedChoiceTwo = ansFourChoiceTwo.isChecked();

        CheckBox ansFourChoiceThree = (CheckBox) findViewById(R.id.answer_4_choice_3);
        boolean ansFourPickedChoiceThree = ansFourChoiceThree.isChecked();

        CheckBox ansFourChoiceFour = (CheckBox) findViewById(R.id.answer_4_choice_4);
        boolean ansFourPickedChoiceFour = ansFourChoiceFour.isChecked();

        EditText ansFiveInput = (EditText) findViewById(R.id.answer_5_edit_text);
        String ansFiveUserInput = ansFiveInput.getText().toString();

        int totalScore = (checkQuestionOne(ansOnePickedTrue) + checkQuestionTwo(ansTwoPickedChoiceThree) + checkQuestionThree(ansThreePickedChoiceTwo, ansFourPickedChoiceThree) + checkQuestionFour(ansFourPickedChoiceOne, ansFourPickedChoiceTwo, ansFourPickedChoiceThree, ansFourPickedChoiceFour) + checkQuestionFive(ansFiveUserInput));
        Toast.makeText(this, "You got " + totalScore + " out of 5 right!", Toast.LENGTH_LONG).show();
    }

    private int checkQuestionOne(boolean pickedTrue) {
        int score = 0;
        if (pickedTrue) {
            score += 1;
        }
        return score;
    }

    private int checkQuestionTwo(boolean pickedChoiceThree) {
        int score = 0;
        if (pickedChoiceThree) {
            score += 1;
        }
        return score;
    }

    private int checkQuestionThree(boolean choiceTwo, boolean choiceThree) {
        int score = 0;
        if (choiceTwo && choiceThree) {
            score += 1;
        }
        return score;
    }

    private int checkQuestionFour(boolean choiceOne, boolean choiceTwo, boolean choiceThree, boolean choiceFour) {
        int score = 0;
        if (choiceOne && choiceTwo && choiceThree && choiceFour) {
            score += 1;
        }
        return score;
    }

    private int checkQuestionFive(String ansFiveUserInput) {
        int score = 0;
        return score +=1;
    }


    private void createScoreMessage(int score) {

    }

}


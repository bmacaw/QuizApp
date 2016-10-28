package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /*This app displays a quiz about octopuses*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the submit_answers button is clicked
    public void submitAnswers(View view) {

        // Create variables for all answers
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

        // Total score
        int totalScore = (checkQuestionOne(ansOnePickedTrue)
                + checkQuestionTwo(ansTwoPickedChoiceThree)
                + checkQuestionThree(ansThreePickedChoiceOne, ansThreePickedChoiceTwo, ansThreePickedChoiceThree, ansThreePickedChoiceFour)
                + checkQuestionFour(ansFourPickedChoiceOne, ansFourPickedChoiceTwo, ansFourPickedChoiceThree, ansFourPickedChoiceFour)
                + checkQuestionFive(ansFiveUserInput));
        if (totalScore == 5) {
            // Feedback message to user
            Toast.makeText(this, "Congratulations! You got 5 out of 5 right!", Toast.LENGTH_SHORT).show();
        } else {
            // Feedback message to user
            Toast.makeText(this, "You got " + totalScore + " out of 5 right!", Toast.LENGTH_LONG).show();
        }


    }

    /*This method creates Toasts to support the user for the Checkbox answers*/

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox checkboxes are clicked for Question 3
        switch (view.getId()) {
            case R.id.answer_3_choice_1:

                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.not_answer_one, Toast.LENGTH_LONG).show();
                    break;
                }

            case R.id.answer_3_choice_2:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.is_answer, Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.answer_3_choice_3:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.is_answer, Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.answer_3_choice_4:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.not_answer_four, Toast.LENGTH_LONG).show();
                    break;
                }
        }

        // Check which checkbox checkboxes are clicked for Question 4
        switch (view.getId()) {
            case R.id.answer_4_choice_1:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.is_answer, Toast.LENGTH_SHORT).show();
                    break;
                }
            case R.id.answer_4_choice_2:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.not_answer_two, Toast.LENGTH_LONG).show();
                    break;
                }
            case R.id.answer_4_choice_3:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.not_answer_three, Toast.LENGTH_LONG).show();
                    break;
                }
            case R.id.answer_4_choice_4:
                if (checked) {
                    // What to do
                    Toast.makeText(this, R.string.is_answer, Toast.LENGTH_SHORT).show();
                    break;
                }
        }
    }

    /* This method checks question #1
    * @param pickedTrue is the user's choice for the right answer
    * @return score is the score awarded for question number one
    */

    private int checkQuestionOne(boolean pickedTrue) {
        int score = 0;
        if (pickedTrue) {
            score++;
        }
        return score;
    }

    /* This method checks question #2
    * @param pickedChoiceThree is the user's choice for the right answer
    * @return score is the score awarded for question number two
    */

    private int checkQuestionTwo(boolean pickedChoiceThree) {
        int score = 0;
        if (pickedChoiceThree) {
            score++;
        }
        return score;
    }

    /* This method checks question #3
    * @param choiceTwo, choiceThree is the user's choice for the right answer
    * @return score is the score awarded for question number three
    */

    public int checkQuestionThree(boolean choiceOne, boolean choiceTwo, boolean choiceThree, boolean choiceFour) {
        int score = 0;
        if (!choiceOne && choiceTwo && choiceThree && !choiceFour) {
            score++;
        }
        return score;
    }

    /* This method checks question #4
    * @param choiceOne, choiceTwo, choiceThree, choiceFour is the user's choice for the right answer
    * @return score is the score awarded for question number four
    */

    private int checkQuestionFour(boolean choiceOne, boolean choiceTwo, boolean choiceThree, boolean choiceFour) {
        int score = 0;
        if (choiceOne && !choiceTwo && !choiceThree && choiceFour) {
            score++;
        }
        return score;
    }

    /* This method checks question #5
    * @param senseOfHearing is to store the correct answer for question number five
    * @return score is the score awarded for question number five
    */

    private int checkQuestionFive(String userInput) {
        String senseOfHearing = "hearing";
        int score = 0;
        if (senseOfHearing.equalsIgnoreCase(userInput)) {
            score++;
        }
        return score;
    }
}
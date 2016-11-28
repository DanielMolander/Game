package com.danmolander.kidsgame.cards;

import android.content.Context;
import android.widget.TextView;

import com.danmolander.kidsgame.R;

import java.util.Random;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class DivisionCard extends QuestionCard {

    private Integer firstNumber;
    private Integer secondNumber;

    public DivisionCard(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((TextView) findViewById(R.id.view_question_card_operation_symbol)).setText("/");
    }

    @Override
    protected int secondNumber() {
        if (secondNumber == null) {
            secondNumber = new Random().nextInt(9) + 1;
        }
        return secondNumber;
    }

    @Override
    protected int firstNumber() {
        if (firstNumber == null) {
            firstNumber = randomNumber() * secondNumber;
        }
        return firstNumber;
    }
    @Override
    protected boolean checkAnswer(int firstValue, int secondValue, int answer) {
        return answer == firstValue / secondValue;
    }
}

package com.danmolander.kidsgame.cards;

import android.content.Context;
import android.widget.TextView;

import com.danmolander.kidsgame.R;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class PlusCard extends QuestionCard {

    public PlusCard(Context context) {
        super(context);
        init();
    }

    private void init() {
        ((TextView) findViewById(R.id.view_question_card_operation_symbol)).setText("+");
    }

    @Override
    protected boolean checkAnswer(int firstValue, int secondValue, int answer) {
        return answer == firstValue + secondValue;
    }
}

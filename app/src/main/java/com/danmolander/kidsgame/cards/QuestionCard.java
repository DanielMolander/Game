package com.danmolander.kidsgame.cards;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.danmolander.kidsgame.system.Bank;
import com.danmolander.kidsgame.R;

import java.util.Random;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public abstract class QuestionCard extends Dialog {

    private int firstValue;
    private int secondValue;

    public QuestionCard(Context context) {
        super(context);
        init();
    }

    private void init() {
        View v = getLayoutInflater().inflate(R.layout.view_question_card, null);
        setContentView(v);
        final EditText editText = (EditText) v.findViewById(R.id.view_question_card_input_field);
        Button button = (Button) findViewById(R.id.view_question_card_done_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString = editText.getText().toString();
                if (!inputString.isEmpty() && checkAnswer(firstValue, secondValue, Integer.parseInt(inputString))) {
                    Bank.addGold(1);
                }
                dismiss();
            }
        });
        //second also is made first since it could affect valid values for the top number
        secondValue = secondNumber();
        firstValue = firstNumber();
        ((TextView) v.findViewById(R.id.view_question_card_first_number)).setText(""+ firstValue);
        ((TextView) v.findViewById(R.id.view_question_card_second_number)).setText(""+ secondValue);
    }

    protected int secondNumber() {
        return randomNumber();
    }

    protected int firstNumber() {
        return randomNumber();
    }

    protected int randomNumber() {
        return new Random().nextInt(10);
    }

    protected abstract boolean checkAnswer(int firstValue, int secondValue, int answer);
}

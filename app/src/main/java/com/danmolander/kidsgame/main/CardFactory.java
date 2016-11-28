package com.danmolander.kidsgame.main;

import android.content.Context;

import com.danmolander.kidsgame.cards.*;

import java.util.Random;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class CardFactory {

    private static Random random = new Random();

    public QuestionCard getRandomCard(Context context) {
        int i = random.nextInt(4);
        switch (i) {
            case 1:
                return new SubtractionCard(context);
            case 2:
                return new MultiplicationCard(context);
            case 3:
                return new DivisionCard(context);
            case 0:
            default:
                return new PlusCard(context);
        }
    }

}

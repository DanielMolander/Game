package com.danmolander.kidsgame.system;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class Bank {

    private static int gold = 0;

    public static void addGold(int amount) {
        Bank.gold += amount;
        MyApplication.systemEventBus.onNext(MyApplication.SystemEvent.GOLD_ADDITION);
    }

    public static boolean spendGold(int amount) {
        if (Bank.gold >= amount) {
            Bank.gold -= amount;
            return true;
        }
        return false;
    }

    public static int getGold() {
        return gold;
    }

}

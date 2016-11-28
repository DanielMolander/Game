package com.danmolander.kidsgame.system;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class CityUpgrade {

    public CityUpgrade() {

    }

    private int numUpgrades = 0;

    public int getPrice() {
        return (int) (getBasePrice() * Math.pow(1.2,numUpgrades));
    }

    protected int getBasePrice() {
        return 1;
    }

    public void upgrade() {
        if (Bank.spendGold(getPrice())) {
            numUpgrades++;
        }
    }

}

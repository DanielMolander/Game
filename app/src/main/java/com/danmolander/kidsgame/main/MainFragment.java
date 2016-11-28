package com.danmolander.kidsgame.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.danmolander.kidsgame.system.Bank;
import com.danmolander.kidsgame.system.CityUpgrade;
import com.danmolander.kidsgame.system.MyApplication;
import com.danmolander.kidsgame.R;

import rx.functions.Action1;
import rx.functions.Func1;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class MainFragment extends Fragment {

    private TextView goldText;
    private CardFactory cardFactory;
    private View upgradeContainer;
    private CityUpgrade waterUpgrade = new CityUpgrade();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //TODO : unlocking other math cards should be a gold purchase

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        goldText = (TextView) rootView.findViewById(R.id.fragment_main_gold_text);
        cardFactory = new CardFactory();
        Button addGold = (Button) rootView.findViewById(R.id.fragment_main_add_gold_button);
        addGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardFactory.getRandomCard(getContext()).show();
            }
        });
        MyApplication.systemEventBus.filter(new Func1<MyApplication.SystemEvent, Boolean>() {
            @Override
            public Boolean call(MyApplication.SystemEvent systemEvent) {
                return systemEvent == MyApplication.SystemEvent.GOLD_ADDITION;
            }
        }).subscribe(new Action1<MyApplication.SystemEvent>() {
            @Override
            public void call(MyApplication.SystemEvent systemEvent) {
                updateGold();
            }
        });

        upgradeContainer = rootView.findViewById(R.id.fragment_main_upgrade_container);
        rootView.findViewById(R.id.fragment_main_action_button_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (upgradeContainer.getVisibility() != VISIBLE) {
                    upgradeContainer.setVisibility(VISIBLE);
                } else {
                    upgradeContainer.setVisibility(GONE);
                }
            }
        });
        rootView.findViewById(R.id.fragment_main_upgrade_water_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterUpgrade.upgrade();
            }
        });

        return rootView;
    }

    private void updateGold() {
        goldText.setText(""+ Bank.getGold());
    }
}

package com.danmolander.kidsgame.system;

import android.app.Application;

import rx.subjects.PublishSubject;

/**
 * Copyright © 2016. Zonoff, Inc.  All Rights Reserved.
 */

public class MyApplication extends Application {


    public static PublishSubject<SystemEvent> systemEventBus = PublishSubject.create();

    public enum SystemEvent {
        GOLD_ADDITION
    }

}

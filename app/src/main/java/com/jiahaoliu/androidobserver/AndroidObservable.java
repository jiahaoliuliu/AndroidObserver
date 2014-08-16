package com.jiahaoliu.androidobserver;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;

import java.util.Observable;
import java.util.Observer;


public class AndroidObservable extends Observable {

    /**
     * The countdown will be for 10 seconds
     */
    private static final int TOTAL_TIME = 10000;

    /**
     * The tick will be sent with the interval of 1 second
     */
    private static final int TICKS = 1000;

    private int ticks;

    public AndroidObservable() {
        super();
        SimpleCountDownTimer simpleCountDownTimer = new SimpleCountDownTimer(TOTAL_TIME, TICKS);
        simpleCountDownTimer.start();
    }

    private class SimpleCountDownTimer extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public SimpleCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            ticks ++;
            setChanged();
            notifyObservers(ticks);
        }

        @Override
        public void onFinish() {
            setChanged();
            notifyObservers(ticks);
        }
    };
}

package com.jiahaoliu.androidobserver;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;

import java.util.Observable;
import java.util.Observer;


public class AndroidObservable extends Observable {

    public AndroidObservable() {
        super();
        SimpleCountDownTimer simpleCountDownTimer = new SimpleCountDownTimer(10000, 1000);
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
            setChanged();
            notifyObservers();
        }

        @Override
        public void onFinish() {
            setChanged();
            notifyObservers();
        }
    };
}

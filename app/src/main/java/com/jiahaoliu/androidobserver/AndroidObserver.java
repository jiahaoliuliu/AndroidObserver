package com.jiahaoliu.androidobserver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class AndroidObserver extends ActionBarActivity implements Observer {

    private TextView simpleTextView;
    private int updates = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_observer_layout);
        simpleTextView = (TextView) findViewById(R.id.simpleTextView);
        AndroidObservable androidObservable = new AndroidObservable();
        androidObservable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        updates++;
        simpleTextView.setText("Update number " + updates);
    }
}

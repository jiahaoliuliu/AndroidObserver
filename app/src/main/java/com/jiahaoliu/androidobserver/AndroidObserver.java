package com.jiahaoliu.androidobserver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;


public class AndroidObserver extends ActionBarActivity implements Observer {

    /**
     * The maximum number of updates allowed
     */
    private static final int MAX_UPDATES = 5;

    // The actual update
    private int actualUpdate = 0;

    private TextView simpleTextView;
    private AndroidObservable androidObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_observer_layout);
        simpleTextView = (TextView) findViewById(R.id.simpleTextView);
        androidObservable = new AndroidObservable();
        androidObservable.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object data) {
        Integer update = (Integer) data;
        simpleTextView.setText("Update number " + update);
        actualUpdate ++;
        // Remove the observer after max number of update allowed
        if (actualUpdate >= MAX_UPDATES) {
            androidObservable.deleteObserver(this);
        }
    }
}

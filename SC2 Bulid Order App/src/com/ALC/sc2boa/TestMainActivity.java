package com.ALC.sc2boa;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TestMainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_test_main, menu);
        return true;
    }
}

package com.drimtim.dimlights;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.drimtim.dimlights.dimlights.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        startService(new Intent(this, SoundService.class));
    }

    public void exitOnClick(View view) {
        stopService(new Intent(this, SoundService.class));
        FragmentManager fragmentManager = getSupportFragmentManager();
        ConfirmDialog dialog = new ConfirmDialog();
        dialog.setTitle("Exit");
        dialog.show(fragmentManager, "dialog");
    }

    public void gameOnClick(View view) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }
}

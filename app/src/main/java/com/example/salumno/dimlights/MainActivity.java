package com.example.salumno.dimlights;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void exitOnClick(View view) {
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

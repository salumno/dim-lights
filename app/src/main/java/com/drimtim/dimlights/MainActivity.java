package com.drimtim.dimlights;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startGameBtn;
    private Button settingsBtn;
    private Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startGameBtn = (Button) findViewById(R.id.startGameBtn);
        settingsBtn = (Button) findViewById(R.id.settingsBtn);
        exitBtn = (Button) findViewById(R.id.exitBtn);
        startGameBtn.setOnClickListener(this);
        settingsBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startGameBtn:
                startActivity(new Intent(MainActivity.this, GameActivity.class));
                break;
            case R.id.settingsBtn:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;
            case R.id.exitBtn:
                //// TODO: 08.11.2016 alert dialog exit
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(R.string.exit_dialog_title);
                builder.setTitle(R.string.exit_dialog_title);
                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.onBackPressed();
                    }
                });
                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //// TODO: 08.11.2016 close dialog а хотя и так все работает
                    }
                });
                builder.setCancelable(true);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        //// TODO: 08.11.2016 close dialog
                    }
                });
                AlertDialog exitDialog = builder.create();
                exitDialog.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

package com.drimtim.dimlights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.drimtim.dimlights.dimlights.R;


public class GameActivity extends AppCompatActivity {

    MenuItem settings;
    MenuItem sound;
    MenuItem noSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                ConfirmDialog dialog = new ConfirmDialog();
                dialog.setTitle("Exit");
                dialog.show(fragmentManager, "dialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_game, menu);
        settings = menu.findItem(R.id.settings);
        sound = menu.findItem(R.id.sound);
        noSound = menu.findItem(R.id.noSound);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.equals(settings)) {
            Intent intent = new Intent(this, OptionsActivity.class);
            startActivity(intent);
        } else if (item.equals(sound)) {
            Toast.makeText(getApplicationContext(), "Sound turned on", Toast.LENGTH_SHORT).show();
            startService(new Intent(this, SoundService.class));
        } else if (item.equals(noSound)) {
            Toast.makeText(getApplicationContext(), "Sound turned off", Toast.LENGTH_SHORT).show();
            stopService(new Intent(this, SoundService.class));
        }
        return super.onOptionsItemSelected(item);
    }
}

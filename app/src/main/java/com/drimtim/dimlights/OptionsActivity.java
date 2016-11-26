package com.drimtim.dimlights;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.drimtim.dimlights.dimlights.R;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        CheckBox checkBoxSoundSettings = (CheckBox)findViewById(R.id.checkBoxSound);
        boolean isChecked = getBooleanFromPreferences("isChecked");
        Log.i("start","" + isChecked);
        checkBoxSoundSettings.setChecked(isChecked);
        checkBoxSoundSettings.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Log.i("boolean", "" + isChecked);
                OptionsActivity.this.putBooleanInPreferences(isChecked, "isChecked");
                if(isChecked) {
                    Toast.makeText(getApplicationContext(), "Sound turned on", Toast.LENGTH_SHORT).show();
                    startService(new Intent(OptionsActivity.this, SoundService.class));
                } else {
                    Toast.makeText(getApplicationContext(), "Sound turned off", Toast.LENGTH_SHORT).show();
                    stopService(new Intent(OptionsActivity.this, SoundService.class));
                }
            }
        });
    }


    public void putBooleanInPreferences(boolean isChecked, String key){
        SharedPreferences sharedPreferences = this.getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, isChecked);
        editor.commit();
    }

    public boolean getBooleanFromPreferences(String key){
        SharedPreferences sharedPreferences = this.getPreferences(Activity.MODE_PRIVATE);
        Boolean isChecked = sharedPreferences.getBoolean(key, false);
        return isChecked;
    }

    public void aboutOnClick(View view) {
        Intent intent = new Intent(OptionsActivity.this, AboutActivity.class);
        startActivity(intent);
    }

    public void rulesOnClick(View view) {
        Intent intent = new Intent(OptionsActivity.this, RulesActivity.class);
        startActivity(intent);
    }

}

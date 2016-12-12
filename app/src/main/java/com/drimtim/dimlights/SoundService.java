package com.drimtim.dimlights;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.drimtim.dimlights.dimlights.R;

public class SoundService extends Service {

    private static final String TAG = "SoundService";
    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.theme);
        mediaPlayer.setLooping(true);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        mediaPlayer.start();
    }
}

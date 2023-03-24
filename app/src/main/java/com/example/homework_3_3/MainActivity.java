package com.example.homework_3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonPlay; // создание кнопки
    private MediaPlayer mediaPlayer; // создание медиа-плеера
    private Button buttonStop;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay = findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(event -> {
            System.out.println("Сейчас заиграет музыка");
            mediaPlayer = MediaPlayer.create(this, R.raw.m83_wait);
            mediaPlayer.start();
        });

        buttonStop = findViewById(R.id.buttonStop);

        buttonStop.setOnClickListener(event -> {
            mediaPlayer.stop();
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        System.out.println("Вы нажали кнопку " + keyCode);

        if (keyCode == KeyEvent.KEYCODE_BACK) { //
            System.out.println("Вы нажали кнопку НАЗАД");
            mediaPlayer.stop();
            return true;

        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) { //
            System.out.println("Вы нажали кнопку СДЕЛАТЬ ГРОМЧЕ");
            return true;

        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) { //
            System.out.println("Вы нажали кнопку СДЕЛАТЬ ТИШЕ");
            return true;

        }

        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    // метод освобождения используемых медиа-плеером ресурсов
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
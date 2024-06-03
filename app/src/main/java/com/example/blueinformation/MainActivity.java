package com.example.blueinformation;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        Configuration config = getResources().getConfiguration();
        onConfigurationChanged(config);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.main_activity_landscape);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.main_activity_portrait);
        }

        super.onConfigurationChanged(newConfig);
    }

    public void onClickVoiceline(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.voiceline);
        mediaPlayer.start();
    }

    public void onClickWebsite(View view) {
        String url = "https://bluearchive.fandom.com/wiki/Takanashi_Hoshino";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    public void onClickTelephone(View view) {
        String number = "tel:1-202-324-3000";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
        startActivity(intent);
    }

    public void onClickButton(View view) {
        if (view.getId() == R.id.ButtonVoiceline) {
            onClickVoiceline(view);
        } else if (view.getId() == R.id.ButtonTelephone) {
            onClickTelephone(view);
        } else if (view.getId()==R.id.ButtonWebsite) {
            onClickWebsite(view);
        }
    }

    @Override
    public void onClick(View view) {
        onClickButton(view);
    }
}
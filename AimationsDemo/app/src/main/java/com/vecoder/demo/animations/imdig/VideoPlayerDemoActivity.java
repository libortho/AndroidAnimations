package com.vecoder.demo.animations.imdig;

import com.improvedigital.mobile360sdk.player.ImproveDigitalVideoPlayer;
import com.improvedigital.mobile360sdk.player.VideoPlayerStateListener;
import com.vecoder.demo.animations.R;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by v.gacina on 7/6/2016.
 */
public class VideoPlayerDemoActivity extends AppCompatActivity implements VideoPlayerStateListener
{


    private static final String TAG = "VideoPlayerDemoActivity";

    private ImproveDigitalVideoPlayer mImproveDigitalVideoPlayer;

    private final static int PLACEMENT_ID = 526705;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_videoplayer_demo);

        bindViews();
        if(mImproveDigitalVideoPlayer != null){
            mImproveDigitalVideoPlayer.setVideoPlayerStateListener(this);

            mImproveDigitalVideoPlayer.setVideoUrl("http://www.improvedigital.com/main/wp-content/uploads/2014/11/Final_video_latest_.mp4");
            setCustomResources();
            mImproveDigitalVideoPlayer.setPlacementId(PLACEMENT_ID);
            mImproveDigitalVideoPlayer.load();
        }
    }

    private void bindViews(){
        mImproveDigitalVideoPlayer = (ImproveDigitalVideoPlayer) findViewById(R.id.improvedigital_video_player);
    }

    private void setCustomResources(){

        //methods for customizing the controls bar of the video player
        mImproveDigitalVideoPlayer.setCustomPlayButton(ContextCompat.getDrawable(this, R.drawable.ic_play_button_c1));
        mImproveDigitalVideoPlayer.setCustomPauseButton(ContextCompat.getDrawable(this, R.drawable.ic_pause_button_c1));
        mImproveDigitalVideoPlayer.setCustomControlsBackground("#80CCBC08");
    }

    @Override
    public void onVideoPlayerLoadFinished() {
        Log.d(TAG, "onVideoPlayerLoadFinished called");
        mImproveDigitalVideoPlayer.play();

    }

    @Override
    public void onVideoPlayerPlaybackFinished() {
        Log.d(TAG, "onVideoPlayerPlaybackFinished called");

    }

    @Override
    public void onVideoPlayerErrorOccurred(String s, int i) {

    }
}

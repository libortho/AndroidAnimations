package com.vecoder.demo.animations.dialogfragment;


import com.vecoder.demo.animations.R;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

/**
 * Created by v.gacina on 6/16/2016.
 */
public class DialogFragmentDemoAct extends AppCompatActivity implements View.OnClickListener{

    private static final String LOG_TAG = "DialogFragmentDemoAct";

    private EditText mEtAnimationDuration;

    private RadioGroup mRgAnimationTypes;

    public static final int ANIM_TYPE_LEFT = 1;
    public static final int ANIM_TYPE_RIGHT = 2;
    public static final int ANIM_TYPE_TOP = 3;
    public static final int ANIM_TYPE_BOTTOM = 4;
    public static final int ANIM_TYPE_FADE_IN = 5;

    private int mAnimationType = ANIM_TYPE_LEFT;

    private int mDisplayHeightPx = 0;

    private int mDisplayWidthPx = 0;


    private void bindViews(){
        Button btnShowDialogFragment = (Button) findViewById(R.id.btnShowDialogFragment);
        if(btnShowDialogFragment != null) {
            btnShowDialogFragment.setOnClickListener(this);
        }

        mEtAnimationDuration = (EditText) findViewById(R.id.etAnimationDuration);

        mRgAnimationTypes = (RadioGroup) findViewById(R.id.rgAnimationTypes);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_dialoganimdemo);
        bindViews();

        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        mDisplayHeightPx = displayMetrics.heightPixels;
        mDisplayWidthPx = displayMetrics.widthPixels;

        Log.d(LOG_TAG, "On Created. savedInstanceState " + (savedInstanceState != null ? " not null" : " is null"));

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "On Stopped");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "On Paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "On Destroyed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "On Resume");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(LOG_TAG, "onConfigurationChanged");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(LOG_TAG, "onSaveInstanceState.  outState " + (outState != null? " not null" : "null"));
    }

    private void showEditDialog() {

        FragmentManager fm = getSupportFragmentManager();
        EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance("Some Title");

        Bundle bundle = new Bundle();
        bundle.putInt(EditNameDialogFragment.KEY_ANIM_TYPE, mAnimationType);
        String durationValue = mEtAnimationDuration.getText().toString();
        int duration;
        try {
            duration = Integer.valueOf(durationValue);
        }catch (NumberFormatException e){
            duration = 1000;
        }
        bundle.putInt(EditNameDialogFragment.KEY_ANIM_DURATION, duration);

        editNameDialogFragment.setArguments(bundle);
        editNameDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
        editNameDialogFragment.show(fm, "fragment_edit_name");
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnShowDialogFragment:
                showEditDialog();
                break;

            default:
                Log.e(LOG_TAG, "Not supported");
        }
    }

    public void onRadioButtonClicked(View view){
        switch (view.getId()){
            case R.id.rbSlideInLeft:
                mAnimationType = ANIM_TYPE_LEFT;
                break;
            case R.id.rbSlideInRight:
                mAnimationType = ANIM_TYPE_RIGHT;
                break;
            case R.id.rbSlideInBottom:
                mAnimationType = ANIM_TYPE_BOTTOM;
                break;
            case R.id.rbSlideInTop:
                mAnimationType = ANIM_TYPE_TOP;
                break;
            case R.id.rbFadeIn:
                mAnimationType = ANIM_TYPE_FADE_IN;
                break;
            default:
                mAnimationType = ANIM_TYPE_LEFT;
                break;
        }
    }
}

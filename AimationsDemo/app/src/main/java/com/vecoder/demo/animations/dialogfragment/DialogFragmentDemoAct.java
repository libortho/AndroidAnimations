package com.vecoder.demo.animations.dialogfragment;


import com.vecoder.demo.animations.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
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

    }

    private void showEditDialog() {

        FragmentManager fm = getSupportFragmentManager();
        EditNameDialogFragment editNameDialogFragment = EditNameDialogFragment.newInstance("Some Title");

        Bundle bundle = new Bundle();
        bundle.putInt(EditNameDialogFragment.KEY_ANIM_TYPE, mAnimationType);
        String durationValue = mEtAnimationDuration.getText().toString();
        Integer.valueOf(durationValue);
        bundle.putInt(EditNameDialogFragment.KEY_ANIM_DURATION, Integer.valueOf(durationValue));

        editNameDialogFragment.setArguments(bundle);
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

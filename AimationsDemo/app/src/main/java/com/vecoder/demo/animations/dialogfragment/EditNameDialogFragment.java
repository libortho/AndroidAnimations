package com.vecoder.demo.animations.dialogfragment;

import com.vecoder.demo.animations.R;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by v.gacina on 6/16/2016.
 */
public class EditNameDialogFragment extends DialogFragment {
    private ImageView mImageView;
    private static final String LOG_TAG = "EditNameDialogFragment";

    private static final String KEY_SHOULD_ANIMATE = "key_should_animate";

    public static final String KEY_ANIM_TYPE = "anim_type";
    public static final String KEY_ANIM_DURATION = "anim_duration";

    private boolean mShouldAnimate = true;


    public EditNameDialogFragment() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static EditNameDialogFragment newInstance(String title) {
        EditNameDialogFragment frag = new EditNameDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setRetainInstance(true);
        Log.d(LOG_TAG, " on created view. savedInstanceState " + (savedInstanceState != null ? " not null" : " is null"));
        if(savedInstanceState != null){
            mShouldAnimate = savedInstanceState.getBoolean(KEY_SHOULD_ANIMATE, true);
        }else{
            mShouldAnimate = true;
        }
        return inflater.inflate(R.layout.fragment_edit_name, container);
    }

    @Override
    @SuppressLint("InlinedApi")
    public void onStart()
    {
        super.onStart();

        Bundle arguments =  getArguments();
        int animationType = arguments.getInt(KEY_ANIM_TYPE);
        int duration = arguments.getInt(KEY_ANIM_DURATION);
        boolean showInFullscreen = true;

        Log.d(LOG_TAG, " on Started");

        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.setCancelable(true);

            final View decorView = dialog.getWindow()
                .getDecorView();

            if(showInFullscreen) {

                //Set the dialog to not focusable (makes navigation ignore us adding the window)
                dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);

                //Set the dialog to immersive
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

                    decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                                                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                                                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                                        View.SYSTEM_UI_FLAG_IMMERSIVE |
                                                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                }

                //Clear the not focusable flag from the window
                dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
            }

            if(mShouldAnimate) {
                animateAppearance(animationType, duration, dialog.getWindow());
            }

        }
    }

    private void animateAppearance(int animationType, int duration, Window window) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        final View decorView = window
            .getDecorView();

        switch(animationType){
            case DialogFragmentDemoAct.ANIM_TYPE_LEFT:
                decorView.setTranslationX(-displayMetrics.widthPixels);
                decorView.animate().translationXBy(displayMetrics.widthPixels).setDuration(duration)
                         .setInterpolator(new AccelerateDecelerateInterpolator());

                break;
            case DialogFragmentDemoAct.ANIM_TYPE_RIGHT:
                decorView.setTranslationX(displayMetrics.widthPixels);
                decorView.animate().translationXBy(-displayMetrics.widthPixels).setDuration(duration)
                         .setInterpolator(new AccelerateDecelerateInterpolator());

                break;
            case DialogFragmentDemoAct.ANIM_TYPE_TOP:
                decorView.setTranslationY(-displayMetrics.heightPixels);
                decorView.animate().translationYBy(displayMetrics.heightPixels).setDuration(duration)
                         .setInterpolator(new AccelerateDecelerateInterpolator());

                break;
            case DialogFragmentDemoAct.ANIM_TYPE_BOTTOM:
                decorView.setTranslationY(displayMetrics.heightPixels);
                decorView.animate().translationYBy(-displayMetrics.heightPixels).setDuration(duration)
                         .setInterpolator(new AccelerateDecelerateInterpolator());
                break;
            case DialogFragmentDemoAct.ANIM_TYPE_FADE_IN:
                ObjectAnimator.ofPropertyValuesHolder(decorView,
                                                      PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f))
                              .setDuration(duration)
                              .start();

                break;
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mImageView = (ImageView) view.findViewById(R.id.ivDemoAd);

        Log.d(LOG_TAG, " on View created");

        // Fetch arguments from bundle and set title
        //String title = getArguments().getString("title", "Enter Name");
       // getDialog().setTitle(title);

        //getDialog().getWindow().setSoftInputMode(
            //WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);

        Log.d(LOG_TAG, " on created dialog");

        if(dialog != null) {

            //dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        return dialog;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, " on  stopped");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(outState != null){
            outState.putBoolean(KEY_SHOULD_ANIMATE, false);
        }
        Log.d(LOG_TAG, "onSaveInstanceState.  outState " + (outState != null? " not null" : "null"));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, " on  destroy");

    }
}

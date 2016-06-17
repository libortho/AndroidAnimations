package com.vecoder.demo.animations.dialogfragment;

import com.vecoder.demo.animations.R;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.EditText;

/**
 * Created by v.gacina on 6/16/2016.
 */
public class EditNameDialogFragment extends DialogFragment {
    private EditText mEditText;

    public static final String KEY_ANIM_TYPE = "anim_type";
    public static final String KEY_ANIM_DURATION = "anim_duration";

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
        return inflater.inflate(R.layout.fragment_edit_name, container);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        Bundle arguments =  getArguments();
        int animationType = arguments.getInt(KEY_ANIM_TYPE);
        int duration = arguments.getInt(KEY_ANIM_DURATION);

        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);

            final View decorView = dialog
                .getWindow()
                .getDecorView();


            switch(animationType){
                case DialogFragmentDemoAct.ANIM_TYPE_LEFT:
                    decorView.setTranslationX(-700);
                    decorView.animate().translationXBy(700).setDuration(duration)
                             .setInterpolator(new AccelerateDecelerateInterpolator());

                    break;
                case DialogFragmentDemoAct.ANIM_TYPE_RIGHT:
                    decorView.setTranslationX(700);
                    decorView.animate().translationXBy(-700).setDuration(duration)
                             .setInterpolator(new AccelerateDecelerateInterpolator());

                    break;
                case DialogFragmentDemoAct.ANIM_TYPE_TOP:
                    decorView.setTranslationY(-1200);
                    decorView.animate().translationYBy(1200).setDuration(duration)
                             .setInterpolator(new AccelerateDecelerateInterpolator());

                    break;
                case DialogFragmentDemoAct.ANIM_TYPE_BOTTOM:
                    decorView.setTranslationY(1200);
                    decorView.animate().translationYBy(-1200).setDuration(duration)
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
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);
        // Show soft keyboard automatically and request focus to field
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);

        if(dialog != null) {

            //dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        return dialog;
    }
}

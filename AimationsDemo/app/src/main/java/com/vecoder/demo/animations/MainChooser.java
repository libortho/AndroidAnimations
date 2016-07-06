package com.vecoder.demo.animations;

import com.vecoder.demo.animations.dialogfragment.DialogFragmentDemoAct;
import com.vecoder.demo.animations.imdig.ScrollViewActivity;
import com.vecoder.demo.animations.imdig.VideoPlayerDemoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by v.gacina on 6/29/2016.
 */
public class MainChooser extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView mListView;

    private static final String[] ITEMS = {
        "Dialog fragment Animations",
        "Improve Digital Ads",
        "Improve Digital Video Player"
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainchooser);
        bindViews();
        setListAdapter();
    }

    private void bindViews(){
        mListView = (ListView) findViewById(R.id.lvMainChooser);


    }

    private void setListAdapter(){
        List<String> items = Arrays.asList(ITEMS);
        MainChooserListAdapter adapter = new MainChooserListAdapter(this, items);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent gotoActivity;
        switch(position){
            case 0:
                gotoActivity = new Intent(this, DialogFragmentDemoAct.class);
                startActivity(gotoActivity);
                break;
            case 1:
                gotoActivity = new Intent(this, ScrollViewActivity.class);
                startActivity(gotoActivity);
                break;
            case 2:
                gotoActivity = new Intent(this, VideoPlayerDemoActivity.class);
                startActivity(gotoActivity);
                break;
            default:
                Toast.makeText(this, "Invalid option", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

package com.vecoder.demo.animations.imdig;

import com.improvedigital.mobile360sdk.ImproveDigitalAdView;
import com.vecoder.demo.animations.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by v.gacina on 6/29/2016.
 */
public class ScrollViewActivity extends AppCompatActivity {

    private static final String DEMO_TEXT = "Daft Punk is an electronic music duo consisting of two French electronic music producers/DJs Guy-Manuel de Homem-Christo and Thomas Bangalter.[5][6][7][8] The two achieved significant popularity in the late 1990s as part of the French house movement and were met with continuous success in the years following, combining elements of house music with funk, techno, disco, rock, and synthpop.[2][6][7][9] They are also known for their visual stylization and disguises associated with their music; specifically, the duo have worn ornate helmets and gloves to assume robot personas in most of their public appearances since 2001. They rarely grant interviews or appear on television.\n"
        + "\n"
        + "Bangalter and de Homem-Christo were originally in a rock band called Darlin' together, which disbanded after a short period of time, leaving the two to experiment musically with drum machines and synthesizers. The duo became Daft Punk, releasing their debut album Homework on Virgin Records in 1997 to highly positive reviews. They were managed from 1996 to 2008 by Pedro Winter (Busy P), the head of Ed Banger Records.[10] The 2001 release of Discovery was even more successful, driven by the club singles \"One More Time\", \"Digital Love\", and \"Harder, Better, Faster, Stronger\". In March 2005, the duo released the album Human After All to mixed reviews. However, the singles \"Robot Rock\" and \"Technologic\" achieved success in the United Kingdom.\n"
        + "\n"
        + "Daft Punk toured throughout 2006 and 2007 and released the live album Alive 2007, which won a Grammy Award for Best Electronic/Dance Album. The duo composed the score of the film Tron: Legacy in 2010 and released its soundtrack album. In January 2013, Daft Punk left Virgin Records for Sony Music Entertainment's subsidiary label Columbia, and released Random Access Memories in 2013 to worldwide critical acclaim. The album's lead single \"Get Lucky\" became an international success, peaking in the top 10 in 32 countries. Random Access Memories led to five Grammy wins in 2014, including Album of the Year as well as Record of the Year for \"Get Lucky\".";


    private TextView mDemoText;

    private ImproveDigitalAdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_with_ads);

        bindView();
        mDemoText.setText(DEMO_TEXT);

        mAdView.loadAd();

    }

    private void bindView(){
        mDemoText = (TextView) findViewById(R.id.tv_scroll_demo_label);
        mAdView = (ImproveDigitalAdView) findViewById(R.id.ad_view);
    }
}

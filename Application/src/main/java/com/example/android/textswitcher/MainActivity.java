/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.textswitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageView;

/**
 * This sample shows the use of the {@link android.widget.TextSwitcher} View with animations. A
 * {@link android.widget.TextSwitcher} is a special type of {@link android.widget.ViewSwitcher} that animates
 * the current text out and new text in when
 * {@link android.widget.TextSwitcher#setText(CharSequence)} is called.
 */
public class MainActivity extends Activity {
    private TextSwitcher mSwitcher;
    private int mCounter;
    private Button nextButton;
    private Button backButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);

        // Get the TextSwitcher view from the layout
        mSwitcher = findViewById(R.id.switcher);

        // BEGIN_INCLUDE(setup)
        // Set the factory used to create TextViews to switch between.
        mSwitcher.setFactory(mFactory);

        /*
         * Set the in and out animations. Using the fade_in/out animations
         * provided by the framework.
         */
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);
        // END_INCLUDE(setup)

        /*
         * Setup the 'next' button. The counter is incremented when clicked and
         * the new value is displayed in the TextSwitcher. The change of text is
         * automatically animated using the in/out animations set above.
         */
        backButton = findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter++;

                if (mCounter==1){
                    mSwitcher.setText("สลัดผัก");
                    imageView = (ImageView)findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.a);
                }
                else if (mCounter==2) {
                    mSwitcher.setText("กราโนล่า");
                    imageView = (ImageView)findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.b);
                }
                else if (mCounter==3) {
                    mSwitcher.setText("อกไก่");
                    imageView = (ImageView)findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.c);
                }
                else if (mCounter==4) {
                    mSwitcher.setText("สุกี้");
                    imageView = (ImageView)findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.d);
                }
                else if (mCounter==5) {
                    mSwitcher.setText("ไข่ต้ม");
                    imageView = (ImageView)findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.e);
                }


                // mSwitcher.setText("asdasdasdasdasdasd");
                //mSwitcher.setText("4552");
                // END_INCLUDE(settext)
            }
        });

        nextButton = findViewById(R.id.button2);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCounter--;
                // BEGIN_INCLUDE(settext)

                if (mCounter == 1) {
                    mSwitcher.setText("สลัดผัก");
                    imageView = (ImageView) findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.a);
                } else if (mCounter == 2) {
                    mSwitcher.setText("กราโนร่า");
                    imageView = (ImageView) findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.b);
                } else if (mCounter == 3) {
                    mSwitcher.setText("อกไก่");
                    imageView = (ImageView) findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.c);
                } else if (mCounter == 4) {
                    mSwitcher.setText("สุกี้");
                    imageView = (ImageView) findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.d);
                } else if (mCounter == 5) {
                    mSwitcher.setText("ไข่ต้ม");
                    imageView = (ImageView) findViewById(R.id.p);
                    imageView.setImageResource(R.drawable.e);
                }


                // mSwitcher.setText("asdasdasdasdasdasd");
                //mSwitcher.setText("4552");
                // END_INCLUDE(settext)
            }
        });

        // Set the initial text without an animation
        // mSwitcher.setCurrentText(String.valueOf(mCounter));

    }

    // BEGIN_INCLUDE(factory)
    /**
     * The {@link android.widget.ViewSwitcher.ViewFactory} used to create {@link android.widget.TextView}s that the
     * {@link android.widget.TextSwitcher} will switch between.
     */
    private ViewFactory mFactory = new ViewFactory() {

        @Override
        public View makeView() {

            // Create a new TextView
            TextView t = new TextView(MainActivity.this);
            t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
            t.setTextAppearance(MainActivity.this, android.R.style.TextAppearance_Large);
            return t;
        }
    };
    // END_INCLUDE(factory)
}

package com.revanth.basicrootchecker;

/*
 * Copyright (C) 2018 Revanth Reddy.N
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.stericson.RootTools.RootTools;

public class MainActivity extends AppCompatActivity {

    Button check;
    Button one;
    Button three;
    Button rate;
    Button four;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RootTools.isRootAvailable()) {

                    if (RootTools.isBusyboxAvailable()){

                        Toast.makeText(MainActivity.this , "Your Device is Rooted and BusyBox is installed!" ,Toast.LENGTH_SHORT).show();}

                    else{

                        Toast.makeText(MainActivity.this , "Your Device is Rooted and BusyBox is Not installed!" ,Toast.LENGTH_SHORT).show();}


                }


                else {
                    if (RootTools.isBusyboxAvailable()){

                        Toast.makeText(MainActivity.this , "Your Device is Not Rooted and BusyBox is installed!" ,Toast.LENGTH_SHORT).show();}

                    else{

                        Toast.makeText(MainActivity.this , "Your Device is Not Rooted and BusyBox is Not installed!" ,Toast.LENGTH_SHORT).show();

                    }


                }

            }

        });

        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RootTools.isAccessGiven()) {

                        Toast.makeText(MainActivity.this , "Your Device has verified root access!" ,Toast.LENGTH_SHORT).show();}

                else {

                        Toast.makeText(MainActivity.this , "Root access seems to be Broken!" ,Toast.LENGTH_SHORT).show();}

            }

        });


         three = (Button) findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(MainActivity.this , "BusyBox Version number is " + RootTools.getBusyBoxVersion() ,Toast.LENGTH_SHORT).show();

            }

        });


        rate = (Button) findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this , "Thank You for Rating my App!" ,Toast.LENGTH_SHORT).show();
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
            }
        });

        progressbar = (ProgressBar) findViewById(R.id.spin_kit);
        CubeGrid cubegrid = new CubeGrid();
        progressbar.setIndeterminateDrawable(cubegrid);

        four = (Button) findViewById(R.id.about);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, about.class));
                finish();
            }

        });

    }


}

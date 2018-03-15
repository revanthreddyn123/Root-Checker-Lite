package com.revanth.basicrootchecker;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class about extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
    }

    public void about_back(View v) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void  license_view (View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.apache.org/licenses/LICENSE-2.0")));
    }

}

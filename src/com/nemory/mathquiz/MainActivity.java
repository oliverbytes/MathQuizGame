package com.nemory.mathquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void startQuizActivity(View view)
    {
    	startActivity(new Intent(MainActivity.this, QuizActivity.class));
    }
    
    public void click(View v)
    {
    	AlertDialog d = new AlertDialog.Builder(this).create();
		d.setCancelable(false);
		d.setTitle("About");
		d.setMessage("This game's developer is Oliver Martinez a.k.a. NemOry. This is specifically made for the Got Game Port a Thon program of RIM.");

		d.setButton(d.BUTTON_POSITIVE, "Okay",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});

		d.show();
    }
}

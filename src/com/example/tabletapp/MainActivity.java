package com.example.tabletapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mainview);
		backbuttonenable();
		showCurrentTime();
		showBestTime();
	}
	
	private void showCurrentTime() {
		Match match = Match.getInstance();
		TextView currentTime = (TextView) findViewById(R.id.textView1); 
		currentTime.setText(Integer.toString(match.getCurrentTime()));
	}
	
	private void showBestTime() {
		Match match = Match.getInstance();
		TextView bestTime = (TextView) findViewById(R.id.TextView03); 
		bestTime.setText(Integer.toString(match.getBestLapTime()));
	}
	
	public void backbuttonenable(){
		if(findViewById(R.id.back)!=null){
			ImageButton buttonback = (ImageButton) findViewById(R.id.back);
			buttonback.setOnClickListener(new Button.OnClickListener(){
				@Override
				public void onClick(View v) {
					setContentView(R.layout.activity_menu);
				}
			});
		}
	}

}

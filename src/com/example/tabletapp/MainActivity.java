package com.example.tabletapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Match match;

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mainview);
		backbuttonenable();
		match = Match.getInstance();
		showCurrentTime();
		showBestTime();
	}
	
	private void showCurrentTime() {
		TextView currentTime = (TextView) findViewById(R.id.textView1); 
		currentTime.setText(Integer.toString(match.getCurrentTime()));
	}
	
	private void showBestTime() {
		TextView bestTime = (TextView) findViewById(R.id.TextView03); 
		bestTime.setText(Integer.toString(match.getBestLapTime()));
	}
	
	private void showLane() {
		TextView lane = (TextView) findViewById(R.id.TextView05);
		String currentLane;
		if(match.getInfo().getLane())
			currentLane = "Inner";
		else
			currentLane = "Outer";
		
		lane.setText(currentLane);
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

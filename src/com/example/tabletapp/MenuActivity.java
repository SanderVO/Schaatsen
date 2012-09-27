package com.example.tabletapp;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		menubuttonenable();
	}	

	public void menubuttonenable(){
		Button buttonmain = (Button) findViewById(R.id.main);
		buttonmain.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {				
				setContentView(R.layout.mainview);
				backbuttonenable();			
				
				
				// Information
				Information i = new Information();
				i.setRacerName("kramer");
				i.setDistance(500);
				
				// Init new match
				Match m = new Match(i);
				
				// Start match
				new Thread(m).start();	
				
				
				
				
			}
		});
		Button buttongoal = (Button) findViewById(R.id.goal);
		buttongoal.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				setContentView(R.layout.goalview);
				backbuttonenable();
			}
		});
		Button buttonraceinfo = (Button) findViewById(R.id.raceinfo);
		buttonraceinfo.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				setContentView(R.layout.raceinfoview);
				backbuttonenable();
			}
		});
		Button buttoncontrol = (Button) findViewById(R.id.control);
		buttoncontrol.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				setContentView(R.layout.controlview);
				backbuttonenable();
			}
		});
	}
	public void backbuttonenable(){
		if(findViewById(R.id.back)!=null){
			ImageButton buttonback = (ImageButton) findViewById(R.id.back);
			buttonback.setOnClickListener(new Button.OnClickListener(){
				@Override
				public void onClick(View v) {
					setContentView(R.layout.activity_menu);
					menubuttonenable();
				}
			});
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_menu, menu);
		return true;

	}
}

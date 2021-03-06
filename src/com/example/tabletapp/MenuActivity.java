package com.example.tabletapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

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
				Intent intent = new Intent(MenuActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
		Button buttongoal = (Button) findViewById(R.id.goal);
		buttongoal.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, GoalActivity.class);
				startActivity(intent);
			}
		});
		Button buttongraph = (Button) findViewById(R.id.graph);
		buttongraph.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MenuActivity.this, GraphActivity.class);
				startActivity(intent);
			}
		});
		Button buttonraceinfo = (Button) findViewById(R.id.raceinfo);
		buttonraceinfo.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MenuActivity.this, RaceActivity.class);
				startActivity(i);
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
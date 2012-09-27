package com.example.tabletapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainview);
	}
	
	@Override
	public void onStart() {
		super.onStart();
	}
	
	@Override
	public void onRestart() {
		super.onRestart();
	}
	
	@Override
	public void onResume() {
		super.onResume();
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
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	@Override
	public void onStop() {
		super.onStop();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}	

}

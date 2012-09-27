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

	public DatabaseConn dbc;
	public Connection conn;
	String message;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        menubuttonenable();
        new Thread(new Runnable() {
        	public void run() {
        		dbc = new DatabaseConn();
        		dbc.sendMsg("kramer 500");
        		//while (getMessage()!="finished") {
        			setMessage(dbc.getMsg());
                	TextView t = (TextView) findViewById(R.id.TextViewDB);
                	if (getMessage()!=t.getText().toString()) {
                    	Log.i("Msg", getMessage());
                		t.setText(getMessage());
                	}
        		//}
        	}	
        }).start();
        // t = (TextView) findViewById(R.id.TextViewDB);
       //  t.setText(dbc.getMessage());
    }
    
    public void menubuttonenable(){
        Button buttonmain = (Button) findViewById(R.id.main);
    	buttonmain.setOnClickListener(new Button.OnClickListener(){
    			@Override
    			public void onClick(View v) {
    				setContentView(R.layout.mainview);
    				backbuttonenable();
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
    
    public void setMessage(String mes) {
    	this.message = mes;
    }
    
    public String getMessage() {
    	return message;
    }
    
    
}




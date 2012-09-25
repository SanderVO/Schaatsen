package com.example.tabletapp;

public class DatabaseConn {

	private static final int PORT = 9923;
	private static final String SERVER = "82.73.151.154";
	private Connection conn;
    
    // Constructor
    public DatabaseConn() {
    	conn = new Connection(SERVER, PORT);
    }  
    
    public String sendMsg(String msg) {
        conn.println(msg);
    	String line = conn.readLine();
    	return line;
    }
}
package com.example.tabletapp;

public class DatabaseConn {

	private static final int PORT = 9923;
	private static final String SERVER = "127.0.0.1";
	private Connection conn;
    
    // Constructor
    public DatabaseConn() {
    	conn = new Connection(SERVER, PORT);
    }  
    
    public void sendMsg(String msg) {
        conn.println(msg);
    }
    
    public String getMsg() {
    	String line = conn.readLine();
    	return line;
    }
}
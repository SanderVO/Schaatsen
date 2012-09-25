package com.example.tabletapp;

import java.io.*;
import java.net.*;

// Connection inner class
class Connection {

	private Socket sock;
	private String host;
	private PrintWriter out;
	private BufferedReader in;
	private int port;
	
	public Connection(String host, int port) {		
		this.host = host;
		this.port = port;		
		openConnection();
	}
	
	public void openConnection() {
		try {
			sock = new Socket(host, port);				
			out = new PrintWriter(sock.getOutputStream(), true);			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void println(String message) {		
		try {	
			out.println(message);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String readLine() {		
		try {
			return in.readLine();
		} catch (Exception e) { e.printStackTrace(); }	
		return null;
	}	
}


package javaee.jta.jdbc.atomikos.example1.impl;

import javaee.jta.jdbc.atomikos.example1.Client;

public class BasicClient implements Client {
	private int id = 0;

	public BasicClient(int id) {
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;		
	}

}

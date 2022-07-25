package com.digitalbank.service;

public class PrintService {

	PrintService service = new PrintService();
	
	private PrintService() {
		
	}
	
	public PrintService getInstance() {
		return service;
	}
	
	public void print(int i) {
	}
	
}

package com.digitalbank.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import com.digitalbank.entities.Operation;
import com.digitalbank.entities.OperationUtil;

public class PrintService {

	private static PrintService service = new PrintService();
	
	private PrintService() {
		
	}
	
	public static PrintService getInstance() {
		return service;
	}
	
	public void print(HashMap<String, List<Operation>> operations, Month month) throws IOException {
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime date = LocalDateTime.of(currentDate.getYear(), month, currentDate.getDayOfMonth(), 0, 0);
		String key = OperationUtil.getYearMonthKey(date);		
		List<Operation> monthOperations = operations.get(key);
		File file = new File("extracts\\" + key + ".txt");
		write(monthOperations, file);
		
	}
	
	private void write(List<Operation> monthOperations, File file) throws IOException {
		
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
		
		for(Operation operation: monthOperations) 
			writer.write(operation.getInfo() + "\n\n");
		
		
		writer.flush();
	}
	
	
	

	
}

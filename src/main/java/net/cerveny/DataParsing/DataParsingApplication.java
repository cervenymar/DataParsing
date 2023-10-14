package net.cerveny.DataParsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataParsingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DataParsingApplication.class, args);
		
		FileParsing fileParsing = new FileParsing();
    	fileParsing.ReadInputFile();
	}

}

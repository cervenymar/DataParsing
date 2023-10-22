package net.cerveny.DataParsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DataParsingApplication implements CommandLineRunner
{

	public static void main(String[] args)throws Exception{
		SpringApplication.run(DataParsingApplication.class, args);
	}
	public void run(String... args)throws Exception{
		FileParsing fileParsing = new FileParsing();
    	fileParsing.ReadInputFile();
		
	}

}

package net.cerveny.DataParsing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DataParsingApplication implements CommandLineRunner {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataParsingApplication.class, args);
	}

	public void run(String... args)throws Exception{
		for (int i=0;i<args.length; i++) {
			System.out.println("args[" + i + "]: " + args[i]);
		}

		
		if(args.length == 0){
			System.out.println("Missing file argument.");
		}else{
			String filePath = args[0];
			System.out.println("Reading from file: " + filePath);
			FileParsing fileParsing = new FileParsing();
    		fileParsing.ReadInputFile(filePath);
		}
		
    	//fileParsing.ReadInputFile("../../test.gpc");		
	}

}

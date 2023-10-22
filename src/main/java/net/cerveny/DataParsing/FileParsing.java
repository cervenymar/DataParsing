package net.cerveny.DataParsing;

import java.io.File; // Import the File class
import java.util.Scanner; // Import the Scanner class to read text files

public class FileParsing {
  public void ReadInputFile() throws Exception {
    File inputFile = new File("./../../../test.gpc");
    if (!inputFile.exists() || (inputFile.length() == 0)) {
      System.out.println("The input file is empty or missing.");
    } else {
      Scanner myReader = new Scanner(inputFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        switch (data.substring(0, 3)) {
          case "074":
            Statement vypis = new Statement(data);
            System.out.println("input: \n" + data);
            System.out.println("output: \n" + vypis);
            System.out.println("################################");
            break;
          case "075":
            Movement platba = new Movement(data);
            System.out.println("input: \n" + data);
            System.out.println("output: \n" + platba);
            System.out.println("################################");
            break;
          default:
            System.out.println("Unknown line case.");
            break;
        }
      }
      myReader.close();
    }

  }
}

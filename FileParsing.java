import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class FileParsing {
  public void ReadInputFile() {
    try {
      File inputFile = new File("./../../../test.gpc");
      Scanner myReader = new Scanner(inputFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        switch(data.substring(0,3)){
          case "074":           
            System.out.println(data); 
            Statement vypis = new Statement(data);            
            System.out.println(vypis+"{{"+vypis.qualifier+";"
            +vypis.accountNumber+";"
            +vypis.accountName+";"
            +vypis.oldBalanceDate+";"
            +vypis.oldBalanceValue+";"
            +vypis.oldBalanceChar+"}}");
          break;
          case "075":
            Payment platba = new Payment(data);
            System.out.println(data);
            System.out.println(platba+"{{"+platba.qualifier+";"+platba.accountNumber+"}}");
          break;
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    
  }
  
}



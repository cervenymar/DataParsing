package net.cerveny.DataParsing;
import java.text.SimpleDateFormat; 
import java.util.Date;

public class Statement {  
        byte qualifier;
        long accountNumber;
        String accountName;
        Date oldBalanceDate;
        double oldBalanceValue;
        char oldBalanceChar;
        double newBalanceValue;
        char newBalanceChar;
        double debitTurnOver;
        char debitTurnOverChar;
        double creditTurnOver;
        char creditTurnOverChar;
        short statementSerialNumber;
        Date billingDate;
        String emptySpace;      

        public Statement(String data)throws Exception{
            this.qualifier = Byte.parseByte(data.substring(0,3));
            this.accountNumber = Long.parseLong(data.substring(3,19));
            this.accountName    = data.substring(19,39).trim();
            this.oldBalanceDate = StringToDate(data.substring(39,45));
            this.oldBalanceValue = (Double.parseDouble(data.substring(45, 59))/100);
            this.oldBalanceChar = data.charAt(59);
            this.newBalanceValue = (Double.parseDouble(data.substring(60,74))/100);
            this.newBalanceChar = data.charAt(74);
            this.debitTurnOver = (Double.parseDouble(data.substring(75,89))/100);
            this.debitTurnOverChar = data.charAt(89);
            this.creditTurnOver = (Double.parseDouble(data.substring(90,104))/100);
            this.creditTurnOverChar = data.charAt(104);
            this.statementSerialNumber = Short.parseShort(data.substring(105,108));
            this.billingDate = StringToDate(data.substring(108,114));
            this.emptySpace = data.substring(114,128).trim();            
        }
        public String toString() {
            //System.out.println(vypis+"{{"+vypis.qualifier+";"+vypis.accountNumber+";"+vypis.accountName+";"+vypis.oldBalanceDate+";"+vypis.oldBalanceValue+";"+vypis.oldBalanceChar+"}}");
            return String.format("{\"qualifier\":\"%s\",\"accountNumber\":\"%s\",\"accountName\":\"%s\",\"oldBalanceDate\":\"%s\",\"oldBalanceValue\":\"%s\",\"oldBalanceChar\":\"%s\",\"newBalanceValue\":\"%s\",\"newBalanceChar\":\"%s\",\"debitTurnOver\":\"%s\",\"debitTurnOverChar\":\"%s\",\"creditTurnOver\":\"%s\",\"creditTurnOverChar\":\"%s\",\"statementSerialNumber\":\"%s\",\"billingDate\":\"%s\",\"emptySpace \":\"%s\"}",this.qualifier,this.accountNumber,this.accountName,this.oldBalanceDate,this.oldBalanceValue,this.oldBalanceChar,this.newBalanceValue,this.newBalanceChar,this.debitTurnOver,this.debitTurnOverChar,this.creditTurnOver,this.creditTurnOverChar,this.statementSerialNumber,this.billingDate,this.emptySpace );
        }   
        public Date StringToDate(String input)throws Exception{
            SimpleDateFormat formatter=new SimpleDateFormat("ddMMyy");
            return formatter.parse(input);
        }
    }


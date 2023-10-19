package net.cerveny.DataParsing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movement {
        byte qualifier;
        long assignedAccountNumber;
        double accountNumber;
        double documentNumber;
        double ammount;
        byte billingCode;
        double variableSymbol;
        double constantSymbol;
        double specificSymbol;       
        String clientName;        
        short currencyCode;
        Date dueDate;
        
    public Movement(String data)throws Exception{
        this.qualifier = Byte.parseByte(data.substring(0,3));
        this.assignedAccountNumber = Long.parseLong(data.substring(3,19));
        this.accountNumber    = Double.parseDouble(data.substring(19,35));
        this.documentNumber = Double.parseDouble(data.substring(35,48));
        this.ammount = Double.parseDouble(data.substring(48, 60));
        this.billingCode = Byte.parseByte(data.substring(60,61));
        this.variableSymbol = Double.parseDouble(data.substring(61,71));
        this.constantSymbol = Double.parseDouble(data.substring(71,81));
        this.specificSymbol = Double.parseDouble(data.substring(81,91));        
        this.clientName = data.substring(97,117);        
        this.currencyCode = Short.parseShort(data.substring(118,122));
        this.dueDate = StringToDate(data.substring(122,128));                    
    }    
    public String toString() {        
        return String.format("{\"qualifier\":\"%s\",\"assignedAccountNumber\":\"%s\",\"accountNumber\":\"%s\",\"documentNumber\":\"%s\",\"ammount\":\"%s\",\"billingCode\":\"%s\",\"variableSymbol\":\"%s\",\"constantSymbol\":\"%s\",\"specificSymbol\":\"%s\",\"clientName\":\"%s\",\"currencyCode\":\"%s\",\"dueDate\":\"%s\"}",this.qualifier,this.assignedAccountNumber,this.accountNumber,this.documentNumber,this.ammount,this.billingCode,this.variableSymbol,this.constantSymbol,this.specificSymbol,this.clientName,this.currencyCode,this.dueDate);
    }
    public Date StringToDate(String input)throws Exception{
            SimpleDateFormat formatter=new SimpleDateFormat("ddMMyy");
            return formatter.parse(input);
        } 
}


package net.cerveny.DataParsing;

public class Payment {
    String qualifier;
        String assignedAccountNumber;
        String accountNumber;
        String documentNumber;
        String ammount;
        String billingCode;
        String variableSymbol;
        String constantSymbol;
        String specificSymbol;       
        String clientName;        
        String currencyCode;
        String dueDate;
        
    public Payment(String data){
        this.qualifier = data.substring(0,3);
        this.assignedAccountNumber = data.substring(3,19);
        this.accountNumber    = data.substring(19,35);
        this.documentNumber = data.substring(35,48);
        this.ammount = data.substring(48, 60);
        this.billingCode = data.substring(60,61);
        this.variableSymbol = data.substring(61,71);
        this.constantSymbol = data.substring(71,81);
        this.specificSymbol = data.substring(81,91);        
        this.clientName = data.substring(97,117);        
        this.currencyCode = data.substring(118,122);
        this.dueDate = data.substring(122,128);                    
    } 
    
    public String getQualifier(){
        return qualifier;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
}

